package project.event.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import project.event.model.User;
import project.event.security.AuthenticationComponent;
import project.event.service.UserService;

@Controller
@RequestMapping("/adminU" )
public class AdminController {
	private UserService userService;
	private AuthenticationComponent authentication;
	
	@Autowired
	public AdminController(UserService userService, AuthenticationComponent authentication) {
		this.userService = userService;
		this.authentication = authentication;
	}
	
	@GetMapping("/{id}")
	public String deleteU(@PathVariable Long id,Model model) {
		model.addAttribute("isAdmin", authentication.isAdmin());
		model.addAttribute("user", userService.getUserById(id));
		return"adminU/deleteU";
	}
	@GetMapping("/deleteU/{id}")
	public String deleteU(@PathVariable Long id) {
		userService.deleteUser(id);
		
		return "redirect:/adminU/deleteU";
	}
	
	@GetMapping("/deleteU")
	public String deleteU(Model model) {
		model.addAttribute("isAdmin", authentication.isAdmin());
		List<User> user = userService.findAll();
		model.addAttribute("user", user);
		return "adminU/deleteU";
		
	}

}
