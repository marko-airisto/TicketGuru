package fi.rbmk.ticketguru.eventType;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface EventTypeRepository extends CrudRepository<EventType, Long> {

<<<<<<< HEAD
	List<EventType> findByName(String name);

=======
	List<EventType> findByName(String name );
	
>>>>>>> 8213816b0e72d3f7ac8c2a70c4c264683756a97f
	List<EventType> findAll();
	// List<EventOrganizer> findByEventName(String eventName);

	// List<EventOrganizer> findByEventInfo(String eventInfo);

}