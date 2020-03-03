package fi.rbmk.ticketguru.ticketStatus;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.stereotype.Component;

@Component
public class TicketStatusResourceAssembler implements RepresentationModelAssembler<TicketStatus, EntityModel<TicketStatus>> {
	
	@Override
	public EntityModel<TicketStatus> toModel(TicketStatus ticketStatus) {
        return new EntityModel<>(ticketStatus,
                linkTo(methodOn(TicketStatusController.class).one(ticketStatus.getId())).withSelfRel(),
                linkTo(methodOn(TicketStatusController.class).findAll()).withRel("ticketStatuses"));
    }

}
