package fi.rbmk.ticketguru.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Table(name="Events")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Event_ID")
    private Long id;

    @NotEmpty(message = "Event name is required")
    @Length(max = 100)
    @Column(name = "EventName")
    private String name;

    @NotEmpty(message = "Event type is required")
    @ManyToOne
    @JoinColumn(name = "EventType_ID")
    private EventType eventType;

    @NotEmpty(message = "Event datetime is required")
    @Column(name = "EventDateTime")
    private LocalDateTime eventDateTime;

    @NotEmpty(message = "Event organizer is required")
    @ManyToOne
    @JoinColumn(name = "EventOrganizer_ID")
    private EventOrganizer eventOrganizer;

    @NotEmpty(message = "Event venue is required")
    @ManyToOne
    @JoinColumn(name = "Venue_ID")
    private Venue venue;

    @NotEmpty(message = "Event ticket capacity is required")
    @Column(name = "TicketCapacity")
    private Long ticketCapacity;

    @NotEmpty(message = "Age limit must be set")
    @ManyToOne
    @JoinColumn(name = "AgeLimit_ID")
    private AgeLimit ageLimit; 

    @Length(max = 500)
    @Column(name = "EventInfo")
    private String eventInfo;

    public Event() {}
    
    public Event(Event event) {}

    public Event(String name, EventType eventType, LocalDateTime eventDateTime, EventOrganizer eventOrganizer, Venue venue, Long ticketCapacity, AgeLimit ageLimit) {
        this.name = name;
        this.eventType = eventType;
        this.eventDateTime = eventDateTime;
        this.eventOrganizer = eventOrganizer;
        this.venue = venue;
        this.ticketCapacity = ticketCapacity;
        this.ageLimit = ageLimit;
    }

    public Event(String name, EventType eventType, LocalDateTime eventDateTime, EventOrganizer eventOrganizer, Venue venue, Long ticketCapacity, AgeLimit ageLimit, String eventInfo) {
        this.name = name;
        this.eventType = eventType;
        this.eventDateTime = eventDateTime;
        this.eventOrganizer = eventOrganizer;
        this.venue = venue;
        this.ticketCapacity = ticketCapacity;
        this.ageLimit = ageLimit;
        this.eventInfo = eventInfo;
    }

    //Getters
    public Long getId() {
        return this.id;
    }
    public String getName() {
        return this.name;
    }
    public EventType getEventType() {
        return eventType;
    }
    public LocalDateTime getEventDateTime() {
        return eventDateTime;
    }
    public EventOrganizer getEventOrganizer() {
        return eventOrganizer;
    }
    public Venue getVenue() {
        return venue;
    }
    public Long getTicketCapacity() {
        return ticketCapacity;
    }
    public AgeLimit getAgeLimit() {
        return ageLimit;
    }
    public String getEventInfo() {
        return eventInfo;
    }
    //Setters
    public void setName(String name) {
        this.name = name;
    }
    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }
    public void setEventDateTime(LocalDateTime eventDateTime) {
        this.eventDateTime = eventDateTime;
    }
    public void setEventOrganizer(EventOrganizer eventOrganizer) {
        this.eventOrganizer = eventOrganizer;
    }
    public void setVenue(Venue venue) {
        this.venue = venue;
    }
    public void setTicketCapacity(Long ticketCapacity) {
        this.ticketCapacity = ticketCapacity;
    }
    public void setAgeLimit(AgeLimit ageLimit) {
        this.ageLimit = ageLimit;
    }
    public void setEventInfo(String eventInfo) {
        this.eventInfo = eventInfo;
    }
}