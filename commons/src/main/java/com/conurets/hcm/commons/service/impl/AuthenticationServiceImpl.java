package com.conurets.hcm.commons.service.impl;

import com.conurets.hcm.commons.base.dto.request.AuthenticationRequestDTO;
import com.conurets.hcm.commons.base.dto.response.AuthenticationResponseDTO;
import com.conurets.hcm.commons.base.exception.HCMException;
import com.conurets.hcm.commons.security.model.CustomUserDetails;
import com.conurets.hcm.commons.security.util.HCMSecurityUtil;
import com.conurets.hcm.commons.service.AuthenticationService;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

/**
 * @author MSA
 * @version 1.0
 */

@Slf4j
@Getter
@Service
public class AuthenticationServiceImpl extends BaseServiceImpl implements AuthenticationService {
    /**
     * Authentication and authorization
     *
     * @param model
     * @return
     * @throws HCMException
     */
    public AuthenticationResponseDTO authenticate(AuthenticationRequestDTO model) throws HCMException {
        final Authentication authentication = getAuthenticationManager().authenticate(
                new UsernamePasswordAuthenticationToken(model.getEmailAddress(), model.getPassword())
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        CustomUserDetails customUserDetails = HCMSecurityUtil.getUserDetails();

        final String token = getJwtFactory().generateToken(customUserDetails);

        AuthenticationResponseDTO dto = new AuthenticationResponseDTO();
        dto.setDisplayName(customUserDetails.getDisplayName());
        dto.setToken(token);
        dto.setDesignation(customUserDetails.getDesignation());
        dto.setUserId(customUserDetails.getUserId());
        dto.setOrganizationId(customUserDetails.getOrganizationId());

        return dto;
    }
}
