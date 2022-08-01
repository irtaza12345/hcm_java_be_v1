package com.conurets.hcm.commons.persistence.dao;

import com.conurets.hcm.commons.base.exception.HCMException;
import com.conurets.hcm.commons.persistence.entity.UserType;

import java.util.List;

/**
 * @author MSA
 * @version 1.0
 */

public interface UserTypeDAO extends BaseDAO<UserType> {
    List<UserType> findByOrganizationId(long organizationId) throws HCMException;

    List<UserType> findByBranchId(long branchId) throws HCMException;
}