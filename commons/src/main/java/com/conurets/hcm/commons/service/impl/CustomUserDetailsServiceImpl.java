package com.conurets.hcm.commons.service.impl;


import com.conurets.hcm.commons.base.exception.HCMException;
import com.conurets.hcm.commons.base.util.HCMConstants;
import com.conurets.hcm.commons.base.util.HCMHelper;
import com.conurets.hcm.commons.base.util.HCMStatusConstants;
import com.conurets.hcm.commons.base.util.HCMUtil;
import com.conurets.hcm.commons.persistence.entity.*;
import com.conurets.hcm.commons.security.model.CustomUserDetails;
import com.conurets.hcm.commons.service.CustomUserDetailsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author MSA
 * @version 1.0
 */

@Slf4j
@Service
public class CustomUserDetailsServiceImpl extends BaseServiceImpl implements CustomUserDetailsService {
    /**
     * loadUserByUsername
     *
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<GrantedAuthority> authorities = new ArrayList<>();

        User user = getDaoFactory().getUserDAO().findByKeyValue("emailAddress", username);

        if (user == null) {
            HCMHelper.handleResultNotFound(HCMStatusConstants.STATUS_CODE_NO_USER_FOUND, HCMStatusConstants.STATUS_MSG_NO_USER_FOUND);
        }

        if (user.getStatus() == HCMConstants.Common.STATUS_CODE_INACTIVE) {
            HCMHelper.handleResultNotFound(HCMStatusConstants.STATUS_CODE_INACTIVE_USER, HCMStatusConstants.STATUS_MSG_INACTIVE_USER);
        }

        if (user.getStatus() == HCMConstants.Common.STATUS_CODE_DELETE) {
            HCMHelper.handleResultNotFound(HCMStatusConstants.STATUS_CODE_USER_DELETED, HCMStatusConstants.STATUS_MSG_USER_DELETED);
        }

        UserLogin userCredential = getDaoFactory().getUserLoginDAO().findByUserId(user.getId());

        if (userCredential == null) {
            HCMHelper.handleResultNotFound(HCMStatusConstants.STATUS_CODE_NO_CREDENTIAL_FOUND, HCMStatusConstants.STATUS_MSG_NO_CREDENTIAL_FOUND);
        }

        List<UserRole> userRoles = getDaoFactory().getUserRoleDAO().findByUserId(userCredential.getUser().getId());

        if (!HCMUtil.isCollectionNotBlank(userRoles)) {
            HCMHelper.handleResultNotFound(HCMStatusConstants.STATUS_CODE_NO_USER_ROLE_FOUND, HCMStatusConstants.STATUS_MSG_NO_USER_ROLE_FOUND);
        }

        // Multiple role handler
        UserRole userRole = userRoles.get(HCMConstants.Common.INT_ZERO);

        findRolePrivileges(authorities, userRole);
        findUserPrivileges(authorities, userCredential.getUser().getId());

        /*List<RolePrivilege> roleList = getDaoFactory().getRolePrivilegeDAO().findByRoleId(userRole.getRole().getId());

        if (!HCMUtil.isCollectionNotBlank(roleList)) {
            HCMHelper.handleResultNotFound(HCMStatusConstants.STATUS_CODE_NO_PRIVILEGE_ASSIGNED, HCMStatusConstants.STATUS_MSG_NO_PRIVILEGE_ASSIGNED);
        }

        if (HCMUtil.isCollectionNotBlank(roleList)) {
            for (RolePrivilege rolePrivilege : roleList) {
                SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(rolePrivilege.getPrivilege().getPrivilegeName());

                authorities.add(simpleGrantedAuthority);
            }
        }

        List<UserPrivilege> userPrivilegeList = getDaoFactory().getUserPrivilegeDAO().findByUserId(userCredential.getUser().getId());

        if (HCMUtil.isCollectionNotBlank(userPrivilegeList)) {
            for (UserPrivilege userPrivilegeObject : userPrivilegeList) {
                if (userPrivilegeObject.getStatus() == HCMConstants.Common.INT_ONE) {
                    SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(userPrivilegeObject.getPrivilege().getPrivilegeName());

                    authorities.add(simpleGrantedAuthority);
                }
            }
        }*/

        CustomUserDetails customUserDetails = new CustomUserDetails(user.getId(), user.getFirstName(),
                user.getLastName(), user.getEmailAddress(), userCredential.getCredential(),
                userRole.getRole().getRoleName(), user.getDesignation(), user.getOrganization().getId(),
                user.getOrganization().getName(), authorities);

        return customUserDetails;
    }

    /**
     * findRolePrivileges
     *
     * @param authorities
     * @param userRole
     * @throws HCMException
     */
    private void findRolePrivileges(List<GrantedAuthority> authorities, UserRole userRole) throws HCMException {
        List<RolePrivilege> roleList = getDaoFactory().getRolePrivilegeDAO().findByRoleId(userRole.getRole().getId());

        if (!HCMUtil.isCollectionNotBlank(roleList)) {
            HCMHelper.handleResultNotFound(HCMStatusConstants.STATUS_CODE_NO_PRIVILEGE_ASSIGNED, HCMStatusConstants.STATUS_MSG_NO_PRIVILEGE_ASSIGNED);
        }

        if (HCMUtil.isCollectionNotBlank(roleList)) {
            for (RolePrivilege rolePrivilege : roleList) {
                SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(rolePrivilege.getPrivilege().getPrivilegeName());

                authorities.add(simpleGrantedAuthority);
            }
        }
    }

    /**
     * findUserPrivileges
     *
     * @param authorities
     * @param userId
     * @throws HCMException
     */
    private void findUserPrivileges(List<GrantedAuthority> authorities, long userId) throws HCMException {
        List<UserPrivilege> userPrivilegeList = getDaoFactory().getUserPrivilegeDAO().findByUserId(userId);

        if (HCMUtil.isCollectionNotBlank(userPrivilegeList)) {
            for (UserPrivilege userPrivilegeObject : userPrivilegeList) {
                if (userPrivilegeObject.getStatus() == HCMConstants.Common.INT_ONE) {
                    SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(userPrivilegeObject.getPrivilege().getPrivilegeName());

                    authorities.add(simpleGrantedAuthority);
                }
            }
        }
    }
}
