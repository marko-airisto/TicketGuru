package fi.rbmk.ticketguru.domain;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface EventTypesRepository extends CrudRepository<EventTypes, Long> {
	
	EventTypes findEventType_ID(Long eventType_ID);

	List<EventOrganizers> findByEventName(String eventName);
	List<EventOrganizers> findByEventInfo(String eventInfo);
	
	
}