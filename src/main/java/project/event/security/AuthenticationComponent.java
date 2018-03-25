package project.event.security;

import java.util.Collection;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationComponent {

	public boolean isAdmin() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Collection<? extends GrantedAuthority> authorities = auth.getAuthorities();
		for (GrantedAuthority grantedAuthority : authorities) {
			return "Admin".equalsIgnoreCase(grantedAuthority.getAuthority());
		}
		return false;
}
}
