package fi.rbmk.ticketguru.domain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class EventTicketController {

	@Autowired
    private EventTicketRepository etktrepository;

    @GetMapping("api/eventTickets")

    public List<EventTicket> evenTicketsListRest() {
        return (List<EventTicket>) etktrepository.findAll();
    }
	
}
