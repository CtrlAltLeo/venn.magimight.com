package com.magimight.venn.website.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.
                authorizeHttpRequests((requests) ->
                        requests.requestMatchers("/admin/**", "/admindata/**").hasAuthority("CREATE")
                                .anyRequest().permitAll())
                .formLogin((form) -> form.loginPage("/login").permitAll())
                .logout((logout) -> logout.logoutSuccessUrl("/logout"));

        return http.build();
    }
}
