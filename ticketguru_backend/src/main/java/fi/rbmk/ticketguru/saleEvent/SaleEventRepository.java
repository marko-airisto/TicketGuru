package fi.rbmk.ticketguru.saleEvent;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface SaleEventRepository extends CrudRepository<SaleEvent, Long> {
	List<SaleEvent> findAll();
}
