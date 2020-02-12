package fi.rbmk.ticketguru.domain;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface PostcodesRepository extends CrudRepository<Postcodes, Long> {
	
	Postcodes findPostcode_ID(Long postcode_ID);

	List<Postcodes> findByCity(String city);
	List<Postcodes> findByCountry(String country);
	
	
}