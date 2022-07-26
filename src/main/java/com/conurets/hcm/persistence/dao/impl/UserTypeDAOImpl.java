package com.conurets.hcm.persistence.dao.impl;

import com.conurets.hcm.base.exception.HCMException;
import com.conurets.hcm.base.util.HCMConstants;
import com.conurets.hcm.base.util.HCMUtil;
import com.conurets.hcm.persistence.dao.UserTypeDAO;
import com.conurets.hcm.persistence.entity.UserType;
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
public class UserTypeDAOImpl extends BaseDAOImpl<UserType> implements UserTypeDAO {
    /**
     * Find by organization id
     *
     * @param organizationId
     * @return
     * @throws HCMException
     */
    public List<UserType> findByOrganizationId(long organizationId) throws HCMException {
        final StringBuilder jpql = new StringBuilder();
        jpql.append("FROM UserType u ");
        jpql.append("WHERE u.organization.id = :organizationId ");
        jpql.append("AND u.organization.status = :organizationStatus ");
        jpql.append("AND u.status IN :status ");

        TypedQuery<UserType> query = getEntityManager().createQuery(jpql.toString(), UserType.class);
        query.setParameter("organizationId", organizationId);
        query.setParameter("organizationStatus", HCMConstants.Common.STATUS_CODE_ACTIVE);
        query.setParameter("status", HCMUtil.getDBResultStatus());

        return getResultList(query);
    }

    /**
     * Find by branch id
     *
     * @param branchId
     * @return
     * @throws HCMException
     */
    public List<UserType> findByBranchId(long branchId) throws HCMException {
        final StringBuilder jpql = new StringBuilder();
        jpql.append("FROM UserType u ");
        jpql.append("WHERE u.branch.id = :branchId ");
        jpql.append("AND u.branch.status = :branchStatus ");
        jpql.append("AND u.status IN :status ");

        TypedQuery<UserType> query = getEntityManager().createQuery(jpql.toString(), UserType.class);
        query.setParameter("branchId", branchId);
        query.setParameter("branchStatus", HCMConstants.Common.STATUS_CODE_ACTIVE);
        query.setParameter("status", HCMUtil.getDBResultStatus());

        return getResultList(query);
    }
}