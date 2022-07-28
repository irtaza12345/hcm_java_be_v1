package com.conurets.hcm.persistence.dao.impl;

import com.conurets.hcm.base.exception.HCMException;
import com.conurets.hcm.base.util.HCMConstants;
import com.conurets.hcm.base.util.HCMUtil;
import com.conurets.hcm.persistence.dao.DepartmentDAO;
import com.conurets.hcm.persistence.entity.Department;
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
public class DepartmentDAOImpl extends BaseDAOImpl<Department> implements DepartmentDAO {
    /**
     * Find by organization id
     *
     * @param organizationId
     * @return
     * @throws HCMException
     */
    public List<Department> findByOrganizationId(long organizationId) throws HCMException {
        final StringBuilder jpql = new StringBuilder();
        jpql.append("FROM Department d ");
        jpql.append("WHERE d.organization.id = :organizationId ");
        jpql.append("AND d.organization.status = :organizationStatus ");
        jpql.append("AND d.status IN :status ");

        TypedQuery<Department> query = getEntityManager().createQuery(jpql.toString(), Department.class);
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
    public List<Department> findByBranchId(long branchId) throws HCMException {
        final StringBuilder jpql = new StringBuilder();
        jpql.append("FROM Department d ");
        jpql.append("WHERE d.branch.id = :branchId ");
        jpql.append("AND d.branch.status = :branchStatus ");
        jpql.append("AND d.status IN :status ");

        TypedQuery<Department> query = getEntityManager().createQuery(jpql.toString(), Department.class);
        query.setParameter("branchId", branchId);
        query.setParameter("branchStatus", HCMConstants.Common.STATUS_CODE_ACTIVE);
        query.setParameter("status", HCMUtil.getDBResultStatus());

        return getResultList(query);
    }
}