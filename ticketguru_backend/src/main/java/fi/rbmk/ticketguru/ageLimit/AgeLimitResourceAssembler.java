package fi.rbmk.ticketguru.ageLimit;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.stereotype.Component;

@Component
public class AgeLimitResourceAssembler implements RepresentationModelAssembler<AgeLimit, EntityModel<AgeLimit>> {
	
	@Override
	public EntityModel<AgeLimit> toModel(AgeLimit ageLimit) {
		return new EntityModel<>(ageLimit, 
		linkTo(methodOn(AgeLimitController.class).one(ageLimit.getId())).withSelfRel(),
		linkTo(methodOn(AgeLimitController.class).findAll()).withRel("ageLimits"));

	}

}
