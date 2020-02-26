package fi.rbmk.ticketguru.domain;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class EventTicket {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private Long event_ID, ticketType_ID, ticketCount, price;
	
	@OneToMany(cascade= CascadeType.ALL, mappedBy = "id")
	private List<Event> events;
	
	public EventTicket() {
		super();
	}
	
	public Long getEventTickets_ID() {
		return id;
	}

	public void setEventTickets_ID(Long eventTickets_ID) {
		this.id = eventTickets_ID;
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
		return "EventTickets [eventTickets_ID=" + id + ", event_ID=" + event_ID + ", ticketType_ID="
				+ ticketType_ID + ", ticket_Count=" + ticketCount + ", price=" + price + "]";
	}

	public EventTicket(Long eventTickets_ID, Long event_ID, Long ticketType_ID, Long ticketCount, Long price, List<Event> events) {
		super();
		this.id = eventTickets_ID;
		this.event_ID = event_ID;
		this.ticketType_ID = ticketType_ID;
		this.ticketCount = ticketCount;
		this.price = price;
		this.events = events;
	}
	
}