package com.conurets.hcm.persistence.dao;

import com.conurets.hcm.base.exception.HCMException;
import com.conurets.hcm.persistence.entity.LookupQuery;

import java.util.List;

/**
 * @author MSA
 * @version 1.0
 */

public interface LookupQueryDAO extends BaseDAO<LookupQuery> {
    LookupQuery findByQueryType(String queryType) throws HCMException;

    List<Object[]> executeLookupQuery(String strQuery) throws HCMException;
}