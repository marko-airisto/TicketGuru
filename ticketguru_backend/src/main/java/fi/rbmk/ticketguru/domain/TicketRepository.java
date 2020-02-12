package fi.rbmk.ticketguru.domain;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface TicketRepository extends CrudRepository<Ticket, Long> {

    Ticket findByTicketId(Long id);
    Ticket findByTicketCheckSum(String checkSum);
    List<Ticket> findAll();
}