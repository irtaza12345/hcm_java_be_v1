package com.conurets.hcm.service;

import com.conurets.hcm.base.dto.request.AddAttendanceRequestDTO;
import com.conurets.hcm.base.dto.response.AttendanceResponseDTO;
import com.conurets.hcm.base.exception.HCMException;

import java.util.List;

/**
 * @author MSA
 * @version 1.0
 */

public interface AttendanceService {
    void addAttendance(String enrollNumber, Integer isInvalid, Integer attState, Integer verifyMethod, Integer year, Integer month, Integer day, Integer hour, Integer minute, Integer second, Integer workCode) throws HCMException;

    void addAttendance(AddAttendanceRequestDTO model) throws HCMException;

    List<AttendanceResponseDTO> findAll() throws HCMException;
}
