package fi.rbmk.ticketguru.ticket;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface TicketRepository extends CrudRepository<Ticket, Long> {

    Ticket findByCheckSum(String checkSum);
    List<Ticket> findAll();
}