package com.conurets.hcm.persistence.dao;

import com.conurets.hcm.base.exception.HCMException;
import com.conurets.hcm.persistence.entity.Attendance;

/**
 * @author MSA
 * @version 1.0
 */

public interface AttendanceDAO extends BaseDAO<Attendance> {
    Attendance findByParams(String enrollNumber, int year, int month, int day) throws HCMException;

    Attendance findTodayAttendance(String enrollNumber, long from, long to) throws HCMException;
}
