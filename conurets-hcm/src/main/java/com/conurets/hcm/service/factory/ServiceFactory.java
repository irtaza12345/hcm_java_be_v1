package com.conurets.hcm.service.factory;


import com.conurets.hcm.commons.service.AuthenticationService;
import com.conurets.hcm.controller.CityController;
import com.conurets.hcm.controller.OrganizationController;
import com.conurets.hcm.service.*;
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
    @Autowired
    private CountryService countryService;
    @Autowired
    private StateService stateService;
    @Autowired
    private CityService cityService;
    @Autowired
    private OrganizationService organizationService;

}
