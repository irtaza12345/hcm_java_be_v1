package com.conurets.hcm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author MSA
 * @version 1.0
 */

@SpringBootApplication(scanBasePackages =  {"com.conurets.hcm.*"})
@EnableWebMvc
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class ConureHCMApplication extends SpringBootServletInitializer {
    /**
     * configure
     *
     * @param application
     * @return
     */
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(ConureHCMApplication.class);
    }

    /**
     * main
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        SpringApplication.run(ConureHCMApplication.class, args);
    }
}
