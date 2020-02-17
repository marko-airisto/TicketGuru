package fi.rbmk.ticketguru.domain;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface SaleRowRepository extends CrudRepository<SaleRow, Long> {
	
	// SaleRow findbySaleRow_ID(Long saleRow_ID);
	// List<SaleRow> findbySaleRow_ID(String saleRow_ID);

}
