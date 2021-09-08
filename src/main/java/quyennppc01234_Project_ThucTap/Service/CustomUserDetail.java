package quyennppc01234_Project_ThucTap.Service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import quyennppc01234_Project_ThucTap.Entity.Roles;
import quyennppc01234_Project_ThucTap.Entity.Users;

@AllArgsConstructor
public class CustomUserDetail implements UserDetails, Serializable{
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	@Autowired
	Users users;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<Roles> roles = users.getRole();
		List<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
		for (Roles roles2 : roles) {
			authorities.add(new SimpleGrantedAuthority(roles2.getRoleid()));
		}
		return authorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return users.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return users.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		
		return users.getActivated();
	}

}
