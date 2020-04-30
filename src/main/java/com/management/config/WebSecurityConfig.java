package com.management.config;

import com.management.service.UtenteDettaglioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Configuration
@EnableWebSecurity(debug = true)
@EnableGlobalMethodSecurity(securedEnabled=true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UtenteDettaglioService utenteDettaglioService;

    @Autowired
    protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(utenteDettaglioService).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/user/editUser").hasAuthority("SuperUser")
                .antMatchers("/user/newUser").hasAuthority("SuperUser")
                .antMatchers("/user/newUserForm").hasAuthority("SuperUser")
                .antMatchers("/user/editForm").hasAuthority("SuperUser")
                .antMatchers("/user/deleteRequest**").hasAuthority("SuperUser")
                .antMatchers("/user/deleteUser**").hasAuthority("SuperUser")
                .antMatchers("/veicolo/editVehicleForm**").hasAuthority("SuperUser")
                .antMatchers("/veicolo/newVehicleForm").hasAuthority("SuperUser")
                .antMatchers("/veicolo/newVehicle").hasAuthority("SuperUser")
                .antMatchers("/veicolo/editVehicle").hasAuthority("SuperUser")
                .antMatchers("/veicolo/delete").hasAuthority("SuperUser")
                .and()
                .formLogin()
                .loginPage("/userLogin")
                .loginProcessingUrl("/appLogin")
                .defaultSuccessUrl("/home")
                .failureUrl("/userLogin?error=true")
                .permitAll()
                .and()
                .logout()
                .logoutSuccessUrl("/userLogin?logout=true")
                .and()
                .exceptionHandling().accessDeniedPage("/403")
//                .invalidateHttpSession(true)
//                .permitAll()
                .and()
                .csrf()
                .disable();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
}


}
