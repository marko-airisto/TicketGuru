package fi.rbmk.ticketguru.domain;

import java.util.List;

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
@Table(name = "TicketStatus")
public class TicketStatus {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ticketStatus_ID")
	private Long id;

	@NotEmpty(message = "Ticket status is required")
	@Length(max = 50)
	@Column(name = "name")
	private String name;
	
	@OneToMany(mappedBy = "ticketStatus")
	private List<Ticket> tickets;

	public TicketStatus() {
	}

	public TicketStatus(TicketStatus ticketStatus) {
	}

	public TicketStatus(String name) {
		this.name = name;
	}

	public Long getId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Ticket> getTickets() {
		return tickets;
	}

	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}

}