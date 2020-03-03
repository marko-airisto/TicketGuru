package fi.rbmk.ticketguru.ageLimit;

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
@RequestMapping(value = "/api/agelimits", produces = "application/hal+json")
public class AgeLimitController {
	
	@Autowired
	private AgeLimitRepository alrepository;
	
	@Autowired
	private AgeLimitResourceAssembler alAssembler;
	
	@GetMapping()
    public ResponseEntity<CollectionModel<EntityModel<AgeLimit>>> findAll() {
        return ResponseEntity.ok(alAssembler.toCollectionModel(alrepository.findAll()));
    }
    
	@GetMapping("/{id}")
    public ResponseEntity<EntityModel<AgeLimit>> one(@PathVariable Long id) {
        return alrepository.findById(id).map(alAssembler::toModel).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
	
	@PostMapping
    AgeLimit ageLimit(@RequestBody AgeLimit ageLimit) {
        return alrepository.save(ageLimit);
    }
	
	@PatchMapping("/{id}")
    AgeLimit editAgeLimit(@RequestBody AgeLimit newAgeLimit, @PathVariable Long id) {
        AgeLimit ageLimit = alrepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Invalid ID: " + id));
        if(newAgeLimit.getName() != "") { ageLimit.setName(newAgeLimit.getName()); }
        if(newAgeLimit.getSpecifier() != null) { ageLimit.setSpecifier(newAgeLimit.getSpecifier()); }
        alrepository.save(ageLimit);
        return ageLimit;
    }

}
