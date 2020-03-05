package fi.rbmk.ticketguru.postcode;
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
@RequestMapping(value = "/api/postcodes", produces = "application/hal+json")
public class PostcodeController {
	
	// Injektoidaan repo & assembler
	@Autowired
    private PostcodeRepository postcodeRepository;
	@Autowired
    private PostcodeResourceAssembler postcodeAssembler;
	
	
	// Get all postcodes
	@GetMapping()
    public ResponseEntity<CollectionModel<EntityModel<Postcode>>> findAll() {
        return ResponseEntity.ok(postcodeAssembler.toCollectionModel(postcodeRepository.findAll()));
    }
	
	// Get single postcode
    @GetMapping("/{id}")
    EntityModel<Postcode> one(@PathVariable Long id) {
    	Postcode postcode = postcodeRepository.findById(id) .orElseThrow(() -> new ResourceNotFoundException("Invalid ID: " + id));
        return postcodeAssembler.toModel(postcode);
    }
    
    // Create postcode
    @PostMapping
    ResponseEntity<?> setPostcode(@Valid @RequestBody Postcode postcode) throws URISyntaxException {
        EntityModel<Postcode> entityModel = postcodeAssembler.toModel(postcodeRepository.save(postcode));
        return ResponseEntity.created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()).body(entityModel);
    }
    
 // Delete postcode
    @DeleteMapping("/{id}")
    ResponseEntity<?> deletePostcode(@PathVariable Long id) {
    	postcodeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Invalid ID: " + id));
    	postcodeRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
