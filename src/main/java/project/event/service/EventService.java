package project.event.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.event.model.Event;
import project.event.repository.EventRepository;

@Service
public class EventService {
	
	private EventRepository eventRepository;
	
	@Autowired
	public EventService(EventRepository eventRepository) {
		this.eventRepository = eventRepository;
	}
	
	public List<Event> findAll() {
		//wywołanie metody findAll z repozytorium dla tebeli Car
		List<Event> event = eventRepository.findAll();
		System.out.println("List cars:" + event);
		return event;
	}

}
