package fi.rbmk.ticketguru.domain;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class EventTickets {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long eventTickets_ID;
	private Long event_ID, ticketType_ID, ticket_Count, price;
	
	@OneToMany(cascade= CascadeType.ALL, mappedBy = "eventTicket_ID")
	private List<Event> events;
	
	public EventTickets() {
		super();
	}
	
	public Long getEventTickets_ID() {
		return eventTickets_ID;
	}

	public void setEventTickets_ID(Long eventTickets_ID) {
		this.eventTickets_ID = eventTickets_ID;
	}

	public Long getEvent_ID() {
		return event_ID;
	}

	public void setEvent_ID(Long event_ID) {
		this.event_ID = event_ID;
	}

	public Long getTicketType_ID() {
		return ticketType_ID;
	}

	public void setTicketType_ID(Long ticketType_ID) {
		this.ticketType_ID = ticketType_ID;
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
		return "EventTickets [eventTickets_ID=" + eventTickets_ID + ", event_ID=" + event_ID + ", ticketType_ID="
				+ ticketType_ID + ", ticket_Count=" + ticket_Count + ", price=" + price + "]";
	}

	public EventTickets(Long eventTickets_ID, Long event_ID, Long ticketType_ID, Long ticketCount, Long price, List<Event> events) {
		super();
		this.eventTickets_ID = eventTickets_ID;
		this.event_ID = event_ID;
		this.ticketType_ID = ticketType_ID;
		this.ticketCount = ticketCount;
		this.price = price;
		this.events = events;
	}
	
}