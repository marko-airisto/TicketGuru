package fi.rbmk.ticketguru.domain;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface EventOrganizerRepository extends CrudRepository<EventOrganizer, Long> {
	
	List<EventOrganizer> findByCompanyName(String companyName);
	List<EventOrganizer> findByCompanyStreetAddress(String companyStreetAddress);
	List<EventOrganizer> findByCompanyEmail(String companyEmail);
	List<EventOrganizer> findByCompanyTel(String companyTel);
	List<EventOrganizer> findByCompanyWWW(String companyWWW);
	List<EventOrganizer> findByCompanyContactPerson(String companyContactPerson);
	
}