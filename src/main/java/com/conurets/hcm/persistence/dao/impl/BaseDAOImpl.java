package com.conurets.hcm.persistence.dao.impl;

import com.conurets.hcm.base.exception.HCMException;
import com.conurets.hcm.base.util.HCMConstants;
import com.conurets.hcm.base.util.HCMDateUtil;
import com.conurets.hcm.base.util.HCMUtil;
import com.conurets.hcm.persistence.dao.BaseDAO;
import com.conurets.hcm.persistence.entity.BaseEntity;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import javax.transaction.Transactional;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

/**
 * @author MSA
 * @version 1.0
 */

@Slf4j
@Transactional
public abstract class BaseDAOImpl<E extends BaseEntity> implements BaseDAO<E> {
    @PersistenceContext
    private EntityManager entityManager;
    private Class<E> entityClass;

    /**
     * Constructor
     */
    public BaseDAOImpl() {
        this.entityClass = (Class<E>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    /**
     * Save data
     *
     * @param entity
     * @throws HCMException
     */
    public void save(E entity) throws HCMException {
        //addAuditingInformation(entity);

        getEntityManager().persist(entity);
    }

    /**
     * Save and update data
     *
     * @param entity
     * @throws HCMException
     */
    public void saveOrUpdate(E entity) throws HCMException {
        //addAuditingInformation(entity);

        getEntityManager().merge(entity);
    }

    /**
     * Update date
     *
     * @param entity
     * @throws HCMException
     */
    public void update(E entity) throws HCMException {
        //addAuditingInformation(entity);

        getEntityManager().merge(entity);
    }

    /**
     * Delete data
     *
     * @param entity
     * @throws HCMException
     */
    public void delete(E entity) throws HCMException {
        getEntityManager().remove(entity);
    }

    /**
     * Find by id
     *
     * @param id
     * @return
     * @throws HCMException
     */
    public E findById(long id) throws HCMException {
        return getEntityManager().find(getEntityClass(), id);
    }

    /**
     * Find all data
     *
     * @return
     * @throws HCMException
     */
    public List<E> findAll() throws HCMException {
        return getResultList(createQuery(null));
    }

    /**
     * Find data by status
     *
     * @param status
     * @return
     * @throws HCMException
     */
    public List<E> findAll(List<Integer> status) throws HCMException {
        return getResultList(createQuery(status));
    }

    /**
     * Find by key and value
     *
     * @param key
     * @param value
     * @return
     * @throws HCMException
     */
    public E findByKeyValue(String key, Object value) throws HCMException {
        return getSingleResult(createQueryByKeyValue(getEntityClass(), key, value));
    }

    /**
     * Find all by key and value
     *
     * @param key
     * @param value
     * @return
     * @throws HCMException
     */
    public List<E> findAllByKeyValue(String key, Object value) throws HCMException {
        return getResultList(createQueryByKeyValue(getEntityClass(), key, value));
    }

    /**
     * Create query by status
     *
     * @return
     */
    private TypedQuery<E> createQuery(List<Integer> statusList) throws HCMException {
        CriteriaBuilder criteriaBuilder = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<E> criteriaQuery = criteriaBuilder.createQuery(getEntityClass());

        Root<E> root = criteriaQuery.from(getEntityClass());
        criteriaQuery.select(root);

        if (HCMUtil.isCollectionNotBlank(statusList)) {
            Expression<Integer> parentExpression = root.get("status");
            Predicate parentPredicate = parentExpression.in(statusList);
            criteriaQuery.where(parentPredicate);
        }

        List<Order> orderList = new ArrayList<>();
        orderList.add(criteriaBuilder.desc(root.get("id")));

        criteriaQuery.orderBy(orderList);

        return getEntityManager().createQuery(criteriaQuery);
    }

    /**
     * Create query by key and value
     *
     * @param key
     * @param value
     * @return
     */
    protected TypedQuery<E> createQueryByKeyValue(Class<E> entityClass, String key, Object value) throws HCMException {
        CriteriaBuilder criteriaBuilder = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<E> criteriaQuery = criteriaBuilder.createQuery(entityClass);

        Root<E> root = criteriaQuery.from(entityClass);

        if (value instanceof String) {
            Expression<String> path = root.get(key);
            Expression<String> upper = criteriaBuilder.upper(path);

            criteriaQuery.select(root).where(criteriaBuilder.like(upper, value.toString().toUpperCase()));
        } else {
            criteriaQuery.select(root).where(criteriaBuilder.equal(root.get(key), value));
        }

        List<Order> orderList = new ArrayList<>();
        orderList.add(criteriaBuilder.desc(root.get("id")));

        criteriaQuery.orderBy(orderList);

        return getEntityManager().createQuery(criteriaQuery);
    }

    /**
     * Set createdBy createdDate, lastUpdate, updateBy params
     *
     * @param object
     * @return
     */
    protected final E addAuditingInformation(E object) throws HCMException {
        if (object.getId() == null) {
            object.setCreatedDate(HCMDateUtil.getCurrentTimestamp());
            object.setCreatedBy(object.getCreatedBy());
        } else {
            object.setLastUpdate(HCMDateUtil.getCurrentTimestamp());
            object.setLastUpdateBy(object.getLastUpdateBy());
        }

        return object;
    }

    /**
     * Find single result
     *
     * @param query
     * @return
     */
    public E getSingleResult(Query query) {
        E object = null;

        if (HCMUtil.isCollectionNotBlank(query.getResultList())) {
            object = (E) query.getResultList().get(HCMConstants.Common.INT_ZERO);
        }

        return object;
    }

    /**
     * Find result list
     *
     * @param query
     * @return
     */
    public List<E> getResultList(Query query) throws HCMException {
        List<E> object = null;

        if (HCMUtil.isCollectionNotBlank(query.getResultList())) {
            object = (List<E>) query.getResultList();
        }

        return object;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public Class<E> getEntityClass() {
        return entityClass;
    }
}
