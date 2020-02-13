package fi.rbmk.ticketguru.domain;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface PostCodeRepository extends CrudRepository<PostCode, Long>{
	
	PostCode findByPostcode_ID(Long postcode_ID);
	List<PostCode> findByPostcode_ID(String postcode_ID);

}
