package project.event.service;


import java.util.Date;
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
		List<Event> event = eventRepository.findAll();
		return event;
	}
	public boolean isNewEventExists(String title) {
		return eventRepository.findOneByTitle(title) != null;
	}
	
	public Event save(Event event) {
		event.setTerm(new Date() );
		return eventRepository.save(event);
	}
	
	public void deleteEvent(Long id) {
		eventRepository.delete(id);
		
	}
	public Event getEventById(Long id) {
		return eventRepository.findOne(id);
	}
	
	
}
