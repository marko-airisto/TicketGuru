package fi.rbmk.ticketguru.domain;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface EventRepository extends CrudRepository<Event, Long> {

    List<Event> findByName(String name);
    List<Event> findByEventType(EventType eventType);
    List<Event> findByEventOrganizer(EventOrganizer eventOrganizer);
    List<Event> findByVenue(Venue venue);
    List<Event> findAll();
}