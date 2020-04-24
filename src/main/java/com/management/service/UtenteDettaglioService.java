package com.management.service;

import com.management.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;

@Service
public class UtenteDettaglioService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.getUserByCF(username);
        return buildUserForAuthentication(user, Collections.singleton(new SimpleGrantedAuthority(user.getTipo())));
    }

    private UserDetails buildUserForAuthentication(User user, Collection<? extends GrantedAuthority> authorities){
        return new org.springframework.security.core.userdetails.User(user.getCf(),
                                                                        user.getPassword(),
                                                                        true,
                                                                        true,
                                                                        true,
                                                                        true,
                                                                        authorities);

    }
}
