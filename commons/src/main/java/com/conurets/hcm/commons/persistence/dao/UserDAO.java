package com.conurets.hcm.commons.persistence.dao;

import com.conurets.hcm.commons.base.exception.HCMException;
import com.conurets.hcm.commons.persistence.entity.User;

import java.util.List;

/**
 * @author MSA
 * @version 1.0
 */

public interface UserDAO extends BaseDAO<User> {
    User findByEmailAddress(String emailAddress) throws HCMException;

    List<User> findByOrganizationId(long organizationId) throws HCMException;

    List<User> findByBranchId(long branchId) throws HCMException;
}