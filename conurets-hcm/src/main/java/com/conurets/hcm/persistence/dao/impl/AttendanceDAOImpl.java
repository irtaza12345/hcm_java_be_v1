package com.conurets.hcm.persistence.dao.impl;

import com.conurets.hcm.base.exception.HCMException;
import com.conurets.hcm.base.util.HCMConstants;
import com.conurets.hcm.persistence.dao.AttendanceDAO;
import com.conurets.hcm.persistence.entity.Attendance;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;

/**
 * @author MSA
 * @version 1.0
 */

@Slf4j
@Repository
public class AttendanceDAOImpl extends BaseDAOImpl<Attendance> implements AttendanceDAO {
    /**
     * Find by params
     *
     * @param enrollNumber
     * @param year
     * @param month
     * @param day
     * @return
     * @throws HCMException
     */
    public Attendance findByParams(String enrollNumber, int year, int month, int day) throws HCMException {
        StringBuilder jpql = new StringBuilder();
        jpql.append("FROM Attendance a ");
        jpql.append("WHERE a.enrollNumber = :enrollNumber ");
        /*jpql.append("AND a.year = :year ");
        jpql.append("AND a.month = :month ");
        jpql.append("AND a.day = :day ");*/
        jpql.append("AND a.status = :status ");

        TypedQuery<Attendance> query = getEntityManager().createQuery(jpql.toString(), Attendance.class);
        query.setParameter("enrollNumber", enrollNumber);
        /*query.setParameter("year", year);
        query.setParameter("month", month);
        query.setParameter("day", day);*/
        query.setParameter("status", HCMConstants.Common.STATUS_CODE_ACTIVE);

        return getSingleResult(query);
    }

    /**
     * Find today attendance
     *
     * @param enrollNumber
     * @param from
     * @param to
     * @return
     * @throws HCMException
     */
    public Attendance findTodayAttendance(String enrollNumber, long from, long to) throws HCMException {
        StringBuilder jpql = new StringBuilder();
        jpql.append("FROM Attendance a ");
        jpql.append("WHERE a.enrollNumber = :enrollNumber ");
        jpql.append("AND a.signIn >= :from AND a.signIn <= :to ");
        jpql.append("AND a.status = :status ");

        TypedQuery<Attendance> query = getEntityManager().createQuery(jpql.toString(), Attendance.class);
        query.setParameter("enrollNumber", enrollNumber);
        query.setParameter("from", from);
        query.setParameter("to", to);
        query.setParameter("status", HCMConstants.Common.STATUS_CODE_ACTIVE);

        return getSingleResult(query);
    }
}
