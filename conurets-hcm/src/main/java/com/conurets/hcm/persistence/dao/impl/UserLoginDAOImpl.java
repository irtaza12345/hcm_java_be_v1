package com.conurets.hcm.persistence.dao.impl;

import com.conurets.hcm.base.exception.HCMException;
import com.conurets.hcm.base.util.HCMConstants;
import com.conurets.hcm.persistence.dao.UserLoginDAO;
import com.conurets.hcm.persistence.entity.UserLogin;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;

/**
 * @author MSA
 * @version 1.0
 */

@Slf4j
@Repository
public class UserLoginDAOImpl extends BaseDAOImpl<UserLogin> implements UserLoginDAO {
    /**
     * @param userId
     * @return
     * @throws HCMException
     */
    public UserLogin findByUserId(long userId) throws HCMException {
        final StringBuilder jpql = new StringBuilder();
        jpql.append("FROM UserLogin uc ");
        jpql.append("WHERE uc.user.id = :userId ");
        jpql.append("AND uc.user.status = :userStatus ");
        jpql.append("AND uc.status = :status ");

        TypedQuery<UserLogin> query = getEntityManager().createQuery(jpql.toString(), UserLogin.class);
        query.setParameter("userId", userId);
        query.setParameter("userStatus", HCMConstants.Common.STATUS_CODE_ACTIVE);
        query.setParameter("status", HCMConstants.Common.STATUS_CODE_ACTIVE);

        return getSingleResult(query);
    }
}