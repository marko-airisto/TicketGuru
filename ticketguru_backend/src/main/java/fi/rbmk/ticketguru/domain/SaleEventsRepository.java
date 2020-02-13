package fi.rbmk.ticketguru.domain;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface SaleEventsRepository extends CrudRepository<SaleEvents, Long> {
	
	SaleEvents findBySaleEvent_ID(Long SaleEvent_ID);
	List<SaleEvents> findBySaleEvent_ID(String saleEvent_ID);

}
