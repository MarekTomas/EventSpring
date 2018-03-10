package project.event.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import project.event.model.User;
import project.event.service.UserService;

@Controller
public class UserController {
	
	private UserService userService;
	
	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping("/registration")
	public String registration(Model model) {
		model.addAttribute("user",new User());
		return"registration";
	}
	@PostMapping("/registration")
	public String registration(@ModelAttribute User user) {
		userService.save(user);
		return "redirect:/registration";
	}

}
