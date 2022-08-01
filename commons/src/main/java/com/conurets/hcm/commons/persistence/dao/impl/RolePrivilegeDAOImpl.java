package com.conurets.hcm.commons.persistence.dao.impl;


import com.conurets.hcm.commons.base.exception.HCMException;
import com.conurets.hcm.commons.base.util.HCMConstants;
import com.conurets.hcm.commons.persistence.dao.RolePrivilegeDAO;
import com.conurets.hcm.commons.persistence.entity.RolePrivilege;
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
public class RolePrivilegeDAOImpl extends BaseDAOImpl<RolePrivilege> implements RolePrivilegeDAO {
    /**
     * findByRoleId
     *
     * @param roleId
     * @return
     * @throws HCMException
     */
    public List<RolePrivilege> findByRoleId(long roleId) throws HCMException {
        StringBuilder jpql = new StringBuilder();
        jpql.append("FROM RolePrivilege rp ");
        jpql.append("WHERE rp.role.id = :roleId ");
        jpql.append("AND rp.status = :status ");

        TypedQuery<RolePrivilege> query = getEntityManager().createQuery(jpql.toString(), RolePrivilege.class);
        query.setParameter("roleId", roleId);
        query.setParameter("status", HCMConstants.Common.STATUS_CODE_ACTIVE);

        return getResultList(query);
    }

    /**
     * findByIds
     *
     * @param roleId
     * @param privilegeId
     * @return
     * @throws HCMException
     */
    public RolePrivilege findByIds(long roleId, long privilegeId) throws HCMException {
        StringBuilder jpql = new StringBuilder();
        jpql.append("FROM RolePrivilege rp ");
        jpql.append("WHERE rp.role.id = :roleId ");
        jpql.append("AND rp.privilege.id = :privilegeId ");
        jpql.append("AND rp.status = :status ");

        TypedQuery<RolePrivilege> query = getEntityManager().createQuery(jpql.toString(), RolePrivilege.class);
        query.setParameter("roleId", roleId);
        query.setParameter("privilegeId", privilegeId);
        query.setParameter("status", HCMConstants.Common.STATUS_CODE_ACTIVE);

        return getSingleResult(query);
    }
}
