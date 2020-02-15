package fi.rbmk.ticketguru.domain;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class TicketStatus {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String ticketStatusName;
	
	@OneToMany(cascade= CascadeType.ALL, mappedBy = "id")
	private List<Ticket> tickets;
	
	public TicketStatus() {
		super();
	}

	public Long getTicketStatus_ID() {
		return id;
	}

	public void setTicketStatus_ID(Long ticketStatus_ID) {
		this.id = ticketStatus_ID;
	}

	public String getTicketStatusName() {
		return ticketStatusName;
	}

	public void setTicketStatusName(String ticketStatusName) {
		this.ticketStatusName = ticketStatusName;
	}

	public List<Ticket> getTickets() {
		return tickets;
	}

	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}

	@Override
	public String toString() {
		return "TicketStatus [ticketStatus_ID=" + id + ", ticketStatusName=" + ticketStatusName
				+ ", tickets=" + tickets + "]";
	}

	public TicketStatus(Long ticketStatus_ID, String ticketStatusName, List<Ticket> tickets) {
		super();
		this.id = ticketStatus_ID;
		this.ticketStatusName = ticketStatusName;
		this.tickets = tickets;
	}
	
}