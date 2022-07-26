package com.conurets.hcm.security;

import com.conurets.hcm.base.util.HCMConstants;
import com.conurets.hcm.base.util.HCMHelper;
import com.conurets.hcm.security.exception.CustomAccessDeniedHandler;
import com.conurets.hcm.security.exception.CustomAuthenticationEntryPoint;
import com.conurets.hcm.security.filter.CustomAuthenticationFilter;
import com.conurets.hcm.service.CustomUserDetailsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import javax.annotation.PostConstruct;
import java.util.Arrays;

/**
 * @author MSA
 * @version 1.0
 */

@Slf4j
public abstract class CustomWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {
    private String[] apiUrl;
    private String[] resourceUrl;
    private String[] websocketUrl;

    @Autowired
    private CustomUserDetailsService customUserDetailsService;
    @Autowired
    private CustomAuthenticationFilter customAuthenticationFilter;
    @Autowired
    private CustomAuthenticationEntryPoint customAuthenticationEntryPoint;
    @Autowired
    private CustomAccessDeniedHandler customAccessDeniedHandler;

    /**
     * checkConfiguration
     */
    @PostConstruct
    public void checkConfiguration() {
        HCMHelper.checkConfiguration(customUserDetailsService, "customUserDetailsService");
        HCMHelper.checkConfiguration(customAuthenticationFilter, "customAuthenticationFilter");
        HCMHelper.checkConfiguration(customAuthenticationEntryPoint, "customAuthenticationEntryPoint");
        HCMHelper.checkConfiguration(customAccessDeniedHandler, "customAccessDeniedHandler");
    }

    /**
     * CustomWebSecurityConfigurerAdapter
     */
    public CustomWebSecurityConfigurerAdapter() {
    }

    /**
     * CustomWebSecurityConfigurerAdapter
     *
     * @param apiUrl
     * @param resourceUrl
     * @param websocketUrl
     */
    public CustomWebSecurityConfigurerAdapter(String[] apiUrl, String[] resourceUrl, String[] websocketUrl) {
        this.apiUrl = apiUrl;
        this.resourceUrl = resourceUrl;
        this.websocketUrl = websocketUrl;
    }

    /**
     * configureGlobal
     *
     * @param auth
     * @throws Exception
     */
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserDetailsService).passwordEncoder(passwordEncoder());
    }

    /**
     * passwordEncoder
     *
     * @return
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * authenticationManagerBean
     *
     * @return
     * @throws Exception
     */
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    /**
     * configure
     *
     * @param httpSecurity
     * @throws Exception
     */
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .csrf().disable()
                .formLogin().disable()
                .headers().frameOptions().disable()
                .and()
                .authorizeRequests()
                .antMatchers(this.apiUrl).permitAll()
                .antMatchers(this.websocketUrl).permitAll()
                .anyRequest().authenticated()
                .and()
                .exceptionHandling()
                .authenticationEntryPoint(customAuthenticationEntryPoint)
                .accessDeniedHandler(customAccessDeniedHandler)
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        httpSecurity.addFilterBefore(customAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
        httpSecurity.cors();
    }

    /**
     * corsConfigurationSource
     *
     * @return
     */
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        final CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList(HCMConstants.Common.SC_STAR));
        configuration.setAllowedMethods(Arrays.asList(HCMConstants.Header.ALLOW_METHOD_HEAD,
                HCMConstants.Header.ALLOW_METHOD_GET, HCMConstants.Header.ALLOW_METHOD_POST,
                HCMConstants.Header.ALLOW_METHOD_PUT, HCMConstants.Header.ALLOW_METHOD_DELETE,
                HCMConstants.Header.ALLOW_METHOD_PATCH));

        // setAllowCredentials(true) is important, otherwise:
        // The value of the 'Access-Control-Allow-Origin' header in the response must not be the wildcard '*' when the request's credentials mode is 'include'.

        configuration.setAllowCredentials(Boolean.TRUE);

        // setAllowedHeaders is important! Without it, OPTIONS preflight request
        // will fail with 403 Invalid CORS request

        configuration.setAllowedHeaders(Arrays.asList(HCMConstants.Header.ALLOW_HEADER_AUTHORIZATION,
                HCMConstants.Header.ALLOW_HEADER_CACHE_CONTROL, HCMConstants.Header.ALLOW_HEADER_CONTENT_TYPE));

        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration(HCMConstants.Header.ALLOW_PATH, configuration);

        return source;
    }

    /**
     * configure
     *
     * @param web
     * @throws Exception
     */
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers(this.resourceUrl);
    }
}
