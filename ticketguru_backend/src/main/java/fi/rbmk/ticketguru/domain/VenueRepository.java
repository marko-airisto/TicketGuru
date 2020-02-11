package fi.rbmk.ticketguru.domain;

import org.springframework.data.repository.CrudRepository;

public interface VenueRepository extends CrudRepository<Venue, Long> {

    Venue findByName(String name);
}