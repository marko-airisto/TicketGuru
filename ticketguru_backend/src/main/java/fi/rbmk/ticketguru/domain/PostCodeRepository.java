package fi.rbmk.ticketguru.domain;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface PostCodeRepository extends CrudRepository<Postcode, Long>{
	
	// List<Postcode> findByPostcode_ID(String postcode_ID);
}
