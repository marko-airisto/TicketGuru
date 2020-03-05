package fi.rbmk.ticketguru.event;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.stereotype.Component;

import fi.rbmk.ticketguru.eventOrganizer.EventOrganizerController;
import fi.rbmk.ticketguru.eventType.EventTypeController;

@Component
class EventModelAssembler implements RepresentationModelAssembler <Event, EntityModel<Event>> {

    @Override
    public EntityModel<Event> toModel(Event event) {
        return new EntityModel<Event>(event,
            linkTo(methodOn(EventController.class).getEvent(event.getId())).withSelfRel(),
            linkTo(methodOn(EventTypeController.class).one(event.getEventType().getId())).withRel("eventType"),
            linkTo(methodOn(EventOrganizerController.class).one(event.getEventOrganizer().getId())).withRel("eventOrganizer")
            //linkTo(methodOn(VenueController.class).one(event.getVenue().getId())).withRel("venue"),
            //linkTo(methodOn(AgeLimitController.class).one(event.getAgeLimit().getId())).withRel("ageLimit")
        );

    }
}