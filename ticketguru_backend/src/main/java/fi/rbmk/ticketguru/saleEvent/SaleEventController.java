package fi.rbmk.ticketguru.saleEvent;
import java.net.URISyntaxException;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(value = "/api/saleEvents", produces = "application/hal+json")
public class SaleEventController {
	
	// Injektoidaan repo & Assembler
		@Autowired
	    private SaleEventRepository saleEventRepository;
		@Autowired
	    private SaleEventResourceAssembler saleEventAssembler;
		
		// Get all saleEvents
		@GetMapping()
	    public ResponseEntity<CollectionModel<EntityModel<SaleEvent>>> findAll() {
	        return ResponseEntity.ok(saleEventAssembler.toCollectionModel(saleEventRepository.findAll()));
	    }
		
		// Get single saleEvent
	    @GetMapping("/{id}")
	    EntityModel<SaleEvent> getSaleEvent(@PathVariable Long id) {
	    	SaleEvent saleEvent = saleEventRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Invalid ID: " + id));
	        return saleEventAssembler.toModel(saleEvent);
	    }
	    
	    // Create saleEvent
	    @PostMapping
	    ResponseEntity<?> setSaleEvent(@Valid @RequestBody SaleEvent saleEvent) throws URISyntaxException {
	        EntityModel<SaleEvent> entityModel = saleEventAssembler.toModel(saleEventRepository.save(saleEvent));
	        return ResponseEntity.created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()).body(entityModel);
	    }
	    
	 // Delete saleEvent
	    @DeleteMapping("/{id}")
	    ResponseEntity<?> deleteSaleEvent(@PathVariable Long id) {
	    	saleEventRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Invalid ID: " + id));
	    	saleEventRepository.deleteById(id);
	        return ResponseEntity.noContent().build();
	    }

}
