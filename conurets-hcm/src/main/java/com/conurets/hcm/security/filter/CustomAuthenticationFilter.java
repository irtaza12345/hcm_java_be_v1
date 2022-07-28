package com.conurets.hcm.security.filter;

import com.conurets.hcm.base.exception.JwtException;
import com.conurets.hcm.base.util.HCMConstants;
import com.conurets.hcm.base.util.HCMHelper;
import com.conurets.hcm.base.util.HCMMessageUtil;
import com.conurets.hcm.security.authentication.CustomAuthentication;
import com.conurets.hcm.security.util.HCMSecurityUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.annotation.PostConstruct;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * @author MSA
 * @version 1.0
 */

@Slf4j
@Component
public class CustomAuthenticationFilter extends OncePerRequestFilter {
    @Autowired
    private CustomAuthentication customAuthentication;
    @Autowired
    private HCMMessageUtil messageUtil;

    @PostConstruct
    public void checkConfiguration() {
        HCMHelper.checkConfiguration(customAuthentication, "customAuthentication");
        HCMHelper.checkConfiguration(messageUtil, "messageUtil");
    }

    /**
     * doFilterInternal
     *
     * @param request
     * @param response
     * @param chain
     * @throws ServletException
     * @throws IOException
     */
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws ServletException, IOException {
        try {
            //log.info("base64Credentials={}", FLSecurityUtil.getBasic(request));

            final String authorizationType = HCMSecurityUtil.getAuthorizationType(request);

            //log.info("authorizationType={}", authorizationType);

            if (HCMConstants.Header.AUTHORIZATION_BEARER.equals(authorizationType)) {
                final String token = HCMSecurityUtil.getJwt(request);

                //log.info("token={}", token);

                customAuthentication.authenticationByToken(token);
            } else if (HCMConstants.Header.AUTHORIZATION_BASIC.equals(authorizationType)) {
                final String base64Credentials = HCMSecurityUtil.getBasic(request);

                //log.info("base64Credentials={}", base64Credentials);

                byte[] credDecoded = Base64.getDecoder().decode(base64Credentials);
                String credentials = new String(credDecoded, StandardCharsets.UTF_8);
                // credentials = username:password
                final String[] values = credentials.split(HCMConstants.Common.SC_COLON, HCMConstants.Common.INT_TWO);

                //log.info("u={}, p={}", values[FLConstants.INT_ZERO].toString(), values[FLConstants.INT_ONE].toString());

                customAuthentication.authenticationByUser(values[HCMConstants.Common.INT_ZERO].toString(),
                        values[HCMConstants.Common.INT_ONE].toString(), request);
            }

            chain.doFilter(request, response);
        } catch (JwtException e) {
            messageUtil.setJwtErrorResponse(response, e.getCode(), e.getMessage());
        }
    }
}
