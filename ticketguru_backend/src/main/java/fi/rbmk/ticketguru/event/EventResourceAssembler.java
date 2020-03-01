package fi.rbmk.ticketguru.event;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.stereotype.Component;


@Component
class EventResourceAssembler implements RepresentationModelAssembler<Event, EntityModel<Event>> {
    @Override
    public EntityModel<Event> toModel(Event event) {
        return new EntityModel<>(event,
            linkTo(methodOn(EventController.class).getEvent(event.getId())).withSelfRel(),
            linkTo(methodOn(EventController.class).getEventTickets(event.getId())).withRel("eventTickets"),
            //linkTo(methodOn(EventController.class).getAgeLimit(event.getId())).withRel("ageLimit"),
            linkTo(methodOn(EventController.class).getAll()).withRel("events"));
    }
}