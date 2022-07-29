package com.conurets.hcm.commons.security.util;

import com.conurets.hcm.commons.base.util.HCMConstants;
import com.conurets.hcm.commons.base.util.HCMMessageUtil;
import com.conurets.hcm.commons.base.util.HCMStatusConstants;
import com.conurets.hcm.commons.base.util.HCMUtil;
import com.conurets.hcm.commons.persistence.entity.UserPrivilege;
import com.conurets.hcm.commons.security.model.CustomUserDetails;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * @author MSA
 * @version 1.0
 */

@Slf4j
public class HCMSecurityUtil {
    public static void main(String[] args) {
        //System.out.println(generatePassword("test123"));

        //boolean is = new BCryptPasswordEncoder().matches("superadmin", "$2a$10$9/K2knY/Dclz3.BQzULKYejzYkNuclVP.mCASks.5fsjgOk6IMgJy");

        //log.info("is={}", is);

        //log.info("encode={}", FLUtil.encode("cts.gateway.user:test123"));
        //log.info("encode={}", HCMUtil.encode("cts.gateway.user:test123"));
    }

    /**
     * Create auto password
     *
     * @param length
     * @return
     */
    public static String createAutoPassword(int length) {
        char[] alphabet = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y',
                'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'J', 'K', 'L', 'M', 'N', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '1', '2', '3',
                '4', '5', '6', '7', '8', '9', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

        int range = alphabet.length;
        Random r = new Random();
        StringBuffer sb = new StringBuffer(length);

        for (int i = HCMConstants.Common.INT_ZERO; i < length; i++) {
            sb.append(alphabet[r.nextInt(range)]);
        }

        return sb.toString();
    }

    /**
     * Create OTP
     *
     * @param length
     * @return
     */
    public static String createOTP(int length) {
        char[] alphabet = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

        int range = alphabet.length;
        Random r = new Random();
        StringBuffer sb = new StringBuffer(length);

        for (int i = HCMConstants.Common.INT_ZERO; i < length; i++) {
            sb.append(alphabet[r.nextInt(range)]);
        }

        return sb.toString();
    }

    /**
     * Get logged in user id
     *
     * @return
     */
    public static long getLoggedInUserId() {
        return (getUserDetails() == null) ? HCMConstants.Common.DEFAULT_USER_ID : getUserDetails().getUserId();
    }

    /**
     * Get logged in user name
     *
     * @return
     */
    public static String getLoggedInUsername() {
        return (getUserDetails() == null) ? HCMConstants.Common.SC_EMPTY : getUserDetails().getUsername();
    }

    /**
     * Get logged in user full name
     *
     * @return
     */
    public static String getLoggedInFullName() {
        return (getUserDetails() == null) ? HCMConstants.Common.SC_EMPTY : getUserDetails().getDisplayName();
    }

    /**
     * Get logged in organization id
     *
     * @return
     */
    public static long getLoggedInUserOrganizationId() {
        return (getUserDetails() == null) ? HCMConstants.Common.DEFAULT_USER_ID : getUserDetails().getOrganizationId();
    }

    /**
     * Get logged in user role
     *
     * @return
     */
    public static String getUserRole() {
        return getUserDetails().getRole();
    }

    /**
     * Generate password
     *
     * @param input
     * @return
     */
    public static String generatePassword(String input) {
        return new BCryptPasswordEncoder(HCMConstants.Common.INT_TWELVE).encode(input);
    }

    /**
     * Get logged in user detail
     *
     * @return
     */
    public static CustomUserDetails getUserDetails() {
        CustomUserDetails customUserDetails = null;

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null && authentication.getPrincipal() instanceof CustomUserDetails) {
            customUserDetails = (CustomUserDetails) authentication.getPrincipal();
        }

        return customUserDetails;
    }

    /**
     * Get user access list
     *
     * @param userPrivileges
     * @return
     */
    public static List<GrantedAuthority> getGrantedAuthorities(List<UserPrivilege> userPrivileges) {
        List<GrantedAuthority> authorities = new ArrayList<>();

        authorities = userPrivileges.stream().map(userPrivilege -> {
            SimpleGrantedAuthority simpleGrantedAuthority =
                    new SimpleGrantedAuthority(userPrivilege.getPrivilege().getPrivilegeName());

            return simpleGrantedAuthority;
        }).collect(Collectors.toList());

        return authorities;
    }

    /**
     * findUserPrivileges
     *
     * @param privilegeName
     * @return
     */
    public static boolean findUserPrivileges(String privilegeName) {
        List<GrantedAuthority> grantedAuthorities = (List<GrantedAuthority>) getUserDetails().getAuthorities();

        return HCMUtil.containsName(grantedAuthorities, privilegeName);
    }

    /**
     * validateAuthentication
     *
     * @param messageUtil
     */
    public static void validateAuthentication(HCMMessageUtil messageUtil) {
        CustomUserDetails customUserDetails = getUserDetails();

        if (customUserDetails == null) {
            messageUtil.handleJwt(HCMStatusConstants.STATUS_CODE_NO_TOKEN_FOUND);
        }
    }

    /**
     * getJwt
     *
     * @param request
     * @return
     */
    public static String getJwt(HttpServletRequest request) {
        String authHeader = request.getHeader(HCMConstants.Header.AUTHORIZATION);

        if (authHeader != null && authHeader.startsWith(HCMConstants.Header.AUTHORIZATION_BEARER_SPACE)) {
            return authHeader.replace(HCMConstants.Header.AUTHORIZATION_BEARER_SPACE, HCMConstants.Common.SC_EMPTY);
        }

        return null;
    }

    /**
     * getBasic
     *
     * @param request
     * @return
     */
    public static String getBasic(HttpServletRequest request) {
        String authHeader = request.getHeader(HCMConstants.Header.AUTHORIZATION);

        if (authHeader != null && authHeader.startsWith(HCMConstants.Header.AUTHORIZATION_BASIC_SPACE)) {
            return authHeader.replace(HCMConstants.Header.AUTHORIZATION_BASIC_SPACE, HCMConstants.Common.SC_EMPTY);
        }

        return null;
    }

    /**
     * getAuthorizationType
     *
     * @param request
     * @return
     */
    public static String getAuthorizationType(HttpServletRequest request) {
        String authorizationType = HCMConstants.Common.SC_EMPTY;
        String authorizationHeader = request.getHeader(HCMConstants.Header.AUTHORIZATION);

        if (authorizationHeader != null && authorizationHeader.startsWith(HCMConstants.Header.AUTHORIZATION_BEARER_SPACE)) {
            authorizationType = HCMConstants.Header.AUTHORIZATION_BEARER;
        } else if (authorizationHeader != null && authorizationHeader.startsWith(HCMConstants.Header.AUTHORIZATION_BASIC_SPACE)) {
            authorizationType = HCMConstants.Header.AUTHORIZATION_BASIC;
        }

        return authorizationType;
    }
}
