package com.conurets.hcm.controller;


import com.conurets.hcm.commons.base.dto.request.AddAttendanceRequestDTO;
import com.conurets.hcm.commons.base.dto.response.AttendanceResponseDTO;
import com.conurets.hcm.commons.base.dto.response.BaseResponseDTO;
import com.conurets.hcm.commons.base.exception.HCMException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author MSA
 * @version 1.0
 */

@Slf4j
@Controller
public class AttendanceController extends BaseController {
    /**
     * Add Attendance
     *
     * @return AuthenticationResponseDTO
     */
    @ResponseBody
    @GetMapping(value = "/api/attendance/add")
    public BaseResponseDTO addAttendance(@PathVariable String enrollNumber, @PathVariable Integer isInvalid, @PathVariable Integer attState,
                                         @PathVariable Integer verifyMethod, @PathVariable Integer year, @PathVariable Integer month, @PathVariable Integer day,
                                         @PathVariable Integer hour, @PathVariable Integer minute, @PathVariable Integer second, @PathVariable Integer workCode) throws HCMException {
        getServiceFactory().getAttendanceService();

        return response();
    }

    /**
     * Add Attendance
     *
     * @return AuthenticationResponseDTO
     */
    @ResponseBody
    @PostMapping(value = "/api/attendance/add")
    public BaseResponseDTO addAttendance(@RequestBody AddAttendanceRequestDTO model) throws HCMException {
        getServiceFactory().getAttendanceService().addAttendance(model);

        return response();
    }

    /**
     * Find Attendance
     *
     * @return AuthenticationResponseDTO
     */
    @ResponseBody
    @GetMapping(value = "/api/attendance/find")
    public BaseResponseDTO findAll() throws HCMException {
        List<AttendanceResponseDTO> dtoList = getServiceFactory().getAttendanceService().findAll();

        return response(dtoList);
    }
}
