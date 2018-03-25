package project.event.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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

}
