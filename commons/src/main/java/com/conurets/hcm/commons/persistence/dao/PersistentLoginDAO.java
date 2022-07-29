package com.conurets.hcm.commons.persistence.dao;


import com.conurets.hcm.commons.base.exception.HCMException;
import com.conurets.hcm.commons.persistence.entity.PersistentLogin;

import java.util.List;

/**
 * @author MSA
 * @version 1.0
 */

public interface PersistentLoginDAO extends BaseDAO<PersistentLogin> {
    PersistentLogin findByUserIdAndType(long userId, String type) throws HCMException;

    List<PersistentLogin> findAllByUserId(long userId) throws HCMException;
}