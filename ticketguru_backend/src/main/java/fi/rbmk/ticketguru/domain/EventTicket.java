package fi.rbmk.ticketguru.domain;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "EventTickets")
public class EventTicket {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "eventTicket_ID")
	private Long id;
	private Long event_ID, ticketType_ID, ticketCount, price;
	
	@NotEmpty(message = "Event ID is required")
	@Column(name = "event_ID")
	private Long eID;
	
	@NotEmpty(message = "Ticket type ID is required")
	@Column(name = "ticketType_ID")
	private String ttypeID;
	
	
	
	@OneToMany(cascade= CascadeType.ALL, mappedBy = "eventTickets")
	private List<Event> eventTickets;
	
	public EventTicket() {
	}
	
	public EventTicket(EventTicket eventTicket) {
	}

	public Long getId() {
		return id;
	}

	public Long getEvent_ID() {
		return event_ID;
	}

	public Long getTicketType_ID() {
		return ticketType_ID;
	}

	public Long getTicketCount() {
		return ticketCount;
	}

	public Long getPrice() {
		return price;
	}

	public Long geteID() {
		return eID;
	}

	public String getTtypeID() {
		return ttypeID;
	}

	public List<Event> getEventTickets() {
		return eventTickets;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setEvent_ID(Long event_ID) {
		this.event_ID = event_ID;
	}

	public void setTicketType_ID(Long ticketType_ID) {
		this.ticketType_ID = ticketType_ID;
	}

	public void setTicketCount(Long ticketCount) {
		this.ticketCount = ticketCount;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public void seteID(Long eID) {
		this.eID = eID;
	}

	public void setTtypeID(String ttypeID) {
		this.ttypeID = ttypeID;
	}

	public void setEventTickets(List<Event> eventTickets) {
		this.eventTickets = eventTickets;
	}
	
	
	
}