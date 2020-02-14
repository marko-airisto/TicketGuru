package fi.rbmk.ticketguru.domain;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface EventTicketsRepository extends CrudRepository<EventTickets, Long> {
	
	EventTickets findEventTickets_ID(Long eventTickets_ID);

	List<EventTickets> findByEvent_ID(Long event_ID);
	List<EventTickets> findByTicketType_ID(Long ticketType_ID);
	
}