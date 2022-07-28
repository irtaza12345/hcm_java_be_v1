package com.conurets.hcm.persistence.dao.impl;

import com.conurets.hcm.base.exception.HCMException;
import com.conurets.hcm.base.util.HCMConstants;
import com.conurets.hcm.persistence.dao.UserPrivilegeDAO;
import com.conurets.hcm.persistence.entity.UserPrivilege;
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
public class UserPrivilegeDAOImpl extends BaseDAOImpl<UserPrivilege> implements UserPrivilegeDAO {
    /**
     * findByUserId
     *
     * @param userId
     * @return
     * @throws HCMException
     */
    public List<UserPrivilege> findByUserId(long userId) throws HCMException {
        StringBuilder jpql = new StringBuilder();
        jpql.append("SELECT up FROM UserPrivilege up ");
        jpql.append("WHERE up.user.id = :userId ");
        jpql.append("AND up.status = :status ");

        TypedQuery<UserPrivilege> query = getEntityManager().createQuery(jpql.toString(), UserPrivilege.class);
        query.setParameter("userId", userId);
        query.setParameter("status", HCMConstants.Common.STATUS_CODE_ACTIVE);

        return getResultList(query);
    }

    /**
     * findActivePrivilegeByIds
     *
     * @param privilegeId
     * @param organizationId
     * @param userId
     * @return
     * @throws HCMException
     */
    public UserPrivilege findActivePrivilegeByIds(long privilegeId, long organizationId, long userId) throws HCMException {
        StringBuilder jpql = new StringBuilder();
        jpql.append("SELECT up FROM UserPrivilege up ");
        jpql.append("WHERE up.privilege.id = :privilegeId ");
        jpql.append("AND up.organization.id = :organizationId ");
        jpql.append("AND up.user.id = :userId ");
        jpql.append("AND up.status = :status ");

        TypedQuery<UserPrivilege> query = getEntityManager().createQuery(jpql.toString(), UserPrivilege.class);
        query.setParameter("privilegeId", privilegeId);
        query.setParameter("organizationId", organizationId);
        query.setParameter("userId", userId);
        query.setParameter("status", HCMConstants.Common.STATUS_CODE_ACTIVE);

        return getSingleResult(query);
    }
}
