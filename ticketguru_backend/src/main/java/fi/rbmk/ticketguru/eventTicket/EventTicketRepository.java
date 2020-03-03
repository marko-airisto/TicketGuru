package fi.rbmk.ticketguru.eventTicket;

import fi.rbmk.ticketguru.domain.Ticket;
import fi.rbmk.ticketguru.domain.TicketType;
import fi.rbmk.ticketguru.event.Event;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface EventTicketRepository extends CrudRepository<EventTicket, Long> {

		
	List<EventTicket> findByEvent(Event event);
    List<EventTicket> findByTicketType(TicketType ticketType);
    
    List<EventTicket> findAll();
    
}