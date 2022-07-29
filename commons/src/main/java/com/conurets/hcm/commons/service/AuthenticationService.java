package com.conurets.hcm.commons.service;


import com.conurets.hcm.commons.base.dto.request.AuthenticationRequestDTO;
import com.conurets.hcm.commons.base.dto.response.AuthenticationResponseDTO;
import com.conurets.hcm.commons.base.exception.HCMException;

/**
 * @author MSA
 * @version 1.0
 */

public interface AuthenticationService {
    AuthenticationResponseDTO authenticate(AuthenticationRequestDTO model) throws HCMException;
}
