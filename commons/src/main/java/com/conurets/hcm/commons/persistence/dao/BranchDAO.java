package com.conurets.hcm.commons.persistence.dao;

import com.conurets.hcm.commons.base.exception.HCMException;
import com.conurets.hcm.commons.persistence.entity.Branch;

import java.util.List;

/**
 * @author MSA
 * @version 1.0
 */

public interface BranchDAO extends BaseDAO<Branch> {
    Branch findByCompanyIdAndBranchCode(long companyId, String branchCode) throws HCMException;

    List<Branch> findByOrganizationId(long organizationId) throws HCMException;

    List<Branch> findByCompanyId(long companyId) throws HCMException;
}