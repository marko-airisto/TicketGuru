package fi.rbmk.ticketguru.domain;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class TicketType {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long ticketType_ID;
	private String ticketTypeName;
	
	@OneToMany(cascade= CascadeType.ALL, mappedBy = "ticketType_ID")
	private List<EventTickets> eventTickets;
	
	public TicketType() {
		super();
	}

	public Long getTicketType_ID() {
		return ticketType_ID;
	}

	public void setTicketType_ID(Long ticketType_ID) {
		this.ticketType_ID = ticketType_ID;
	}

	public String getTicketTypeName() {
		return ticketTypeName;
	}

	public void setTicketTypeName(String ticketTypeName) {
		this.ticketTypeName = ticketTypeName;
	}

	public List<EventTickets> getEventTickets() {
		return eventTickets;
	}

	public void setEventTickets(List<EventTickets> eventTickets) {
		this.eventTickets = eventTickets;
	}

	@Override
	public String toString() {
		return "TicketType [ticketType_ID=" + ticketType_ID + ", ticketTypeName=" + ticketTypeName + "]";
	}

	public TicketType(Long ticketType_ID, String ticketTypeName, List<EventTickets> eventTickets) {
		super();
		this.ticketType_ID = ticketType_ID;
		this.ticketTypeName = ticketTypeName;
		this.eventTickets = eventTickets;
	}
	
}