package fi.rbmk.ticketguru.domain;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface TicketTypeRepository extends CrudRepository<TicketType, Long> {
	
	// TicketType findByTicketType_ID(Long ticketType_ID);
	
	List<TicketType> findByTicketTypeName(String ticketTypeName);
	
}