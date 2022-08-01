package com.conurets.hcm.commons.persistence.dao.impl;

import com.conurets.hcm.commons.base.exception.HCMException;
import com.conurets.hcm.commons.base.util.HCMUtil;
import com.conurets.hcm.commons.persistence.dao.LookupQueryDAO;
import com.conurets.hcm.commons.persistence.entity.LookupQuery;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * @author MSA
 * @version 1.0
 */

@Slf4j
@Repository
public class LookupQueryDAOImpl extends BaseDAOImpl<LookupQuery> implements LookupQueryDAO {
    /**
     * @param queryType
     * @return
     * @throws HCMException
     */
    public LookupQuery findByQueryType(String queryType) throws HCMException {
        StringBuilder jpql = new StringBuilder();
        jpql.append("FROM LookupQuery l ");
        jpql.append("WHERE l.queryType = :queryType ");
        //jpql.append("AND l.status = :status ");

        TypedQuery<LookupQuery> query = getEntityManager().createQuery(jpql.toString(), LookupQuery.class);
        query.setParameter("queryType", queryType);
        //query.setParameter("status", BBConstants.Common.STATUS_CODE_ACTIVE);

        return getSingleResult(query);
    }

    /**
     * Execute sql query
     *
     * @param strQuery
     * @return
     * @throws HCMException
     */
    public List<Object[]> executeLookupQuery(String strQuery) throws HCMException {
        List<Object[]> list = null;

        log.info("strQuery={}", strQuery);

        Query query = getEntityManager().createNativeQuery(strQuery);

        if (HCMUtil.isCollectionNotBlank(query.getResultList())) {
            list = (List<Object[]>) query.getResultList();
        }

        return list;
    }
}