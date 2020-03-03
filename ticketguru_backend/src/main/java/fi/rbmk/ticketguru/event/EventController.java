package fi.rbmk.ticketguru.event;

import fi.rbmk.ticketguru.ageLimit.AgeLimit;
import fi.rbmk.ticketguru.domain.Venue;
import fi.rbmk.ticketguru.eventOrganizer.EventOrganizer;
import fi.rbmk.ticketguru.eventTicket.EventTicket;
import fi.rbmk.ticketguru.eventTicket.EventTicketResourceAssembler;
import fi.rbmk.ticketguru.eventType.EventType;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.ResponseEntity;

import java.net.URISyntaxException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(value = "/api/events", produces = "application/hal+json")
class EventController {

    @Autowired
    private EventRepository eRepository;
    @Autowired
    private EventModelAssembler eAssembler;
    @Autowired
    private EventTicketResourceAssembler eTicketAssembler;
    // @Autowired private AgeLimitResourceAssembler aLimitAssembler;

    //Get all Events
    @GetMapping
    CollectionModel<EventModel> getAll() {
        List<EventModel> events = eRepository.findAll().stream().map(eAssembler::toModel)
                .collect(Collectors.toList());
        return new CollectionModel<>(events, linkTo(methodOn(EventController.class).getAll()).withSelfRel());
    }

    // Get single Event
    @GetMapping("/{id}")
    EventModel getEvent(@PathVariable Long id) {
        Event event = eRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Invalid ID: " + id));
        return eAssembler.toModel(event);
    }

    // Get Event age limit
    // @GetMapping("/{id}/ageLimit")
    // EntityModel<AgeLimit> getAgeLimit(@PathVariable Long id) {
    // Event event = eRepository.findById(id)
    // .orElseThrow(() -> new ResourceNotFoundException("Invalid ID: " + id));
    // return aLimitAssembler.toModel(event.getAgeLimit());
    // }

    // Get Event tickets
    @GetMapping("/{id}/eventTickets")
    CollectionModel<EntityModel<EventTicket>> getEventTickets(@PathVariable Long id) {
        Event event = eRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Invalid ID: " + id));
        List<EntityModel<EventTicket>> eventTickets = event.getEventTickets().stream().map(eTicketAssembler::toModel)
                .collect(Collectors.toList());
        return new CollectionModel<>(eventTickets,
                linkTo(methodOn(EventController.class).getEventTickets(id)).withSelfRel());
    }

    // Create event
    @PostMapping(consumes = "application/hal+json")
    ResponseEntity<?> setEvent(@Valid @RequestBody EventModel eventModel) throws URISyntaxException {
        //eRepository.save(eventModel);
        //EventModel eventModel = eAssembler.toModel(eRepository.save(event));
        return ResponseEntity.ok().body(eventModel);
    }

    // Edit event
    @PatchMapping("/{id}")
    ResponseEntity<?> editEvent(@Valid @RequestBody Event newEvent, @PathVariable Long id) throws URISyntaxException {
        Event updatedEvent = eRepository.findById(id).map(event -> {
            if (newEvent.getName() != "") {
                event.setName(newEvent.getName());
            }
            if (newEvent.getEventType() != null) {
                event.setEventType(newEvent.getEventType());
            }
            if (newEvent.getDateTime() != null) {
                event.setDateTime(newEvent.getDateTime());
            }
            if (newEvent.getEventOrganizer() != null) {
                event.setEventOrganizer(newEvent.getEventOrganizer());
            }
            if (newEvent.getVenue() != null) {
                event.setVenue(newEvent.getVenue());
            }
            if (newEvent.getTicketCapacity() != null) {
                event.setTicketCapacity(newEvent.getTicketCapacity());
            }
            if (newEvent.getAgeLimit() != null) {
                event.setAgeLimit(newEvent.getAgeLimit());
            }
            if (newEvent.getInfo() != null) {
                event.setInfo(newEvent.getInfo());
            }
            return eRepository.save(event);
        }).orElseGet(() -> {
            return eRepository.save(newEvent);
        });
        EventModel eventModel = eAssembler.toModel(updatedEvent);
        return ResponseEntity.created(eventModel.getRequiredLink(IanaLinkRelations.SELF).toUri()).body(eventModel);
    }

    // Delete event
    @DeleteMapping("/{id}")
    ResponseEntity<?> deleteEvent(@PathVariable Long id) {
        eRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Invalid ID: " + id));
        eRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}