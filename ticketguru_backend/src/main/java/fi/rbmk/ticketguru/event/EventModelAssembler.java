package fi.rbmk.ticketguru.event;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.hateoas.EntityModel;
import org.springframework.stereotype.Component;

import fi.rbmk.ticketguru.eventOrganizer.EventOrganizerController;
import fi.rbmk.ticketguru.eventType.EventTypeController;

@Component
class EventModelAssembler extends RepresentationModelAssemblerSupport <Event, EventModel> {

    public EventModelAssembler() {
        super(EventController.class, EventModel.class);
    }

    @Override
    public EventModel toModel(Event event) {
        EventModel eventModel = createEventModel(event);
        eventModel.add(
            linkTo(methodOn(EventController.class).getEvent(event.getId())).withSelfRel(),
            linkTo(methodOn(EventTypeController.class).one(event.getEventType().getId())).withRel("eventType"),
            linkTo(methodOn(EventOrganizerController.class).one(event.getEventOrganizer().getId())).withRel("eventOrganizer")
            //linkTo(methodOn(VenueController.class).one(event.getVenue().getId())).withRel("venue"),
            //linkTo(methodOn(AgeLimitController.class).one(event.getAgeLimit().getId())).withRel("ageLimit")
        );
        return eventModel;

    }

    private EventModel createEventModel(Event event) {

        EventModel eventModel = new EventModel();
        eventModel.id = event.getId();
        eventModel.name = event.getName();
        eventModel.dateTime = event.getDateTime();
        eventModel.ticketCapacity = event.getTicketCapacity();
        eventModel.info = event.getInfo();

        return eventModel;
    }
}