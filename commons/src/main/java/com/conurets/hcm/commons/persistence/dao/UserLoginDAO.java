package com.conurets.hcm.commons.persistence.dao;


import com.conurets.hcm.commons.base.exception.HCMException;
import com.conurets.hcm.commons.persistence.entity.UserLogin;

/**
 * @author MSA
 * @version 1.0
 */

public interface UserLoginDAO extends BaseDAO<UserLogin> {
    UserLogin findByUserId(long userId) throws HCMException;
}