package fi.rbmk.ticketguru.domain;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface TicketStatusRepository extends CrudRepository<TicketStatus, Long> {

	List<TicketStatus> findByName(String name);
	List<TicketStatus> findAll();
	
}