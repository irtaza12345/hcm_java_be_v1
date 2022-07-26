package com.conurets.hcm.persistence.dao;

import com.conurets.hcm.base.exception.HCMException;
import com.conurets.hcm.persistence.entity.Role;

import java.util.List;

/**
 * @author SHF
 * @version 1.0
 */

public interface RoleDAO extends BaseDAO<Role> {
    List<Role> findActiveOrganizationRoles() throws HCMException;

    List<Role> findRoleByOrganizationId(long organizationId) throws HCMException;

    List<Role> findRoleByBranchId(long branchId) throws HCMException;
}