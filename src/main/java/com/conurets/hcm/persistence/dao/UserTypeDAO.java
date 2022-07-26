package com.conurets.hcm.persistence.dao;

import com.conurets.hcm.base.exception.HCMException;
import com.conurets.hcm.persistence.entity.UserType;

import java.util.List;

/**
 * @author MSA
 * @version 1.0
 */

public interface UserTypeDAO extends BaseDAO<UserType> {
    List<UserType> findByOrganizationId(long organizationId) throws HCMException;

    List<UserType> findByBranchId(long branchId) throws HCMException;
}