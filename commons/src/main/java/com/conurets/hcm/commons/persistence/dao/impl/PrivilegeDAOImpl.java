package com.conurets.hcm.commons.persistence.dao.impl;


import com.conurets.hcm.commons.base.exception.HCMException;
import com.conurets.hcm.commons.base.util.HCMUtil;
import com.conurets.hcm.commons.persistence.dao.PrivilegeDAO;
import com.conurets.hcm.commons.persistence.entity.Privilege;
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
public class PrivilegeDAOImpl extends BaseDAOImpl<Privilege> implements PrivilegeDAO {
    /**
     * @param organizationId
     * @return
     * @throws HCMException
     */
    public List<Privilege> findByOrganizationId(long organizationId) throws HCMException {
        StringBuilder jpql = new StringBuilder();
        jpql.append("FROM Privilege p ");
        jpql.append("WHERE p.organizationId.id = :organizationId ");
        jpql.append("AND p.status IN :status ");

        TypedQuery<Privilege> query = getEntityManager().createQuery(jpql.toString(), Privilege.class);
        query.setParameter("organizationId", organizationId);
        query.setParameter("status", HCMUtil.getDBResultStatus());

        return getResultList(query);
    }
}