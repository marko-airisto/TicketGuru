package fi.rbmk.ticketguru.domain;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(value = "/api/tickets", produces = "application/hal+json")
class TicketController {

    @Autowired private TicketRepository trepository;

    // Get all tickets
    @GetMapping
    List<Ticket> all() {
        return trepository.findAll();
    }
    // Get single ticket by id
    @GetMapping("/{id}")
    Ticket one(@PathVariable Long id) {
        return trepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Invalid ID: " + id));
    }
    // Delete ticket
    @DeleteMapping("/{id}")
    void deleteTicket(@PathVariable Long id) {
        trepository.deleteById(id);
    }
}