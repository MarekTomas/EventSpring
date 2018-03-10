package project.event.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import project.event.model.Event;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
	

	
}
