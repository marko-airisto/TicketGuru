package fi.rbmk.ticketguru.domain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(value = "/api/eventTickets", produces = "application/hal+json")
class EventTicketController {

    @Autowired private EventTicketRepository eTicketRepository;
    @Autowired private EventTicketResourceAssembler eTicketAssembler;

    @GetMapping()
    public ResponseEntity<CollectionModel<EntityModel<EventTicket>>> findAll() {
        return ResponseEntity.ok(eTicketAssembler.toCollectionModel(eTicketRepository.findAll()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<EventTicket>> one(@PathVariable Long id) {
        return eTicketRepository.findById(id)
            .map(eTicketAssembler::toModel)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }  
}