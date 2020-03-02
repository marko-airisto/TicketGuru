package fi.rbmk.ticketguru.domain;

import fi.rbmk.ticketguru.event.Event;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface EventTicketRepository extends CrudRepository<EventTicket, Long> {

  List<EventTicket> findByEvent(Event event);
  // List<EventTicket> findByTicketType_ID(Long ticketType_ID);

}