package com.conurets.hcm.persistence.dao;

import com.conurets.hcm.base.exception.HCMException;
import com.conurets.hcm.persistence.entity.PersistentLogin;

import java.util.List;

/**
 * @author MSA
 * @version 1.0
 */

public interface PersistentLoginDAO extends BaseDAO<PersistentLogin> {
    PersistentLogin findByUserIdAndType(long userId, String type) throws HCMException;

    List<PersistentLogin> findAllByUserId(long userId) throws HCMException;
}