package fi.rbmk.ticketguru.eventOrganizer;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.stereotype.Component;


@Component
public class EventOrganizerResourceAssembler implements RepresentationModelAssembler<EventOrganizer, EntityModel<EventOrganizer>> {
	@Override
    public EntityModel<EventOrganizer> toModel(EventOrganizer eventOrganizer) {
        return new EntityModel<>(eventOrganizer,
                linkTo(methodOn(EventOrganizerController.class).one(eventOrganizer.getId())).withSelfRel(),
                linkTo(methodOn(EventOrganizerController.class).findAll()).withRel("eventOrganizers"));
    }
}
