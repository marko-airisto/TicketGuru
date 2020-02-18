package fi.rbmk.ticketguru.domain;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
@Table(name="TicketTypes")
public class TicketType {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "ticketType_ID")
	private Long id;
	private String ticketTypeName;
	
	@OneToMany(cascade= CascadeType.ALL, mappedBy = "ticketType_ID")
	private List<EventTicket> eventTickets;
	
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

	public List<EventTicket> getEventTickets() {
		return eventTickets;
	}

	public void setEventTickets(List<EventTicket> eventTickets) {
		this.eventTickets = eventTickets;
	}

	@Override
	public String toString() {
		return "TicketType [ticketType_ID=" + ticketType_ID + ", ticketTypeName=" + ticketTypeName + "]";
	}

	public TicketType(Long ticketType_ID, String ticketTypeName, List<EventTicket> eventTickets) {
		super();
		this.ticketType_ID = ticketType_ID;
		this.ticketTypeName = ticketTypeName;
		this.eventTickets = eventTickets;
	}
	
}