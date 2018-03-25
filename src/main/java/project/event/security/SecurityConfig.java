package project.event.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private DataSource dataSource;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.jdbcAuthentication()
			.usersByUsernameQuery("Select email, password, active from user where email=?")
				.authoritiesByUsernameQuery(
						"select u.email, r.name from user u "
						+ "inner join user_role ur on u.id=ur.user_id "
						+ "inner join role r on r.id=ur.roles_id where email=?")
			.dataSource(dataSource);
	}
	

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.authorizeRequests()
		.antMatchers("/","/login","/registration","/aboutMe","/css/**").permitAll()
		.antMatchers("/addE","/deleteE").hasAuthority("admin")
		.anyRequest().authenticated()
		.and()
		.formLogin()
		.loginPage("/login")
		.failureUrl("/login?error=true")
		.defaultSuccessUrl("/")
		.usernameParameter("email")
		.passwordParameter("password")
		.and()
		.logout().logoutUrl("/logout").logoutSuccessUrl("/").permitAll();

		
	}
}
