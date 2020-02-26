package fi.rbmk.ticketguru.domain;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface EventTypeRepository extends CrudRepository<EventType, Long> {

	// List<EventOrganizer> findByEventName(String eventName);

	// List<EventOrganizer> findByEventInfo(String eventInfo);

}