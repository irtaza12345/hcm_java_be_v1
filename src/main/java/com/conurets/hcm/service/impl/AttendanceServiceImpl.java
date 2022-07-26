package com.conurets.hcm.service.impl;

import com.conurets.hcm.base.dto.request.AddAttendanceRequestDTO;
import com.conurets.hcm.base.dto.response.AttendanceResponseDTO;
import com.conurets.hcm.base.exception.HCMException;
import com.conurets.hcm.base.util.HCMConstants;
import com.conurets.hcm.base.util.HCMDateUtil;
import com.conurets.hcm.base.util.HCMHelper;
import com.conurets.hcm.base.util.HCMUtil;
import com.conurets.hcm.persistence.entity.Attendance;
import com.conurets.hcm.persistence.entity.AttendancePolicy;
import com.conurets.hcm.service.AttendanceService;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author MSA
 * @version 1.0
 */

@Slf4j
@Service
public class AttendanceServiceImpl extends BaseServiceImpl implements AttendanceService {
    /**
     * Add Attendance
     *
     * @param enrollNumber
     * @param isInvalid
     * @param attState
     * @param verifyMethod
     * @param year
     * @param month
     * @param day
     * @param hour
     * @param minute
     * @param second
     * @param workCode
     * @throws HCMException
     */
    public void addAttendance(String enrollNumber, Integer isInvalid, Integer attState, Integer verifyMethod, Integer year,
                              Integer month, Integer day, Integer hour, Integer minute, Integer second, Integer workCode) throws HCMException {
        log.info("enrollNumber={}", enrollNumber);
        log.info("isInvalid={}", isInvalid);
        log.info("attState={}", attState);
        log.info("VerifyMode={}", verifyMethod);
        log.info("year={}", year);
        log.info("month={}", month);
        log.info("day={}", day);
        log.info("hour={}", hour);
        log.info("minute={}", minute);
        log.info("second={}", second);
        log.info("workCode={}", workCode);
    }

    /**
     * Add Attendance
     *
     * @param model
     * @throws HCMException
     */
    public void addAttendance(AddAttendanceRequestDTO model) throws HCMException {
        log.info("model={}", new JSONObject(model).toString());

        String createDate = new StringBuilder()
                .append(model.getMonth()).append(HCMConstants.Common.SC_DASH)
                .append(model.getDay()).append(HCMConstants.Common.SC_DASH)
                .append(model.getYear()).toString();

        String createTime = new StringBuilder()
                .append(model.getHour()).append(HCMConstants.Common.SC_COLON)
                .append(model.getMinute()).append(HCMConstants.Common.SC_COLON)
                .append(model.getSecond()).toString();

        log.info("createDate={}, createTime={}", createDate, createTime);

        Date date = HCMDateUtil.getDateByFormat(createDate, HCMConstants.Common.DATE_FORMAT_MM_DD_YYYY);

        log.info("date={}", date);

        Date dateTime = HCMDateUtil.getDateByFormat(new StringBuilder()
                .append(createDate)
                .append(HCMConstants.Common.SC_SPACE)
                .append(createTime).toString(), HCMConstants.Common.DATE_FORMAT_MM_DD_YYYY_HH_MM_SS);

        log.info("dateTime={}", dateTime);

        long from = HCMDateUtil.getDateByFormat(new StringBuilder().append(createDate).append(" 00:00:00").toString(), HCMConstants.Common.DATE_FORMAT_MM_DD_YYYY_HH_MM_SS).getTime();
        long to = HCMDateUtil.getDateByFormat(new StringBuilder().append(createDate).append(" 23:59:59").toString(), HCMConstants.Common.DATE_FORMAT_MM_DD_YYYY_HH_MM_SS).getTime();

        log.info("from={}, to={}", from, to);

        int timeOut = 30;
        boolean saved = Boolean.TRUE;
        String eventType = HCMConstants.Common.EVENT_TYPE_IN;
        int status = HCMConstants.Common.STATUS_CODE_ACTIVE;
        long timeDifference = HCMConstants.Common.INT_ZERO;
        Attendance attendance = getDaoFactory().getAttendanceDAO().findTodayAttendance(model.getEnrollNumber(), from, to);

        if (attendance == null) {
            attendance = new Attendance();
            attendance.setSignIn(dateTime.getTime());

            eventType = HCMConstants.Common.EVENT_TYPE_IN;
            status = HCMConstants.Common.STATUS_CODE_ACTIVE;
        } else {
            AttendancePolicy attendancePolicy = getDaoFactory().getAttendancePolicyDAO().findByEnrollNumber(model.getEnrollNumber());

            timeDifference = HCMUtil.calcTimeDifference(attendance.getSignIn(), dateTime.getTime());

            log.info("timeDifference={}", timeDifference);

            if (attendancePolicy.getPartially()) {
                attendance.setSignOut(dateTime.getTime());

                eventType = HCMConstants.Common.EVENT_TYPE_OUT;
                status = HCMConstants.Common.STATUS_CODE_INACTIVE;
            } else {
                if (timeDifference >= timeOut) {
                    attendance.setSignOut(dateTime.getTime());

                    eventType = HCMConstants.Common.EVENT_TYPE_OUT;
                    status = HCMConstants.Common.STATUS_CODE_INACTIVE;
                } else {
                    saved = Boolean.FALSE;

                    /*attendance.setSignOut(dateTime.getTime());

                    eventType = HCMConstants.Common.EVENT_TYPE_EARLY;
                    status = HCMConstants.Common.STATUS_CODE_INACTIVE;*/
                }
            }
        }

        log.info("saved={}", saved);

        if (saved) {
            attendance.setEnrollNumber(model.getEnrollNumber());
            attendance.setEventType(eventType);
            attendance.setInvalid(model.getInvalid());
            attendance.setAttState(model.getAttState());
            attendance.setVerifyMode(model.getVerifyMode());
            attendance.setYear(model.getYear());
            attendance.setMonth(model.getMonth());
            attendance.setDay(model.getDay());
            attendance.setHour(model.getHour());
            attendance.setMinute(model.getMinute());
            attendance.setSecond(model.getSecond());
            attendance.setWorkCode(model.getWorkCode());
            attendance.setDuration(timeDifference);
            attendance.setStatus(status);
            attendance.setLastUpdate(HCMDateUtil.getCurrentTimestamp());
            attendance.setLastUpdateBy(1L);

            getDaoFactory().getAttendanceDAO().save(attendance);
        }
    }

    /**
     * Find all
     *
     * @return
     * @throws HCMException
     */
    public List<AttendanceResponseDTO> findAll() throws HCMException {
        List<Attendance> attendances = getDaoFactory().getAttendanceDAO().findAll();

        if (!HCMUtil.isCollectionNotBlank(attendances)) {
            HCMHelper.handleResultNotFound(100, "No result found");
        }

        return attendances.stream()
                .map(attendance -> getMapperFactory().getAttendanceMapper().find(attendance))
                .collect(Collectors.toList());
    }
}
