package com.conurets.hcm.mapper;

import com.conurets.hcm.base.dto.request.AddUserTypeRequestDTO;
import com.conurets.hcm.base.dto.request.UpdateUserTypeRequestDTO;
import com.conurets.hcm.base.dto.response.UserTypeResponseDTO;
import com.conurets.hcm.base.exception.HCMException;
import com.conurets.hcm.base.util.HCMConstants;
import com.conurets.hcm.base.util.HCMHelper;
import com.conurets.hcm.base.util.HCMUtil;
import com.conurets.hcm.persistence.entity.UserType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author MSA
 * @version 1.0
 */

@Slf4j
@Component
public class UserTypeMapper extends BaseMapper {
    /**
     * Add user type
     *
     * @param model
     * @return
     * @throws HCMException
     */
    public UserType add(AddUserTypeRequestDTO model) throws HCMException {
        UserType userType = new UserType();
        userType.setOrganization(getDaoFactory().getOrganizationDAO().findById(model.getOrganizationId()));

        if (model.getBranchId() != null) {
            userType.setBranch(getDaoFactory().getBranchDAO().findById(model.getBranchId()));
        }

        userType.setRole(getDaoFactory().getRoleDAO().findById(model.getRoleId()));

        userType.setName(model.getName());
        userType.setDescription(model.getDescription());
        userType.setSystemUser(model.getSystemUser());
        userType.setSuperUser(model.getSuperUser());
        userType.setInternalUser(model.getInternalUser());
        userType.setReadOnly(model.getReadOnly());
        userType.setOrganizationAdmin(model.getOrganizationAdmin());
        userType.setBranchAdmin(model.getBranchAdmin());
        userType.setStatus(model.getStatus());

        addAuditingInformation(userType);

        return userType;
    }

    /**
     * Update user type
     *
     * @param model
     * @return
     * @throws HCMException
     */
    public UserType update(UpdateUserTypeRequestDTO model) throws HCMException {
        UserType userType = getDaoFactory().getUserTypeDAO().findById(model.getUserTypeId());

        if (userType == null) {
            HCMHelper.handleResultNotFound(101, "No result found");
        }

        if (userType.getStatus() == HCMConstants.Common.STATUS_CODE_DELETE) {
            HCMHelper.handleResultNotFound(101, "UserType already deleted.");
        }

        userType.setOrganization(getDaoFactory().getOrganizationDAO().findById(model.getOrganizationId()));

        if (model.getBranchId() != null) {
            userType.setBranch(getDaoFactory().getBranchDAO().findById(model.getBranchId()));
        }

        userType.setRole(getDaoFactory().getRoleDAO().findById(model.getRoleId()));
        userType.setName(model.getName());
        userType.setDescription(model.getDescription());
        userType.setSystemUser(model.getSystemUser());
        userType.setSuperUser(model.getSuperUser());
        userType.setInternalUser(model.getInternalUser());
        userType.setReadOnly(model.getReadOnly());
        userType.setOrganizationAdmin(model.getOrganizationAdmin());
        userType.setBranchAdmin(model.getBranchAdmin());
        userType.setStatus(model.getStatus());

        addAuditingInformation(userType);

        return userType;
    }

    /**
     * Delete user type
     *
     * @param id
     * @return
     * @throws HCMException
     */
    public UserType delete(long id) throws HCMException {
        UserType userType = getDaoFactory().getUserTypeDAO().findById(id);

        if (userType == null) {
            HCMHelper.handleResultNotFound(101, "No result found");
        }

        userType.setStatus(HCMConstants.Common.STATUS_CODE_DELETE);

        addAuditingInformation(userType);

        return userType;
    }

    /**
     * Find user types
     *
     * @param userType
     * @return
     * @throws HCMException
     */
    public UserTypeResponseDTO find(UserType userType) throws HCMException {
        UserTypeResponseDTO userTypeResponseDTO = new UserTypeResponseDTO();
        userTypeResponseDTO.setOrganizationId(userType.getOrganization().getId());
        userTypeResponseDTO.setOrganizationName(userType.getOrganization().getName());
        userTypeResponseDTO.setCompanyName(userType.getOrganization().getName());
        userTypeResponseDTO.setBranchId(userType.getBranch().getId());
        userTypeResponseDTO.setBranchName(userType.getOrganization().getName());
        userTypeResponseDTO.setRoleId(userType.getRole().getId());
        userTypeResponseDTO.setRoleName(userType.getOrganization().getName());
        userTypeResponseDTO.setUserTypeId(userType.getId());
        userTypeResponseDTO.setName(userType.getName());
        userTypeResponseDTO.setDescription(userType.getDescription());
        userTypeResponseDTO.setSystemUser(userType.getSystemUser());
        userTypeResponseDTO.setSuperUser(userType.getSuperUser());
        userTypeResponseDTO.setInternalUser(userType.getInternalUser());
        userTypeResponseDTO.setReadOnly(userType.getReadOnly());
        userTypeResponseDTO.setOrganizationAdmin(userType.getOrganizationAdmin());
        userTypeResponseDTO.setBranchAdmin(userType.getBranchAdmin());
        userTypeResponseDTO.setStatus(HCMUtil.getStatus(userType.getStatus()));

        return userTypeResponseDTO;
    }
}
