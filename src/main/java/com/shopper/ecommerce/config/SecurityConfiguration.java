package com.shopper.ecommerce.config;

import com.okta.spring.boot.oauth.Okta;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.accept.ContentNegotiationStrategy;
import org.springframework.web.accept.HeaderContentNegotiationStrategy;

@Configuration
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        // protect endpoints /api/orders
        http.authorizeRequests(configurer ->
                        configurer
                            .antMatchers("/api/orders/**")
                            .authenticated())
                .oauth2ResourceServer()
                .jwt();   // enables jwt-encoded bearer token support

        // add CORS filter
        http.cors();

        // add content negotiation strategy to support okta sending back friendly response
        http.setSharedObject(ContentNegotiationStrategy.class, new HeaderContentNegotiationStrategy());

        // force a non-empty response body for 401's to make the response more friendly
        Okta.configureResourceServer401ResponseBody(http);

        // By default, csrf is enabled. CSRF performs checks on POST using cookies. Since we are not using cookies
        // for session tracking, CSRF says request is unauthorised.
        // disable CSRF since we are not using Cookies for session tracking
        http.csrf().disable();

        // HttpSecurity supports the builder design pattern hence, we can 'build it' to return the instance
        return http.build();
    }
}
