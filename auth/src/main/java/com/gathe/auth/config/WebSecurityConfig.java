package com.gathe.auth.config;

import com.gathe.auth.security.OAuthClientAuthenticationProvider;
import com.gathe.auth.security.OAuthClientVerifiedVoter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.vote.AuthenticatedVoter;
import org.springframework.security.access.vote.UnanimousBased;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.expression.WebExpressionVoter;

import java.util.List;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private OAuthClientAuthenticationProvider authenticationProvider;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(31);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                    .antMatchers("/web/admin/client/account/register").permitAll()
                    .antMatchers("/web/admin/client/**").authenticated()
                .anyRequest()
                    .anonymous()

                .and()
                .formLogin()
                    .loginPage("/web/admin/client/account/login").permitAll()
                    .loginProcessingUrl("/web/admin/client/account/login/")
                .and()
                .logout().permitAll().logoutUrl("/web/admin/client/account/logout")

                .and()
                .csrf().disable();
    }

    @Bean
    public AccessDecisionManager unanimousDecisionManager() {
        List<AccessDecisionVoter<? extends Object>> decisionVoters = List.of(new OAuthClientVerifiedVoter(), new AuthenticatedVoter(), new WebExpressionVoter());

        return new UnanimousBased(decisionVoters);
    }
}
