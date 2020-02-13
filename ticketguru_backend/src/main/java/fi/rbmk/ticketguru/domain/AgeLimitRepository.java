package fi.rbmk.ticketguru.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface AgeLimitRepository extends CrudRepository<AgeLimit, Long> {
	
	AgeLimit findByAgeLimit_ID(Long ageLimit_ID);
	List<AgeLimit> findByAgeLimitName(String ageLimitName);
	
}