package project.event.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import project.event.security.AuthenticationComponent;

@Controller
@RequestMapping("/user")
public class UserController {
	
	private AuthenticationComponent authentication;
	
	@Autowired
	public UserController(AuthenticationComponent authentication) {
		this.authentication = authentication;
	}
	
	@GetMapping("/userProfile")
	public String userProfile(Model model) {
		model.addAttribute("isUser", authentication.isUser());
		return "user/userProfile";
		
	}
	

}
