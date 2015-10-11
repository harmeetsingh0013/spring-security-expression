package com.programmersnest.config.security;

import com.programmersnest.entities.User;
import com.programmersnest.entities.security.SecureUser;
import com.programmersnest.repo.UserRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Harmeet Singh(Taara) on 14/9/15.
 * @version 1.0
 */

@Component
public class CustomSpringSecurityUserService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        List<User> users = userRepo.findByEmail(email.trim());
        if(users.isEmpty()){
            throw new UsernameNotFoundException("user name not found");
        }
        return new SecureUser(users.get(0));
    }
}
