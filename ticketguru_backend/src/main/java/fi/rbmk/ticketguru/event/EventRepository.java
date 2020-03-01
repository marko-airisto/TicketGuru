package fi.rbmk.ticketguru.event;

import fi.rbmk.ticketguru.domain.AgeLimit;
import fi.rbmk.ticketguru.domain.EventOrganizer;
import fi.rbmk.ticketguru.domain.EventTicket;
import fi.rbmk.ticketguru.domain.EventType;
import fi.rbmk.ticketguru.domain.Venue;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface EventRepository extends CrudRepository<Event, Long> {

    List<Event> findByName(String name);
    List<Event> findByEventType(EventType eventType);
    List<Event> findByEventOrganizer(EventOrganizer eventOrganizer);
    List<Event> findByVenue(Venue venue);
    List<Event> findAll();
}