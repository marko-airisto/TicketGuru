package fi.rbmk.ticketguru.domain;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface SaleEventRepository extends CrudRepository<SaleEvent, Long> {
	// SaleEvent findBySaleEvent_ID(Long SaleEvent_ID);

	// List<SaleEvent> findBySaleEvent_ID(String saleEvent_ID);
}
