package com.fds.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.fds.bo.User;
import com.fds.dao.UserDao;
import com.fds.dto.UserDetailsImpl;

@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	private UserDao userDao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = null;
		UserDetails userDetails = null;

		user = userDao.findUser(username);
		userDetails = new UserDetailsImpl(user.getUsername(), user.getPassword(), user.getUserRole().getRoleName(),
				user.getStatus());

		return userDetails;
	}

}
