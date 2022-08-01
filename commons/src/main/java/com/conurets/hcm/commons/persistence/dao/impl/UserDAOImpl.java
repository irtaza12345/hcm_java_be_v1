package com.conurets.hcm.commons.persistence.dao.impl;


import com.conurets.hcm.commons.base.exception.HCMException;
import com.conurets.hcm.commons.base.util.HCMConstants;
import com.conurets.hcm.commons.base.util.HCMUtil;
import com.conurets.hcm.commons.persistence.dao.UserDAO;
import com.conurets.hcm.commons.persistence.entity.User;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

/**
 * @author MSA
 * @version 1.0
 */

@Slf4j
@Repository
public class UserDAOImpl extends BaseDAOImpl<User> implements UserDAO {
    /**
     * Find by email address
     *
     * @param emailAddress
     * @return
     * @throws HCMException
     */
    public User findByEmailAddress(String emailAddress) throws HCMException {
        final StringBuilder jpql = new StringBuilder();
        jpql.append("FROM User u ");
        jpql.append("WHERE u.emailAddress = :emailAddress ");

        //log.info("jpql={}", jpql);

        TypedQuery<User> query = getEntityManager().createQuery(jpql.toString(), User.class);
        query.setParameter("emailAddress", emailAddress);

        return getSingleResult(query);
    }

    /**
     * Find by organization id
     *
     * @param organizationId
     * @return
     * @throws HCMException
     */
    public List<User> findByOrganizationId(long organizationId) throws HCMException {
        final StringBuilder jpql = new StringBuilder();
        jpql.append("FROM User u ");
        jpql.append("WHERE u.userType.organization.id = :organizationId ");
        jpql.append("AND u.organization.status = :organizationStatus ");
        jpql.append("AND u.status IN :status ");

        TypedQuery<User> query = getEntityManager().createQuery(jpql.toString(), User.class);
        query.setParameter("organizationId", organizationId);
        query.setParameter("organizationStatus", HCMConstants.Common.STATUS_CODE_ACTIVE);
        query.setParameter("status", HCMUtil.getDBResultStatus());

        return getResultList(query);
    }

    /**
     * Find by branch id
     *
     * @param branchId
     * @return
     * @throws HCMException
     */
    public List<User> findByBranchId(long branchId) throws HCMException {
        final StringBuilder jpql = new StringBuilder();
        jpql.append("FROM User u ");
        jpql.append("WHERE u.userType.branch.id = :branchId ");
        jpql.append("AND u.branch.status = :branchStatus ");
        jpql.append("AND u.status IN :status ");

        TypedQuery<User> query = getEntityManager().createQuery(jpql.toString(), User.class);
        query.setParameter("branchId", branchId);
        query.setParameter("branchStatus", HCMConstants.Common.STATUS_CODE_ACTIVE);
        query.setParameter("status", HCMUtil.getDBResultStatus());

        return getResultList(query);
    }

    /**
     * Search
     *
     * @param example
     * @return
     * @throws HCMException
     */
//    public List<User> search(Example<User> example) throws HCMException {
//        //getEntityManager().find()
//
//        return null;
//    }
}