package com.management.config;

import com.management.service.UtenteDettaglioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
@EnableWebSecurity(debug = true)
@EnableGlobalMethodSecurity(securedEnabled=true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UtenteDettaglioService utenteDettaglioService;


    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(utenteDettaglioService);
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/userLogin")
                .permitAll()
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
                .invalidateHttpSession(true)
                .permitAll()
                .and()
                .csrf()
                .disable();
//        http.authorizeRequests()
//                .antMatchers("/form")
//                .hasAnyRole("SuperUser", "Customer")
//                .and()
//                .formLogin()
//                .loginPage("/loginForm.jsp")
//                .loginProcessingUrl("/appLogin")
//                .usernameParameter("username")
//                .passwordParameter("password")
//                .defaultSuccessUrl("/home")
//                .failureUrl("/userLogin?error=true")
//                .and()
//                .logout()
//                .logoutSuccessUrl("/userLogin?logout=true");

        //        http.authorizeRequests()
//                .anyRequest()
//                .permitAll()
//                .and()
//                .formLogin()
//                .loginPage("/login")
//                .usernameParameter("username")
//                .passwordParameter("password")
//                .defaultSuccessUrl("/home")
//                .failureUrl("/errorLogin")
//                .and()
//                .logout()
//                .logoutUrl("/logout")
//                .logoutSuccessUrl("/index")
//                .and()
//                .csrf().disable();
    }

//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(utenteDettaglioService).passwordEncoder(passwordEncoder());
//    }
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//        return passwordEncoder;
//    }

}
