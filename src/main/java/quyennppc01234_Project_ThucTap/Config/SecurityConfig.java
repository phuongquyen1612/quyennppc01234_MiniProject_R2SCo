package quyennppc01234_Project_ThucTap.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import quyennppc01234_Project_ThucTap.Service.CustomUserDetailService;




@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Autowired
	CustomUserDetailService customuserdetailService;
	
	@Bean
	public DaoAuthenticationProvider daoAuthenticationProvider() {
		DaoAuthenticationProvider daoAuthenticationProvider = new
				DaoAuthenticationProvider();
		daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
		daoAuthenticationProvider.setUserDetailsService(customuserdetailService);
		return daoAuthenticationProvider;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(daoAuthenticationProvider());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.authorizeRequests()
		.antMatchers("/admin/**", "/**/admin/**","/rest/accounts","/**/authorities/**").hasAuthority("ROLE_MANAGER")
		.antMatchers("/staff/**","/**/staff/**").hasAuthority("ROLE_STAFF")
		.antMatchers("/quyenshop/customer/**","/**/customer/**").hasAuthority("ROLE_CUSTOMER")
		.antMatchers("/quyenshop/user").hasAnyAuthority("ROLE_CUSTOMER", "ROLE_MANAGER", "ROLE_STAFF")
		.antMatchers("/**","/css/**","/fonts/**","/images/**",
				"/js/**","/sass/**","/vendor/**", "/assets/**"
				,"/admin","/quyenshop/admin/qtypro").permitAll()
		.and() 
		.formLogin().permitAll()
		.loginPage("/quyenshop/login")
		.loginProcessingUrl("/j_spring_security_check")
		.defaultSuccessUrl("/quyenshop/index")
		.failureUrl("/quyenshop/login?error")
		.and()
		.logout().permitAll()
		.logoutUrl("/quyenshop/logout")
		.logoutSuccessUrl("/quyenshop/index")
		.and()
		.exceptionHandling().accessDeniedPage("/quyenshop/403");
	}
	
	
	
}
