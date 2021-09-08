package quyennppc01234_Project_ThucTap.Service;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import quyennppc01234_Project_ThucTap.Entity.Users;


@Component
public class CustomUserDetailService implements UserDetailsService, Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	UsersService userService;

	@Autowired
	Users users;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		users = userService.findByUsernameLike(username);
		if (users == null) {
			throw new UsernameNotFoundException("Login Failed");
		}
		System.out.println(users.toString());
		return new CustomUserDetail(users);
	}
}
