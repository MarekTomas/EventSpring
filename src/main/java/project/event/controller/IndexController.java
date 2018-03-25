package project.event.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import project.event.model.Event;
import project.event.security.AuthenticationComponent;
import project.event.service.EventService;

@Controller
public class IndexController {
	
	private EventService eventService;
	private AuthenticationComponent authentication;
	
	@Autowired
	public IndexController( @Autowired EventService eventService,@Autowired AuthenticationComponent authentication ) {
		this.eventService = eventService;
		this.authentication = authentication;
	}
	
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("isAdmin", authentication.isAdmin());
		List<Event> event = eventService.findAll();
		model.addAttribute("event", event);
		return "index";
	}

	@GetMapping("/index")
	public String index1() {
		return "index";
	}
	
	@GetMapping("/login")
	public String login(Model model) {
		model.addAttribute("isAdmin", authentication.isAdmin());
		return"login";
	}
	
	@GetMapping("/aboutMe")
	public String aboutMe(Model model) {
		model.addAttribute("isAdmin", authentication.isAdmin());
		return"aboutMe";
	}
	
	
}
