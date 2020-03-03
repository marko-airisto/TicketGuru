package fi.rbmk.ticketguru.eventOrganizer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(value = "/api/eventorganizers", produces = "application/hal+json")
public class EventOrganizerController {

	@Autowired
    private EventOrganizerRepository eORepository;
	@Autowired
    private EventOrganizerResourceAssembler eOAssembler;

    @GetMapping()
    public ResponseEntity<CollectionModel<EntityModel<EventOrganizer>>> findAll() {
        return ResponseEntity.ok(eOAssembler.toCollectionModel(eORepository.findAll()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<EventOrganizer>> one(@PathVariable Long id) {
        return eORepository.findById(id).map(eOAssembler::toModel).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    
    
    public List<EventOrganizer> evenOrganizersListRest() {
        return (List<EventOrganizer>) eORepository.findAll();
    }
	
}
