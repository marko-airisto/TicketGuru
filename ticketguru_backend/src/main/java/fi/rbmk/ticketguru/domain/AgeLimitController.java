package fi.rbmk.ticketguru.domain;

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


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(value = "/api/ageLimits", produces = "application/hal+json")
class AgeLimitController {
	
	@Autowired
	private AgeLimitRepository alrepository;
	
	@GetMapping
	public List<AgeLimit> ageLimitListRest() {
		return (List<AgeLimit>) alrepository.findAll();
    }
    
    // Get single AgeLimit
    @GetMapping("/{id}")
    AgeLimit getAgeLimit(@PathVariable Long id) {
        AgeLimit ageLimit = alrepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Invalid ID: " + id));
        return ageLimit;
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
