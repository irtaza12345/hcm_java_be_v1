package com.conurets.hcm.persistence.dao.impl;

import com.conurets.hcm.base.exception.HCMException;
import com.conurets.hcm.base.util.HCMConstants;
import com.conurets.hcm.persistence.dao.MenuDAO;
import com.conurets.hcm.persistence.entity.Menu;
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
public class MenuDAOImpl extends BaseDAOImpl<Menu> implements MenuDAO {
    /**
     *
     * @return
     * @throws HCMException
     */
    public List<Menu> findAllParentMenu() throws HCMException {
        StringBuilder hqlQuery = new StringBuilder();
        hqlQuery.append("FROM Menu mp ");
        hqlQuery.append("WHERE mp.parentMenu = null ");
        hqlQuery.append("AND mp.status = :status ");
        hqlQuery.append("ORDER BY mp.menuSequence ASC ");

        TypedQuery<Menu> query = getEntityManager().createQuery(hqlQuery.toString(), Menu.class);
        query.setParameter("status", HCMConstants.Common.STATUS_CODE_ACTIVE);

        return getResultList(query);
    }

    /**
     *
     * @param organizationId
     * @return
     * @throws HCMException
     */
    public List<Menu> findParentMenuByOrganizationId(long organizationId) throws HCMException {
        StringBuilder hqlQuery = new StringBuilder();
        hqlQuery.append("FROM Menu mp ");
        hqlQuery.append("WHERE mp.parentMenu = null ");
        hqlQuery.append("AND mp.organization.id = :organizationId ");
        hqlQuery.append("AND mp.status = :status ");
        hqlQuery.append("ORDER BY mp.menuSequence ASC ");

        TypedQuery<Menu> query = getEntityManager().createQuery(hqlQuery.toString(), Menu.class);
        query.setParameter("organizationId", organizationId);
        query.setParameter("status", HCMConstants.Common.STATUS_CODE_ACTIVE);

        return getResultList(query);
    }

    /**
     *
     * @param organizationId
     * @return
     * @throws HCMException
     */
    public List<Menu> findMenuByOrganizationId(long organizationId) throws HCMException {
        StringBuilder hqlQuery = new StringBuilder();
        hqlQuery.append("FROM Menu mp ");
        hqlQuery.append("WHERE mp.parentMenu != null ");
        hqlQuery.append("AND mp.organization.id = :organizationId ");
        hqlQuery.append("AND mp.status = :status ");
        hqlQuery.append("ORDER BY mp.menuSequence ASC ");

        TypedQuery<Menu> query = getEntityManager().createQuery(hqlQuery.toString(), Menu.class);
        query.setParameter("organizationId", organizationId);
        query.setParameter("status", HCMConstants.Common.STATUS_CODE_ACTIVE);

        return getResultList(query);
    }
}