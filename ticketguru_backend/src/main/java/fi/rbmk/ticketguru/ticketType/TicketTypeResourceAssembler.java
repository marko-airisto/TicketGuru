package fi.rbmk.ticketguru.ticketType;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.stereotype.Component;

@Component
public class TicketTypeResourceAssembler implements RepresentationModelAssembler<TicketType, EntityModel<TicketType>> {
	
	@Override
	public EntityModel<TicketType> toModel(TicketType ticketType) {
		return new EntityModel<>(ticketType, 
		linkTo(methodOn(TicketTypeController.class).one(ticketType.getId())).withSelfRel(),
		linkTo(methodOn(TicketTypeController.class).findAll()).withRel("ticketTypes"));

	}

}

