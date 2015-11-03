package org.miwoa.merrimack.security;

import java.util.Arrays;
import java.util.List;

import org.miwoa.merrimack.dao.MiwoaUserDao;
import org.miwoa.merrimack.model.MiwoaUser;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class MiwoaUserService implements UserDetailsService {

	MiwoaUserDao userDao = new MiwoaUserDao();
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		MiwoaUser user = userDao.findUser(email);
		
		if (user == null) {
			throw new UsernameNotFoundException("Not registered");
		}
		
		List<SimpleGrantedAuthority> authorities = Arrays.asList(new SimpleGrantedAuthority(user.getRole()));
		
		return new User(user.getEmail(), user.getEncrpytedPassword(), authorities);
	}

}
