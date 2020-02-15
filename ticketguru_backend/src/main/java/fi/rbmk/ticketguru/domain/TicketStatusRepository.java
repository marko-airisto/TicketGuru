package fi.rbmk.ticketguru.domain;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface TicketStatusRepository extends CrudRepository<TicketStatus, Long> {

	// TicketStatus findByTicketStatus_ID(Long ticketStatus_ID);
	
	List<TicketStatus> findByTicketStatusName(String ticketStatusName);
	
}