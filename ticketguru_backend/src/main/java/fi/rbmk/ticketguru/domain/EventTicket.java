package fi.rbmk.ticketguru.domain;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.persistence.JoinColumn;

@Entity
public class EventTicket {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
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
	
	public EventTicket() {
		super();
	}
	
	public Long getID() {
		return id;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public TicketType getTicketType() {
		return ticketType;
	}

	public void setTicketType(TicketType ticketType) {
		this.ticketType = ticketType;
	}

	public Long getTicketCount() {
		return ticketCount;
	}

	public void setTicketCount(Long ticketCount) {
		this.ticketCount = ticketCount;
	}
	
	
	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "EventTickets [eventTickets_ID=" + id + ", event_ID=" + event + ", ticketType_ID="
				+ ticketType + ", ticket_Count=" + ticketCount + ", price=" + price + "]";
	}

	public EventTicket(Long eventTickets_ID, Event event, TicketType ticketType, Long ticketCount, Long price) {
		super();
		this.id = eventTickets_ID;
		this.event = event;
		this.ticketType = ticketType;
		this.ticketCount = ticketCount;
		this.price = price;
	}
	
}