package com.conurets.hcm.commons.persistence.dao;

import com.conurets.hcm.commons.base.exception.HCMException;
import com.conurets.hcm.commons.persistence.entity.UserRole;

import java.util.List;

/**
 * @author MSA
 * @version 1.0
 */

public interface UserRoleDAO extends BaseDAO<UserRole> {
    List<UserRole> findByUserId(long userId) throws HCMException;

    UserRole findByIds(long userId, long roleId) throws HCMException;
}