package fi.rbmk.ticketguru.event;

import fi.rbmk.ticketguru.domain.AgeLimit;
import fi.rbmk.ticketguru.domain.Venue;
import fi.rbmk.ticketguru.eventOrganizer.EventOrganizer;
import fi.rbmk.ticketguru.eventTicket.EventTicket;
import fi.rbmk.ticketguru.eventType.EventType;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.hateoas.RepresentationModel;

public class EventModel extends RepresentationModel<EventModel> {

    Long id, ticketCapacity;
    String name, info;
    EventType eventType;
    LocalDateTime dateTime;
    EventOrganizer eventOrganizer;
    Venue venue;
    AgeLimit ageLimit;
    List<EventTicket> eventTickets;

    //Getterit
    public Long getId() { return this.id; }
    public String getName() { return this.name; }
    public EventType getEventType() { return this.eventType; }
    public LocalDateTime getDateTime() { return this.dateTime; }
    public EventOrganizer getEventOrganizer() { return this.eventOrganizer; }
    public Venue getVenue() { return this.venue; }
    public Long getTicketCapacity() { return this.ticketCapacity; }
    public AgeLimit getAgeLimit() { return this.ageLimit; }
    public String getInfo() { return this.info; }
    public List<EventTicket> getEventTickets() { return this.eventTickets; }
    //Setterit
    public void setName(String name) { this.name = name; }
    public void setEventType(EventType eventType) { this.eventType = eventType; }
    public void setDateTime(LocalDateTime dateTime) { this.dateTime = dateTime; }
    public void setEventOrganizer(EventOrganizer eventOrganizer) { this.eventOrganizer = eventOrganizer; }
    public void setVenue(Venue venue) { this.venue = venue; }
    public void setTicketCapacity(Long ticketCapacity) { this.ticketCapacity = ticketCapacity; }
    public void setAgeLimit(AgeLimit ageLimit) { this.ageLimit = ageLimit; }
    public void setInfo(String info) { this.info = info; }
}