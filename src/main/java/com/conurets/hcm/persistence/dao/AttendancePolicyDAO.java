package com.conurets.hcm.persistence.dao;

import com.conurets.hcm.base.exception.HCMException;
import com.conurets.hcm.persistence.entity.AttendancePolicy;

/**
 * @author MSA
 * @version 1.0
 */

public interface AttendancePolicyDAO extends BaseDAO<AttendancePolicy> {
    AttendancePolicy findByEnrollNumber(String enrollNumber) throws HCMException;
}
