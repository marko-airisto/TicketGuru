package fi.rbmk.ticketguru.domain;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface PostCodesRepository extends CrudRepository<PostCodes, Long>{
	
	PostCodes findByPostcode_ID(Long postcode_ID);
	List<PostCodes> findByPostcode_ID(String postcode_ID);

}
