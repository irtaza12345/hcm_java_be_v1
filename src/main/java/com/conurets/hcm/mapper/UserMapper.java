package com.conurets.hcm.mapper;

import com.conurets.hcm.base.dto.request.AddUserRequestDTO;
import com.conurets.hcm.base.dto.request.UpdateUserRequestDTO;
import com.conurets.hcm.base.dto.response.UserResponseDTO;
import com.conurets.hcm.base.exception.HCMException;
import com.conurets.hcm.base.util.HCMConstants;
import com.conurets.hcm.base.util.HCMHelper;
import com.conurets.hcm.base.util.HCMUtil;
import com.conurets.hcm.persistence.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author MSA
 * @version 1.0
 */

@Slf4j
@Component
public class UserMapper extends BaseMapper {
    /**
     * Add user
     *
     * @param model
     * @return
     * @throws HCMException
     */
    public User add(AddUserRequestDTO model) throws HCMException {
        User user = new User();

        if (model.getUserTypeId() != null) {
            user.setUserType(getDaoFactory().getUserTypeDAO().findById(model.getUserTypeId()));
        }

        user.setOrganization(getDaoFactory().getOrganizationDAO().findById(model.getOrganizationId()));
        user.setFirstName(model.getFirstName());
        user.setLastName(model.getLastName());
        user.setEmailAddress(model.getEmailAddress());
        user.setMobileNumber(model.getMobileNumber());
        user.setDesignation(model.getDesignation());
        user.setCountry(getDaoFactory().getCountryDAO().findById(model.getCountryId()));
        user.setState(getDaoFactory().getStateDAO().findById(model.getStateId()));
        user.setCity(getDaoFactory().getCityDAO().findById(model.getCityId()));
        user.setStatus(model.getStatus());
        //user.setDefaultUser(Boolean.FALSE);

        addAuditingInformation(user);

        return user;
    }

    /**
     * Update user
     *
     * @param model
     * @return
     * @throws HCMException
     */
    public User update(UpdateUserRequestDTO model) throws HCMException {
        User user = getDaoFactory().getUserDAO().findById(model.getUserId());

        if (user == null) {
            HCMHelper.handleResultNotFound(101, "No result found");
        }

        if (user.getStatus() == HCMConstants.Common.STATUS_CODE_DELETE) {
            HCMHelper.handleResultNotFound(101, "User already deleted.");
        }

        if (model.getUserTypeId() != null) {
            user.setUserType(getDaoFactory().getUserTypeDAO().findById(model.getUserTypeId()));
        }

        user.setOrganization(getDaoFactory().getOrganizationDAO().findById(model.getOrganizationId()));
        user.setFirstName(model.getFirstName());
        user.setLastName(model.getLastName());
        user.setEmailAddress(model.getEmailAddress());
        user.setMobileNumber(model.getMobileNumber());
        user.setDesignation(model.getDesignation());
        user.setCountry(getDaoFactory().getCountryDAO().findById(model.getCountryId()));
        user.setState(getDaoFactory().getStateDAO().findById(model.getStateId()));
        user.setCity(getDaoFactory().getCityDAO().findById(model.getCityId()));
        user.setStatus(model.getStatus());

        addAuditingInformation(user);

        return user;
    }

    /**
     * Delete user
     *
     * @param id
     * @return
     * @throws HCMException
     */
    public User delete(long id) throws HCMException {
        User user = getDaoFactory().getUserDAO().findById(id);

        if (user == null) {
            HCMHelper.handleResultNotFound(101, "No result found");
        }

        /*if (user.getDefaultUser()) {
            HCMHelper.handleResultNotFound(101, "Unable to delete this user");
        }*/

        user.setStatus(HCMConstants.Common.STATUS_CODE_DELETE);

        addAuditingInformation(user);

        return user;
    }

    /**
     * Find user detail
     *
     * @param user
     * @return
     * @throws HCMException
     */
    public UserResponseDTO find(User user) throws HCMException {
        UserResponseDTO userResponseDTO = new UserResponseDTO();
        userResponseDTO.setUserId(user.getId());
        userResponseDTO.setFirstName(user.getFirstName());
        userResponseDTO.setLastName(user.getLastName());
        userResponseDTO.setEmailAddress(user.getEmailAddress());
        userResponseDTO.setMobileNumber(user.getMobileNumber());
        userResponseDTO.setDesignation(user.getDesignation());
        userResponseDTO.setCountry(user.getCountry().getCountryName());
        userResponseDTO.setState(user.getState().getStateName());
        userResponseDTO.setCity(user.getCity().getCityName());
        userResponseDTO.setOrganizationName(user.getOrganization().getName());

        if (user.getUserType() != null) {
            if (user.getUserType().getBranch() != null) {
                userResponseDTO.setBranchName(user.getUserType().getBranch().getName());
            }
        }

        userResponseDTO.setStatus(HCMUtil.getStatus(user.getStatus()));

        return userResponseDTO;
    }
}
