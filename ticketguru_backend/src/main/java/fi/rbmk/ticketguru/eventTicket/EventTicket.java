package fi.rbmk.ticketguru.eventTicket;

import fi.rbmk.ticketguru.domain.Ticket;
import fi.rbmk.ticketguru.domain.TicketType;
import fi.rbmk.ticketguru.event.Event;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.JoinColumn;

@Entity
@Table(name = "EventTickets")
public class EventTicket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "eventTicket_ID")
    private Long id;
    private Long ticketCount, price;

    @NotEmpty(message = "Event must be set")
    @ManyToOne
    @JoinColumn(name = "event_ID")
    private Event event; 

    @NotEmpty(message = "Ticket type must be set")
    @ManyToOne
    @JoinColumn(name = "ticketType_ID")
    private TicketType ticketType; 
    


    @JsonIgnore
    @OneToMany(mappedBy = "eventTicket")
    private List<Ticket> tickets;
    
    
    public EventTicket() {
    super();
    }

    public EventTicket(EventTicket eventTicket) {
    }

    public EventTicket(Event event, TicketType ticketType, Long ticketCount, Long price) {
        this.event = event;
        this.ticketType = ticketType;
        this.ticketCount = ticketCount;
        this.price = price;

        
    }
    
    public EventTicket(Event event, TicketType ticketType) {
        this.event = event;
        this.ticketType = ticketType;
               
    }
    
    // Getters
    public Long getId() {
        return id;
    }

    public Long getTicketCount() {
        return ticketCount;
    }

    public Long getPrice() {
        return price;
    }

    public Event getEvent_ID() {
        return event;
    }

    public TicketType getTicketType() {
        return ticketType;
    }


    
    //Setters
    public void setId(Long id) {
        this.id = id;
    }
    
    public void setTicketCount(Long ticketCount) {
        this.ticketCount = ticketCount;
    }
    public void setPrice(Long price) {
        this.price = price;
    }
    
    public void setEvent(Event event) {
        this.event = event;
    }
    
    public void setTicketType(TicketType ticketType) {
        this.ticketType = ticketType;
    }

//    
}