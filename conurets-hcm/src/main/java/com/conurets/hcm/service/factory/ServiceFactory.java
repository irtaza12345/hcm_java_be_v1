package com.conurets.hcm.service.factory;


import com.conurets.hcm.commons.service.AuthenticationService;
import com.conurets.hcm.service.AttendanceService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author MSA
 * @version 1.0
 */

@Getter
@Component
public class ServiceFactory {
    @Autowired
    private AuthenticationService authenticationService;
    @Autowired
    private AttendanceService attendanceService;
}
