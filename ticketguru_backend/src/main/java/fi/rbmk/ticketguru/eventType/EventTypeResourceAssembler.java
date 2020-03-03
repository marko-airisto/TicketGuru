package fi.rbmk.ticketguru.eventType;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.stereotype.Component;


@Component
public class EventTypeResourceAssembler  implements RepresentationModelAssembler<EventType, EntityModel<EventType>>{

	@Override
    public EntityModel<EventType> toModel(EventType eventType) {
        return new EntityModel<>(eventType,
                linkTo(methodOn(EventTypeController.class).one(eventType.getId())).withSelfRel(),
                linkTo(methodOn(EventTypeController.class).findAll()).withRel("eventTypes"));
    }
	
}
