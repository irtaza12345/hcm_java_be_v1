package com.conurets.hcm.persistence.dao.impl;

import com.conurets.hcm.base.exception.HCMException;
import com.conurets.hcm.base.util.HCMConstants;
import com.conurets.hcm.persistence.dao.AttendancePolicyDAO;
import com.conurets.hcm.persistence.entity.Attendance;
import com.conurets.hcm.persistence.entity.AttendancePolicy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;

/**
 * @author MSA
 * @version 1.0
 */

@Slf4j
@Repository
public class AttendancePolicyDAOImpl extends BaseDAOImpl<AttendancePolicy> implements AttendancePolicyDAO {
    /**
     *
     * @param enrollNumber
     * @return
     * @throws HCMException
     */
    public AttendancePolicy findByEnrollNumber(String enrollNumber) throws HCMException {
        StringBuilder jpql = new StringBuilder();
        jpql.append("FROM AttendancePolicy a ");
        jpql.append("WHERE a.enrollNumber = :enrollNumber ");
        jpql.append("AND a.status = :status ");

        TypedQuery<AttendancePolicy> query = getEntityManager().createQuery(jpql.toString(), AttendancePolicy.class);
        query.setParameter("enrollNumber", enrollNumber);
        query.setParameter("status", HCMConstants.Common.STATUS_CODE_ACTIVE);

        return getSingleResult(query);
    }
}
