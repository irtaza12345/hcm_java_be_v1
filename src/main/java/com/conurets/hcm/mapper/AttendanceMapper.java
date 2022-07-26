package com.conurets.hcm.mapper;

import com.conurets.hcm.base.dto.request.AddAttendanceRequestDTO;
import com.conurets.hcm.base.dto.response.AttendanceResponseDTO;
import com.conurets.hcm.base.exception.HCMException;
import com.conurets.hcm.base.util.HCMUtil;
import com.conurets.hcm.persistence.entity.Attendance;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author MSA
 * @version 1.0
 */

@Slf4j
@Component
public class AttendanceMapper extends BaseMapper {
    /**
     * Add attendance
     *
     * @param model
     * @return
     * @throws HCMException
     */
    public Attendance add(AddAttendanceRequestDTO model) throws HCMException {
        Attendance attendance = new Attendance();
        attendance.setEnrollNumber(model.getEnrollNumber());
        //attendance.setEventType(model.getEventType());
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
        attendance.setSignIn(model.getSignIn());
        attendance.setSignOut(model.getSignOut());
        attendance.setStatus(1);

        addAuditingInformation(attendance);

        return attendance;
    }

    /**
     * Find
     *
     * @param attendance
     * @return
     * @throws HCMException
     */
    public AttendanceResponseDTO find(Attendance attendance) throws HCMException {
        AttendanceResponseDTO attendanceResponseDTO = new AttendanceResponseDTO();
        attendanceResponseDTO.setEnrollNumber(attendance.getEnrollNumber());

        if (attendance.getSignIn() != null) {
            //attendanceResponseDTO.setSignIn(new Date(attendance.getSignIn()));

            attendanceResponseDTO.setSignIn(attendance.getCreatedDate());
        }

        if (attendance.getSignOut() != null) {
            //attendanceResponseDTO.setSignOut(new Date(attendance.getSignOut()));

            attendanceResponseDTO.setSignOut(attendance.getLastUpdate());
        }

        attendanceResponseDTO.setInvalid(attendance.getInvalid());
        attendanceResponseDTO.setAttState(attendance.getAttState());
        attendanceResponseDTO.setVerifyMode(attendance.getVerifyMode());
        attendanceResponseDTO.setYear(attendance.getYear());
        attendanceResponseDTO.setMonth(attendance.getMonth());
        attendanceResponseDTO.setDay(attendance.getDay());
        attendanceResponseDTO.setHour(attendance.getHour());
        attendanceResponseDTO.setMinute(attendance.getMinute());
        attendanceResponseDTO.setSecond(attendance.getSecond());
        attendanceResponseDTO.setWorkCode(attendance.getWorkCode());
        attendanceResponseDTO.setStatus(HCMUtil.getStatus(attendance.getStatus()));

        return attendanceResponseDTO;
    }
}
