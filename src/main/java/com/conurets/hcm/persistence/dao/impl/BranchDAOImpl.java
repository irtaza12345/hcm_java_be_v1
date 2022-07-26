package com.conurets.hcm.persistence.dao.impl;

import com.conurets.hcm.base.exception.HCMException;
import com.conurets.hcm.base.util.HCMConstants;
import com.conurets.hcm.persistence.dao.BranchDAO;
import com.conurets.hcm.persistence.entity.Branch;
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
public class BranchDAOImpl extends BaseDAOImpl<Branch> implements BranchDAO {
    /**
     * Find by company id and branch code
     *
     * @param companyId
     * @param branchCode
     * @return
     * @throws HCMException
     */
    public Branch findByCompanyIdAndBranchCode(long companyId, String branchCode) throws HCMException {
        final StringBuilder jpql = new StringBuilder();
        jpql.append("FROM Branch b ");
        jpql.append("WHERE b.company.id = :companyId ");
        jpql.append("AND b.branchCode = :branchCode ");
        jpql.append("AND b.organization.status = :organizationStatus ");
        jpql.append("AND b.status = :status ");

        TypedQuery<Branch> query = getEntityManager().createQuery(jpql.toString(), Branch.class);
        query.setParameter("companyId", companyId);
        query.setParameter("branchCode", branchCode);
        query.setParameter("organizationStatus", HCMConstants.Common.STATUS_CODE_ACTIVE);
        query.setParameter("status", HCMConstants.Common.STATUS_CODE_ACTIVE);

        return getSingleResult(query);
    }

    /**
     * Find by organization id
     *
     * @param organizationId
     * @return
     * @throws HCMException
     */
    public List<Branch> findByOrganizationId(long organizationId) throws HCMException {
        final StringBuilder jpql = new StringBuilder();
        jpql.append("FROM Branch b ");
        jpql.append("WHERE b.organization.id = :organizationId ");
        jpql.append("AND b.organization.status = :organizationStatus ");
        jpql.append("AND b.status = :status ");

        TypedQuery<Branch> query = getEntityManager().createQuery(jpql.toString(), Branch.class);
        query.setParameter("organizationId", organizationId);
        query.setParameter("organizationStatus", HCMConstants.Common.STATUS_CODE_ACTIVE);
        query.setParameter("status", HCMConstants.Common.STATUS_CODE_ACTIVE);

        return getResultList(query);
    }

    /**
     * Find by company id
     *
     * @param companyId
     * @return
     * @throws HCMException
     */
    public List<Branch> findByCompanyId(long companyId) throws HCMException {
        final StringBuilder jpql = new StringBuilder();
        jpql.append("FROM Branch b ");
        jpql.append("WHERE b.company.id = :companyId ");
        jpql.append("AND b.company.status = :companyStatus ");
        jpql.append("AND b.status = :status ");

        TypedQuery<Branch> query = getEntityManager().createQuery(jpql.toString(), Branch.class);
        query.setParameter("companyId", companyId);
        query.setParameter("companyStatus", HCMConstants.Common.STATUS_CODE_ACTIVE);
        query.setParameter("status", HCMConstants.Common.STATUS_CODE_ACTIVE);

        return getResultList(query);
    }
}