package com.conurets.hcm.commons.persistence.dao.impl;


import com.conurets.hcm.commons.base.exception.HCMException;
import com.conurets.hcm.commons.base.util.HCMConstants;
import com.conurets.hcm.commons.base.util.HCMUtil;
import com.conurets.hcm.commons.persistence.dao.RoleDAO;
import com.conurets.hcm.commons.persistence.entity.Role;
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
public class RoleDAOImpl extends BaseDAOImpl<Role> implements RoleDAO {
    /**
     * @return
     * @throws HCMException
     */
    public List<Role> findActiveOrganizationRoles() throws HCMException {
        StringBuilder jpql = new StringBuilder();
        jpql.append("FROM Role r ");
        jpql.append("WHERE r.status = :statusRole ");
        jpql.append("AND r.organization.status = :statusOrganization ");

        TypedQuery<Role> query = getEntityManager().createQuery(jpql.toString(), Role.class);
        query.setParameter("statusRole", HCMConstants.Common.STATUS_CODE_ACTIVE);
        query.setParameter("statusOrganization", HCMConstants.Common.STATUS_CODE_ACTIVE);

        return getResultList(query);
    }

    /**
     *
     * @param organizationId
     * @return
     * @throws HCMException
     */
    public List<Role> findRoleByOrganizationId(long organizationId) throws HCMException {
        StringBuilder jpql = new StringBuilder();
        jpql.append("FROM Role r ");
        jpql.append("WHERE r.organization.id = :organizationId ");
        jpql.append("AND r.organization.status = :statusOrganization ");
        jpql.append("AND r.status IN :status ");

        TypedQuery<Role> query = getEntityManager().createQuery(jpql.toString(), Role.class);
        query.setParameter("organizationId", organizationId);
        query.setParameter("statusOrganization", HCMConstants.Common.STATUS_CODE_ACTIVE);
        query.setParameter("status", HCMUtil.getDBResultStatus());

        return getResultList(query);
    }

    /**
     *
     * @param branchId
     * @return
     * @throws HCMException
     */
    public List<Role> findRoleByBranchId(long branchId) throws HCMException {
        StringBuilder jpql = new StringBuilder();
        jpql.append("FROM Role r ");
        jpql.append("WHERE r.branch.id = :branchId ");
        jpql.append("AND r.branch.status = :statusBranch ");
        jpql.append("AND r.status IN :status ");

        TypedQuery<Role> query = getEntityManager().createQuery(jpql.toString(), Role.class);
        query.setParameter("branchId", branchId);
        query.setParameter("statusBranch", HCMConstants.Common.STATUS_CODE_ACTIVE);
        query.setParameter("status", HCMUtil.getDBResultStatus());

        return getResultList(query);
    }
}