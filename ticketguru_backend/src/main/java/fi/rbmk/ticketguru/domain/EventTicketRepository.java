package fi.rbmk.ticketguru.domain;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface EventTicketRepository extends CrudRepository<EventTicket, Long> {

	// EventTicket findByEventTicketId(Long id);

	// List<EventTicket> findByEvent_ID(Long event_ID);

	// List<EventTicket> findByTicketType_ID(Long ticketType_ID);

}