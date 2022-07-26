package com.conurets.hcm.persistence.dao.impl;

import com.conurets.hcm.base.exception.HCMException;
import com.conurets.hcm.base.util.HCMUtil;
import com.conurets.hcm.persistence.dao.PreferenceDAO;
import com.conurets.hcm.persistence.entity.Preference;
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
public class PreferenceDAOImpl extends BaseDAOImpl<Preference> implements PreferenceDAO {
    /**
     * Find by organization id
     *
     * @param organizationId
     * @return
     * @throws HCMException
     */
    public List<Preference> findByOrganizationId(long organizationId) throws HCMException {
        StringBuilder hqlQuery = new StringBuilder();
        hqlQuery.append("FROM Preference p ");
        hqlQuery.append("WHERE p.organization.id = :organizationId ");
        hqlQuery.append("AND p.status IN :status ");

        TypedQuery<Preference> query = getEntityManager().createQuery(hqlQuery.toString(), Preference.class);
        query.setParameter("organizationId", organizationId);
        query.setParameter("status", HCMUtil.getDBResultStatus());

        return getResultList(query);
    }

    /**
     * Find by organization id
     *
     * @param branchId
     * @return
     * @throws HCMException
     */
    public List<Preference> findByBranchId(long branchId) throws HCMException {
        StringBuilder hqlQuery = new StringBuilder();
        hqlQuery.append("FROM Preference p ");
        hqlQuery.append("WHERE p.branch.id = :branchId ");
        hqlQuery.append("AND p.status IN :status ");

        TypedQuery<Preference> query = getEntityManager().createQuery(hqlQuery.toString(), Preference.class);
        query.setParameter("branchId", branchId);
        query.setParameter("status", HCMUtil.getDBResultStatus());

        return getResultList(query);
    }
}