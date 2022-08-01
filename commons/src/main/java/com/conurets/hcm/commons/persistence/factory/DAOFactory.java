package com.conurets.hcm.commons.persistence.factory;

import com.conurets.hcm.commons.persistence.dao.*;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author MSA
 * @version 1.0
 */

@Getter
@Component
public class DAOFactory {
    @Autowired
    private UserDAO userDAO;
    @Autowired
    private UserLoginDAO userLoginDAO;
    @Autowired
    private PrivilegeDAO privilegeDAO;
    @Autowired
    private UserRoleDAO userRoleDAO;
    @Autowired
    private PersistentLoginDAO persistentLoginDAO;
    @Autowired
    private RoleDAO roleDAO;
    @Autowired
    private RolePrivilegeDAO rolePrivilegeDAO;
    @Autowired
    private OrganizationDAO organizationDAO;
    @Autowired
    private UserPrivilegeDAO userPrivilegeDAO;
    @Autowired
    private PreferenceDAO preferenceDAO;
    @Autowired
    private MenuDAO menuDAO;
    @Autowired
    private BranchDAO branchDAO;
    @Autowired
    private LookupQueryDAO lookupQueryDAO;
    @Autowired
    private CountryDAO countryDAO;
    @Autowired
    private StateDAO stateDAO;
    @Autowired
    private CityDAO cityDAO;
    @Autowired
    private ErrorCodeDAO errorCodeDAO;
    @Autowired
    private UserActivityDAO userActivityDAO;
    @Autowired
    private DepartmentDAO departmentDAO;
    @Autowired
    private UserTypeDAO userTypeDAO;
    @Autowired
    private AttendanceDAO attendanceDAO;
    @Autowired
    private AttendancePolicyDAO attendancePolicyDAO;
}
