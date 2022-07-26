package com.conurets.hcm.persistence.dao;

import com.conurets.hcm.base.exception.HCMException;
import com.conurets.hcm.persistence.entity.UserPrivilege;

import java.util.List;

/**
 * @author MSA
 * @version 1.0
 */

public interface UserPrivilegeDAO extends BaseDAO<UserPrivilege> {
    List<UserPrivilege> findByUserId(long userId) throws HCMException;

    UserPrivilege findActivePrivilegeByIds(long privilegeId, long organizationId, long userId) throws HCMException;
}