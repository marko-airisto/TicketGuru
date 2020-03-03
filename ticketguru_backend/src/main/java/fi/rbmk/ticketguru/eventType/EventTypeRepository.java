package fi.rbmk.ticketguru.eventType;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import fi.rbmk.ticketguru.eventOrganizer.EventOrganizer;


@RepositoryRestResource
public interface EventTypeRepository extends CrudRepository<EventType, Long> {

	List<EventType> findByName(@Param("name") String name);
}