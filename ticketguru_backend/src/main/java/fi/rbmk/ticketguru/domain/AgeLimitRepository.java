package fi.rbmk.ticketguru.domain;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface AgeLimitRepository extends CrudRepository<AgeLimit, Long> {
	
	List<AgeLimit> findByName(String name);
	List<AgeLimit> findAll();
	
}