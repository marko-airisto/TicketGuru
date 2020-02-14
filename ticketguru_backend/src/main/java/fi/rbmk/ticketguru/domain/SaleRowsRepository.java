package fi.rbmk.ticketguru.domain;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface SaleRowsRepository extends CrudRepository<SaleRows, Long> {
	
	SaleRows findbySaleRow_ID(Long saleRow_ID);
	List<SaleRows> findbySaleRow_ID(String saleRow_ID);

}
