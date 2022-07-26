package com.conurets.hcm.controller;

import com.conurets.hcm.base.dto.request.AuthenticationRequestDTO;
import com.conurets.hcm.base.dto.response.AuthenticationResponseDTO;
import com.conurets.hcm.base.dto.response.BaseResponseDTO;
import com.conurets.hcm.base.exception.HCMException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

/**
 * @author MSA
 * @version 1.0
 */

@Slf4j
@Controller
public class AuthenticationController extends BaseController {
    /**
     * Authentication and authorization
     *
     * @return AuthenticationResponseDTO
     */
    @ResponseBody
    @PostMapping(value = "/api/authenticate")
    public BaseResponseDTO authenticate(@RequestBody @Valid AuthenticationRequestDTO model) throws HCMException {
        AuthenticationResponseDTO dto = getServiceFactory().getAuthenticationService().authenticate(model);

        return response(dto);
    }
}
