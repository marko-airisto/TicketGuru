package fi.rbmk.ticketguru.domain;

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

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(value = "/api/events", produces = "application/hal+json")
class EventController {

    @Autowired private EventRepository eRepository;
    @Autowired private EventTicketRepository eTicketRepository;
    @Autowired private EventResourceAssembler eAssembler;
    @Autowired private EventTicketResourceAssembler eTicketAssembler;

    // Get all Events
    @GetMapping
    CollectionModel<EntityModel<Event>> getAll() {
        List<EntityModel<Event>> events = eRepository.findAll().stream()
            .map(eAssembler::toModel)
            .collect(Collectors.toList());
        return new CollectionModel<>(events,
            linkTo(methodOn(EventController.class).getAll()).withSelfRel());
    }
    // Get single Event
    @GetMapping("/{id}")
    EntityModel<Event> getEvent(@PathVariable Long id) {
        Event event = eRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Invalid ID: " + id));
        return eAssembler.toModel(event);
    }
    // Get Event tickets
    @GetMapping("/{id}/eventTickets")
    CollectionModel<EntityModel<EventTicket>> getEventTickets(@PathVariable Long id) {
        Event event = eRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Invalid ID: " + id));
        List<EntityModel<EventTicket>> eventTickets = eTicketRepository.findByEvent(event).stream()
            .map(eTicketAssembler::toModel)
            .collect(Collectors.toList());
        return new CollectionModel<>(eventTickets,
            linkTo(methodOn(EventController.class).getEventTickets(id)).withSelfRel());
    }
    // Create event
    @PostMapping
    Event event(@RequestBody Event event) {
        return eRepository.save(event);
    }
    // Edit event
    @PatchMapping("/{id}")
    Event editEvent(@RequestBody Event newEvent, @PathVariable Long id) {
        Event event = eRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Invalid ID: " + id));
        if(newEvent.getName() != "") { event.setName(newEvent.getName()); }
        if(newEvent.getEventType() != null) { event.setEventType(newEvent.getEventType()); }
        if(newEvent.getDateTime() != null) { event.setDateTime(newEvent.getDateTime()); }
        if(newEvent.getEventOrganizer() != null){ event.setEventOrganizer(newEvent.getEventOrganizer()); }
        if(newEvent.getVenue() != null) { event.setVenue(newEvent.getVenue()); }
        if(newEvent.getTicketCapacity() != null) { event.setTicketCapacity(newEvent.getTicketCapacity()); }
        if(newEvent.getAgeLimit() != null) { event.setAgeLimit(newEvent.getAgeLimit()); }
        if(newEvent.getInfo() != "") { event.setInfo(newEvent.getInfo()); }
        eRepository.save(event);
        return event;
    }
    // Delete event
    @DeleteMapping("/{id}")
    void deleteEvent(@PathVariable Long id) {
        eRepository.deleteById(id);
    }
}