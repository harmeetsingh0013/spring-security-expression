package com.programmersnest.config.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.programmersnest.config.security.handlers.CustomAuthenticationSuccessHandler;

/**
 * Created by Harmeet Singh(Taara) on 14/9/15.
 * @version 1.0
 */

@Configuration
@EnableWebMvcSecurity
@EnableGlobalMethodSecurity(prePostEnabled=true)
@ComponentScan(basePackages="com.harmeetsingh13.config.security")
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter{

    @Autowired
    private CustomSpringSecurityUserService userDetailService;
    @Autowired
    private CustomAuthenticationSuccessHandler successHandler;

    public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(11);
	}
    
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailService).passwordEncoder(passwordEncoder());
    }

    @Bean
    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
    	return super.authenticationManager();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
        	.authorizeRequests()
                .antMatchers("/login").permitAll()
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/user/**").hasRole("USER")
            .and()
            .formLogin()
                .loginProcessingUrl("/authenticate")
                .successHandler(successHandler)
                .failureUrl("/login?error")
            .permitAll();
    }
}
