package fi.rbmk.ticketguru.eventType;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(value = "/api/eventtypes", produces = "application/hal+json")
public class EventTypeController {

	@Autowired
    private EventTypeRepository eTRepository;
	@Autowired
    private EventTypeResourceAssembler eTAssembler;

	@GetMapping()
    public ResponseEntity<CollectionModel<EntityModel<EventType>>> findAll() {
        return ResponseEntity.ok(eTAssembler.toCollectionModel(eTRepository.findAll()));
    }
    
	@GetMapping("/{id}")
    public ResponseEntity<EntityModel<EventType>> one(@PathVariable Long id) {
        return eTRepository.findById(id).map(eTAssembler::toModel).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
	
}