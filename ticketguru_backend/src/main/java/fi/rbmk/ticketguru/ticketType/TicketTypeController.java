package fi.rbmk.ticketguru.ticketType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(value = "/api/tickettypes", produces = "application/hal+json")
public class TicketTypeController {
	
	@Autowired
	private TicketTypeRepository ttrepository;
	
	@Autowired
	private TicketTypeResourceAssembler ttAssembler;
	
	@GetMapping()
    public ResponseEntity<CollectionModel<EntityModel<TicketType>>> findAll() {
        return ResponseEntity.ok(ttAssembler.toCollectionModel(ttrepository.findAll()));
    }
    
	@GetMapping("/{id}")
    public ResponseEntity<EntityModel<TicketType>> one(@PathVariable Long id) {
        return ttrepository.findById(id).map(ttAssembler::toModel).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
	
	@PostMapping
	TicketType ticketType(@RequestBody TicketType ticketType) {
        return ttrepository.save(ticketType);
    }
	
	@PatchMapping("/{id}")
	TicketType editTicketType(@RequestBody TicketType newTicketType, @PathVariable Long id) {
		TicketType ticketType = ttrepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Invalid ID: " + id));
        if(newTicketType.getName() != "") { ticketType.setName(newTicketType.getName()); }
        ttrepository.save(ticketType);
        return ticketType;
    }

}
