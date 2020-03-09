package fi.rbmk.ticketguru.eventOrganizer;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface EventOrganizerRepository extends CrudRepository<EventOrganizer, Long> {
	
	//List<EventOrganizer> findByName(@Param("name") String name);
	List<EventOrganizer> findAll();
	
}