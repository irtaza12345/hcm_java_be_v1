package com.conurets.hcm.configuration.security;

import com.conurets.hcm.commons.security.CustomWebSecurityConfigurerAdapter;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

/**
 * @author MSA
 * @version 1.0
 */

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurity extends CustomWebSecurityConfigurerAdapter {
    private static final String[] URL_API = new String[]{"/api/authenticate", "/api/logout"};
    private static final String[] URL_RESOURCE = new String[]{"/v3/api-docs/**", "/swagger-ui/**","/swagger-resources/**",
            "/swagger-ui.html",
            "/v2/api-docs",
            "/webjars/**"};
    private static final String[] URL_WEBSOCKET = new String[]{};

    /**
     * WebSecurity
     */
    public WebSecurity() {
        super(URL_API, URL_RESOURCE, URL_WEBSOCKET);
    }
}
