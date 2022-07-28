package com.conurets.hcm.service;

import com.conurets.hcm.base.dto.request.AuthenticationRequestDTO;
import com.conurets.hcm.base.dto.response.AuthenticationResponseDTO;
import com.conurets.hcm.base.exception.HCMException;

/**
 * @author MSA
 * @version 1.0
 */

public interface AuthenticationService {
    AuthenticationResponseDTO authenticate(AuthenticationRequestDTO model) throws HCMException;
}
