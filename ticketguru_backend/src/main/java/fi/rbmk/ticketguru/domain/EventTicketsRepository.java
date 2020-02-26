package fi.rbmk.ticketguru.domain;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface EventTicketsRepository extends CrudRepository<EventTickets, Long> {

	List<EventTickets> findByEID(@Param("eID") String eID);
}