package com.conurets.hcm.commons.persistence.dao;

import com.conurets.hcm.commons.base.exception.HCMException;
import com.conurets.hcm.commons.persistence.entity.AttendancePolicy;

/**
 * @author MSA
 * @version 1.0
 */

public interface AttendancePolicyDAO extends BaseDAO<AttendancePolicy> {
    AttendancePolicy findByEnrollNumber(String enrollNumber) throws HCMException;
}
