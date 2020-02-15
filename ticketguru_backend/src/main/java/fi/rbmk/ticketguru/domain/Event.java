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
    @Column(name = "event_ID")
    private Long id;

    @NotEmpty(message = "Event name is required")
    @Length(max = 250)
    @Column(name = "name")
    private String name;

    @NotEmpty(message = "Event type is required")
    @ManyToOne
    @JoinColumn(name = "eventType_ID")
    private EventType eventType;

    @NotEmpty(message = "Event datetime is required")
    @Column(name = "dateTime")
    private LocalDateTime dateTime;

    @NotEmpty(message = "Event organizer is required")
    @ManyToOne
    @JoinColumn(name = "eventOrganizer_ID")
    private EventOrganizer eventOrganizer;

    @NotEmpty(message = "Event venue is required")
    @ManyToOne
    @JoinColumn(name = "venue_ID")
    private Venue venue;

    @NotEmpty(message = "Event ticket capacity is required")
    @Column(name = "ticketCapacity")
    private Long ticketCapacity;

    @NotEmpty(message = "Age limit must be set")
    @ManyToOne
    @JoinColumn(name = "ageLimit_ID")
    private AgeLimit ageLimit; 

    @Length(max = 500)
    @Column(name = "info")
    private String info;

    public Event() {}
    
    public Event(Event event) {}

    public Event(String name, EventType eventType, LocalDateTime eventDateTime, EventOrganizer eventOrganizer, Venue venue, Long ticketCapacity, AgeLimit ageLimit) {
        this.name = name;
        this.eventType = eventType;
        this.dateTime = eventDateTime;
        this.eventOrganizer = eventOrganizer;
        this.venue = venue;
        this.ticketCapacity = ticketCapacity;
        this.ageLimit = ageLimit;
    }

    public Event(String name, EventType eventType, LocalDateTime eventDateTime, EventOrganizer eventOrganizer, Venue venue, Long ticketCapacity, AgeLimit ageLimit, String eventInfo) {
        this.name = name;
        this.eventType = eventType;
        this.dateTime = eventDateTime;
        this.eventOrganizer = eventOrganizer;
        this.venue = venue;
        this.ticketCapacity = ticketCapacity;
        this.ageLimit = ageLimit;
        this.info = eventInfo;
    }

    //Getters
    public Long getId() { return this.id; }
    public String getName() { return this.name; }
    public EventType getEventType() { return eventType; }
    public LocalDateTime getDateTime() { return dateTime; }
    public EventOrganizer getEventOrganizer() { return eventOrganizer; }
    public Venue getVenue() { return venue; }
    public Long getTicketCapacity() { return ticketCapacity; }
    public AgeLimit getAgeLimit() { return ageLimit; }
    public String getInfo() { return info; }
    //Setters
    public void setName(String name) { this.name = name; }
    public void setEventType(EventType eventType) { this.eventType = eventType; }
    public void setDateTime(LocalDateTime eventDateTime) { this.dateTime = eventDateTime; }
    public void setEventOrganizer(EventOrganizer eventOrganizer) { this.eventOrganizer = eventOrganizer; }
    public void setVenue(Venue venue) { this.venue = venue; }
    public void setTicketCapacity(Long ticketCapacity) { this.ticketCapacity = ticketCapacity; }
    public void setAgeLimit(AgeLimit ageLimit) { this.ageLimit = ageLimit; }
    public void setInfo(String eventInfo) { this.info = eventInfo;
    }
}