package fi.rbmk.ticketguru.postcode;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.stereotype.Component;

@Component
public class PostcodeResourceAssembler implements RepresentationModelAssembler<Postcode, EntityModel<Postcode>> {
	@Override
    public EntityModel<Postcode> toModel(Postcode postcode) {
        return new EntityModel<>(postcode,
        		linkTo(methodOn(PostcodeController.class).one(postcode.getId())).withSelfRel(),
                linkTo(methodOn(PostcodeController.class).findAll()).withRel("postcodes"));
    }
}
