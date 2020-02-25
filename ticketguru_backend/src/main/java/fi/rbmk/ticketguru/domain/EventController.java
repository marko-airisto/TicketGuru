package fi.rbmk.ticketguru.domain;

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

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(value = "/api/events", produces = "application/hal+json")
class EventController {

    @Autowired private EventRepository erepository;

    // Get all Events
    @GetMapping
    List<Event> all() {
        return erepository.findAll();
    }
    // Get single Event
    @GetMapping("/{id}")
    Event one(@PathVariable Long id) {
        return erepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Invalid ID: " + id));
    }
    // Create event
    @PostMapping
    Event event(@RequestBody Event event) {
        return erepository.save(event);
    }
    // Edit event
    @PatchMapping("/{id}")
    Event editEvent(@RequestBody Event newEvent, @PathVariable Long id) {
        Event event = erepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Invalid ID: " + id));
        if(newEvent.getName() != "") { event.setName(newEvent.getName()); }
        if(newEvent.getEventType() != null) { event.setEventType(newEvent.getEventType()); }
        if(newEvent.getDateTime() != null) { event.setDateTime(newEvent.getDateTime()); }
        if(newEvent.getEventOrganizer() != null){ event.setEventOrganizer(newEvent.getEventOrganizer()); }
        if(newEvent.getVenue() != null) { event.setVenue(newEvent.getVenue()); }
        if(newEvent.getTicketCapacity() != null) { event.setTicketCapacity(newEvent.getTicketCapacity()); }
        if(newEvent.getAgeLimit() != null) { event.setAgeLimit(newEvent.getAgeLimit()); }
        if(newEvent.getInfo() != "") { event.setInfo(newEvent.getInfo()); }
        erepository.save(event);
        return event;
    }
    // Delete event
    @DeleteMapping("/{id}")
    void deleteEvent(@PathVariable Long id) {
        erepository.deleteById(id);
    }
}