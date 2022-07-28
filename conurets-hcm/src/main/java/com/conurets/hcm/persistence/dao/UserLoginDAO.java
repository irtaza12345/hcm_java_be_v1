package com.conurets.hcm.persistence.dao;

import com.conurets.hcm.base.exception.HCMException;
import com.conurets.hcm.persistence.entity.UserLogin;

/**
 * @author MSA
 * @version 1.0
 */

public interface UserLoginDAO extends BaseDAO<UserLogin> {
    UserLogin findByUserId(long userId) throws HCMException;
}