package com.conurets.hcm.persistence.dao;

import com.conurets.hcm.base.exception.HCMException;
import com.conurets.hcm.persistence.entity.RolePrivilege;

import java.util.List;

/**
 * @author MSA
 * @version 1.0
 */

public interface RolePrivilegeDAO extends BaseDAO<RolePrivilege> {
    List<RolePrivilege> findByRoleId(long roleId) throws HCMException;

    RolePrivilege findByIds(long roleId, long privilegeId) throws HCMException;
}