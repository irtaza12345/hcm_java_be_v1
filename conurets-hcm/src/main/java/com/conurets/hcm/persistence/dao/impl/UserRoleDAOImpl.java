package com.conurets.hcm.persistence.dao.impl;

import com.conurets.hcm.base.exception.HCMException;
import com.conurets.hcm.base.util.HCMConstants;
import com.conurets.hcm.base.util.HCMUtil;
import com.conurets.hcm.persistence.dao.UserRoleDAO;
import com.conurets.hcm.persistence.entity.UserRole;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * @author MSA
 * @version 1.0
 */

@Slf4j
@Repository
public class UserRoleDAOImpl extends BaseDAOImpl<UserRole> implements UserRoleDAO {
    /**
     * Find by user id
     *
     * @param userId
     * @return
     * @throws HCMException
     */
    public List<UserRole> findByUserId(long userId) throws HCMException {
        StringBuilder jpql = new StringBuilder();
        jpql.append("SELECT ur FROM UserRole ur ");
        jpql.append("WHERE ur.user.id = :userId ");
        jpql.append("AND ur.status = :status ");
        jpql.append("AND ur.user.status = :userStatus ");

        TypedQuery<UserRole> query = getEntityManager().createQuery(jpql.toString(), UserRole.class);
        query.setParameter("userId", userId);
        query.setParameter("status", HCMConstants.Common.STATUS_CODE_ACTIVE);
        query.setParameter("userStatus", HCMConstants.Common.STATUS_CODE_ACTIVE);

        return getResultList(query);
    }

    /**
     * Find by ids
     *
     * @param userId
     * @param roleId
     * @return
     * @throws HCMException
     */
    public UserRole findByIds(long userId, long roleId) throws HCMException {
        StringBuilder jpql = new StringBuilder();
        jpql.append("SELECT ur FROM UserRole ur ");
        jpql.append("WHERE ur.user.id = :userId ");
        jpql.append("AND ur.role.id = :roleId ");
        jpql.append("AND ur.status = :status ");
        jpql.append("AND ur.user.status = :userStatus ");

        Query query = getEntityManager().createQuery(jpql.toString(), UserRole.class);
        query.setParameter("userId", userId);
        query.setParameter("roleId", roleId);
        query.setParameter("status", HCMConstants.Common.STATUS_CODE_ACTIVE);
        query.setParameter("userStatus", HCMConstants.Common.STATUS_CODE_ACTIVE);

        return getSingleResult(query);
    }

    /**
     * Find by organization id
     *
     * @param organizationId
     * @return
     * @throws HCMException
     */
    public List<UserRole> findByOrganizationId(long organizationId) throws HCMException {
        final StringBuilder jpql = new StringBuilder();
        jpql.append("FROM UserRole ur ");
        jpql.append("WHERE ur.organization.id = :organizationId ");
        jpql.append("AND ur.organization.status = :organizationStatus ");
        jpql.append("AND ur.status IN :status ");

        TypedQuery<UserRole> query = getEntityManager().createQuery(jpql.toString(), UserRole.class);
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
    public List<UserRole> findByBranchId(long branchId) throws HCMException {
        final StringBuilder jpql = new StringBuilder();
        jpql.append("FROM UserRole ur ");
        jpql.append("WHERE ur.branch.id = :branchId ");
        jpql.append("AND ur.branch.status = :branchStatus ");
        jpql.append("AND ur.status IN :status ");

        TypedQuery<UserRole> query = getEntityManager().createQuery(jpql.toString(), UserRole.class);
        query.setParameter("branchId", branchId);
        query.setParameter("branchStatus", HCMConstants.Common.STATUS_CODE_ACTIVE);
        query.setParameter("status", HCMUtil.getDBResultStatus());

        return getResultList(query);
    }
}