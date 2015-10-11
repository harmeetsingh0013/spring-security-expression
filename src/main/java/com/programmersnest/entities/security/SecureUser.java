package com.programmersnest.entities.security;

import com.programmersnest.entities.User;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Harmeet Singh(Taara) on 14/9/15.
 * @version 1.0
 */

public class SecureUser extends User implements UserDetails {

    /**
	 * 
	 */
	private static final long serialVersionUID = 8857741164097610279L;
	
    public SecureUser(User user){
    	
    	this.setId(user.getId());
    	this.setName(user.getName());
    	this.setEmail(user.getEmail());
    	this.setSecret(user.getSecret());
    	this.setRole(user.getRole());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(this.getRole()));
        return authorities;
    }

    @Override
	public String getName() {
		return super.getName();
	}

	@Override
    public String getPassword() {
        return this.getSecret();
    }

    @Override
    public String getUsername() {
        return this.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
