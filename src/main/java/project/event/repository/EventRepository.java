package project.event.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.event.model.Event;



@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
	
	Event findOneByTitle(String title);

	
}
