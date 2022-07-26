package com.conurets.hcm.persistence.dao.impl;

import com.conurets.hcm.base.exception.HCMException;
import com.conurets.hcm.base.util.HCMConstants;
import com.conurets.hcm.persistence.dao.PersistentLoginDAO;
import com.conurets.hcm.persistence.entity.PersistentLogin;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

/**
 * @author MSA
 * @version 1.0
 */

@Slf4j
@Repository
public class PersistentLoginDAOImpl extends BaseDAOImpl<PersistentLogin> implements PersistentLoginDAO {
    /**
     *
     * @param userId
     * @param type
     * @return
     * @throws HCMException
     */
    public PersistentLogin findByUserIdAndType(long userId, String type) throws HCMException {
        StringBuilder jpql = new StringBuilder();
        jpql.append("FROM PersistentLogin pl ");
        jpql.append("WHERE pl.user.id = :userId ");
        jpql.append("AND pl.type = :type ");
        jpql.append("AND pl.status = :status ");

        TypedQuery<PersistentLogin> query = getEntityManager().createQuery(jpql.toString(), PersistentLogin.class);
        query.setParameter("userId", userId);
        query.setParameter("type", type);
        query.setParameter("status", HCMConstants.Common.STATUS_CODE_ACTIVE);

        return getSingleResult(query);
    }

    /**
     *
     * @param userId
     * @return
     * @throws HCMException
     */
    public List<PersistentLogin> findAllByUserId(long userId) throws HCMException {
        StringBuilder jpql = new StringBuilder();
        jpql.append("FROM PersistentLogin pl ");
        jpql.append("WHERE pl.user.id = :userId ");

        TypedQuery<PersistentLogin> query = getEntityManager().createQuery(jpql.toString(), PersistentLogin.class);
        query.setParameter("userId", userId);

        return getResultList(query);
    }
}