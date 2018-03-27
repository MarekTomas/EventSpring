package project.event.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import project.event.security.AuthenticationComponent;
import project.event.model.User;
import project.event.service.UserService;

@Controller
@RequestMapping("/adminU")
public class UserController {
	
	private UserService userService;
	private AuthenticationComponent authentication;
	
	@Autowired
	public UserController(UserService userService, AuthenticationComponent authentication) {
		this.userService = userService;
		this.authentication = authentication;
	}
	
	@GetMapping("/registration")
	public String registration(Model model) {
		model.addAttribute("isAdmin", authentication.isAdmin());
		model.addAttribute("user",new User());
		return"registration";
	}
	@PostMapping("/registration")
	public String registration(@Valid @ModelAttribute User user,BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "registration";
		}

		if (userService.isNewUserExists(user.getEmail())) {
			result.rejectValue("email", "error.user.exists", "There is already a user registered with ");
			return "registration";
		}
		
		userService.save(user);
		return "redirect:/";
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
