package fi.rbmk.ticketguru.ticketStatus;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface TicketStatusRepository extends CrudRepository<TicketStatus, Long> {

	List<TicketStatus> findByName(String name);
	List<TicketStatus> findAll();
	
}