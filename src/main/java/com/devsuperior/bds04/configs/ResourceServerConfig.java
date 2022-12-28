package com.devsuperior.bds04.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

import java.util.Arrays;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Autowired  //Auxilia na liberação do h2 console.
    private Environment env;

    private static final String[] PUBLIC = {"/oauth/token", "/h2-console/**"};

    private static final String[] ADMIN_OR_CLIENT = {"/cities/**", "/events/**"};

    private static final String[] ADMIN = {"/users/**"};

    @Override
    public void configure(HttpSecurity http) throws Exception {

        // H2 console.
        if (Arrays.asList(env.getActiveProfiles()).contains("test")) {
            http.headers().frameOptions().disable();
        }

        http.authorizeRequests()
                .antMatchers(PUBLIC).permitAll()
                .antMatchers(HttpMethod.GET, ADMIN_OR_CLIENT).permitAll()
                .antMatchers(ADMIN_OR_CLIENT).hasAnyRole("CLIENT", "ADMIN")
                .antMatchers(ADMIN).hasRole("ADMIN")
                .anyRequest().authenticated();
    }
}
