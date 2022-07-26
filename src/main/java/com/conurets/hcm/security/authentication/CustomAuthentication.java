package com.conurets.hcm.security.authentication;

import com.conurets.hcm.base.exception.HCMException;
import com.conurets.hcm.base.util.HCMConstants;
import com.conurets.hcm.base.util.HCMHelper;
import com.conurets.hcm.base.util.HCMStatusConstants;
import com.conurets.hcm.security.factory.JwtFactory;
import com.conurets.hcm.service.CustomUserDetailsService;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

/**
 * @author MSA
 * @version 1.0
 */

@Slf4j
@Component
public class CustomAuthentication {
    @Autowired
    private CustomUserDetailsService customUserDetailsService;
    @Autowired
    private JwtFactory jwtFactory;

    @PostConstruct
    public void checkConfiguration() {
        HCMHelper.checkConfiguration(customUserDetailsService, "customUserDetailsService");
        HCMHelper.checkConfiguration(jwtFactory, "jwtFactory");
        //HCMHelper.checkConfiguration(passwordEncoder, "passwordEncoder");
    }

    /**
     * authenticationByToken
     *
     * @param token
     * @throws HCMException
     */
    public void authenticationByToken(String token) throws HCMException {
        String username = HCMConstants.Common.SC_EMPTY;

        if (token == null) {
            HCMHelper.handleJwt(HCMStatusConstants.STATUS_CODE_JWT_INVALID_SIGNATURE, "Empty token");
        }

        try {
            username = jwtFactory.getUsernameFromToken(token);
        } catch (SignatureException e) {
            HCMHelper.handleJwt(HCMStatusConstants.STATUS_CODE_JWT_INVALID_SIGNATURE, e.getMessage());
        } catch (MalformedJwtException e) {
            HCMHelper.handleJwt(HCMStatusConstants.STATUS_CODE_JWT_MALFORMED, e.getMessage());
        } catch (ExpiredJwtException e) {
            HCMHelper.handleJwt(HCMStatusConstants.STATUS_CODE_JWT_EXPIRED, e.getMessage());
        } catch (UnsupportedJwtException e) {
            HCMHelper.handleJwt(HCMStatusConstants.STATUS_CODE_JWT_UNSUPPORTED, e.getMessage());
        } catch (IllegalArgumentException e) {
            HCMHelper.handleJwt(HCMStatusConstants.STATUS_CODE_JWT_ILLEGAL_ARGUMENT, e.getMessage());
        }

        authenticationByToken(token, username);
    }

    /**
     * authenticationByToken
     *
     * @param token
     * @param username
     * @throws HCMException
     */
    public void authenticationByToken(String token, String username) throws HCMException {
        UsernamePasswordAuthenticationToken authentication = null;

        UserDetails userDetails = customUserDetailsService.loadUserByUsername(username);

        if (jwtFactory.validateToken(token, userDetails)) {
            authentication = new UsernamePasswordAuthenticationToken(userDetails, null,
                    userDetails.getAuthorities());

            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
    }

    /**
     * authenticationByUser
     *
     * @param username
     * @param request
     * @throws HCMException
     */
    public void authenticationByUser(String username, String password, HttpServletRequest request) throws HCMException {
        UserDetails userDetails = customUserDetailsService.loadUserByUsername(username);

        boolean isMatched = false; //passwordEncoder.matches(password, userDetails.getPassword());

        //log.info("isMatched={}", isMatched);

        if (!isMatched) {
            HCMHelper.handleAuthentication(9901, "Invalid credentials");
        }

        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails,
                null, userDetails.getAuthorities());

        authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

        SecurityContextHolder.getContext().setAuthentication(authentication);
    }
}
