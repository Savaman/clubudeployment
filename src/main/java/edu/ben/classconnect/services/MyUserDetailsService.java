package edu.ben.classconnect.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import edu.ben.classconnect.daos.interfaces.IUserDao;

@Service("userDetailsService")
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	IUserDao dao;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		edu.ben.classconnect.entities.User user = dao.getUserByUserName(userName);
		
		List<GrantedAuthority> authorities = buildUserAuthority(user.getUserRole().getRole());

		return buildUserForAuthentication(user, authorities);
	}

	private User buildUserForAuthentication(edu.ben.classconnect.entities.User user,
			List<GrantedAuthority> authorities) {
		boolean isEnabled;
		if (user.getActive() == 1) {
			isEnabled = true;
		} else {
			isEnabled = false;
		}
		return new User(user.getUserName(), user.getPassword(), isEnabled, true, true, true, authorities);
	}

	private List<GrantedAuthority> buildUserAuthority(String userRole) {

		List<GrantedAuthority> setAuths = new ArrayList<GrantedAuthority>();
		System.out.println(userRole.toUpperCase());
		setAuths.add(new SimpleGrantedAuthority(userRole.toUpperCase()));
		// Build user's authorities
		// for (UserRole userRole : userRoles) {
		// setAuths.add(new
		// SimpleGrantedAuthority(userRole.getRole().toString().toUpperCase()));
		// }

		

		return setAuths;
	}
}
