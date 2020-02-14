package fi.rbmk.ticketguru.domain;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface EventOrganizersRepository extends CrudRepository<EventOrganizers, Long> {
	
	EventOrganizers findEventOrganizer_ID(Long eventOrganizer_ID);

	List<EventOrganizers> findByCompanyName(String companyName);
	List<EventOrganizers> findByCompanyStreetAddress(String companyStreetAddress);
	List<EventOrganizers> findByCompanyEmail(String companyEmail);
	List<EventOrganizers> findByCompanyTel(String companyTel);
	List<EventOrganizers> findByCompanyWWW(String companyWWW);
	List<EventOrganizers> findByCompanyContactPerson(String companyContactPerson);
			
	List<EventOrganizers> findByPostcode_ID(Long postcode_ID);
	
}