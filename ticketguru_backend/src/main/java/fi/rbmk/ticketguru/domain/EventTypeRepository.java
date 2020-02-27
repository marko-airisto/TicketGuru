package fi.rbmk.ticketguru.domain;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface EventTypeRepository extends CrudRepository<EventType, Long> {

	List<EventType> findByEventTypes(@Param("name") String name );
	
	// List<EventOrganizer> findByEventName(String eventName);

	// List<EventOrganizer> findByEventInfo(String eventInfo);

}