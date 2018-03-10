package project.event.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import project.event.model.Event;
import project.event.service.EventService;

@Controller
public class IndexController {
	
	private EventService eventService;
	
	@Autowired
	public IndexController( EventService eventService) {
		this.eventService = eventService;

	}
	
	@RequestMapping("/")
	public String index(Model model) {
		
		List<Event> event = eventService.findAll();
		model.addAttribute("event", event);
		return "index";
	}

	@RequestMapping("/index")
	public String index1() {
		return "index";
	}
	

	@RequestMapping("/login")
	public String login() {
		return"login";
	}
}
