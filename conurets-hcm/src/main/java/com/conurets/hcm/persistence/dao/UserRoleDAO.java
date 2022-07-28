package com.conurets.hcm.persistence.dao;

import com.conurets.hcm.base.exception.HCMException;
import com.conurets.hcm.persistence.entity.UserRole;

import java.util.List;

/**
 * @author MSA
 * @version 1.0
 */

public interface UserRoleDAO extends BaseDAO<UserRole> {
    List<UserRole> findByUserId(long userId) throws HCMException;

    UserRole findByIds(long userId, long roleId) throws HCMException;
}