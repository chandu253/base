package com.fds.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserDetailsImpl implements UserDetails {
	protected String username;
	protected String password;
	protected List<GrantedAuthority> authories;
	protected boolean enabled;
	protected boolean locked;

	public UserDetailsImpl(String username, String password, String roleName, String status) {
		this.username = username;
		this.password = password;
		authories = new ArrayList<>();
		authories.add(new SimpleGrantedAuthority(roleName));
		if (status != null) {
			if (status.equals("a")) {
				enabled = true;
			} else if (status.equals("l")) {
				locked = true;
			}
		}

	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authories;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return !locked;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return enabled;
	}
}
