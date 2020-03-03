package fi.rbmk.ticketguru.ticketStatus;

import java.util.List;
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
@RequestMapping(value = "/api/ticketstatuses", produces = "application/hal+json")
public class TicketStatusController {
	
	@Autowired
    private TicketStatusRepository tsrepository;
    
	@Autowired
    private TicketStatusResourceAssembler tsAssembler;
    
	@GetMapping()
    public ResponseEntity<CollectionModel<EntityModel<TicketStatus>>> findAll() {
        return ResponseEntity.ok(tsAssembler.toCollectionModel(tsrepository.findAll()));
    }
    
	@GetMapping("/{id}")
    public ResponseEntity<EntityModel<TicketStatus>> one(@PathVariable Long id) {
        return tsrepository.findById(id).map(tsAssembler::toModel).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
	
	@GetMapping
	public List<TicketStatus> ticketStatusListRest() {
		return (List<TicketStatus>) tsrepository.findAll();
    }
    
    // Get single TicketStatus
    @GetMapping("/{id}")
    TicketStatus getTicketStatus(@PathVariable Long id) {
        TicketStatus ticketStatus = tsrepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Invalid ID: " + id));
        return ticketStatus;
    }
	
	@PostMapping
    TicketStatus ticketStatus(@RequestBody TicketStatus ticketStatus) {
        return tsrepository.save(ticketStatus);
    }
	
	@PatchMapping("/{id}")
    TicketStatus editTicketStatus(@RequestBody TicketStatus newTicketStatus, @PathVariable Long id) {
		TicketStatus ticketStatus = tsrepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Invalid ID: " + id));
        if(newTicketStatus.getName() != "") { ticketStatus.setName(newTicketStatus.getName()); }
        tsrepository.save(ticketStatus);
        return ticketStatus;
    }

}