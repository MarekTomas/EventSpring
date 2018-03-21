package project.event.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import project.event.model.Event;
import project.event.service.EventService;

@Controller
public class IndexController {
	
	private EventService eventService;
	
	@Autowired
	public IndexController( @Autowired EventService eventService) {
		this.eventService = eventService;

	}
	
	@GetMapping("/")
	public String index(Model model) {
		
		List<Event> event = eventService.findAll();
		model.addAttribute("event", event);
		return "index";
	}

	@GetMapping("/index")
	public String index1() {
		return "index";
	}
	

	@GetMapping("/login")
	public String login() {
		return"login";
	}
	@GetMapping("/nowy")
	public String nowy() {
		return"nowy";
	}
}
