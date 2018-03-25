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

import project.event.model.Event;
import project.event.service.EventService;
import project.event.security.AuthenticationComponent;


@Controller
public class EventController {
	
	private AuthenticationComponent authentication;
	private EventService eventService;
	
	@Autowired
	public  EventController (EventService eventService,AuthenticationComponent authentication ) {
		this.authentication = authentication;
		this.eventService = eventService;
	}

	@GetMapping("/addE")
	public String Add(Model model) {
		model.addAttribute("isAdmin", authentication.isAdmin());
		model.addAttribute("event",new Event());
		return"addE";
	}
	@PostMapping("/addE")
	public String registration(@Valid @ModelAttribute Event event,BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "addE";
		}

		if (eventService.isNewEventExists(event.getTitle())) {
			result.rejectValue("title", "error.user.exists", "There is already a Event registered with ");
			return "registration";
		}
		
		eventService.save(event);
		return "redirect:/";
	}
	
	@GetMapping("/{id}")
	public String view(@PathVariable Long id, Model model) {
			model.addAttribute("isAdmin", authentication.isAdmin());
			model.addAttribute("event", eventService.getArticleById(id));
		return "deleteE";
	}
	
	
	@GetMapping("/deleteE/{id}")
	public String deleteE(@PathVariable Long id,Model model ) {
		model.addAttribute("isAdmin", authentication.isAdmin());
		List<Event> event = eventService.findAll();
		model.addAttribute("event", event);
		eventService.deleteEvent(id);
		return "deleteE";
	}

	
}
