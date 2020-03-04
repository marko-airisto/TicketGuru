package fi.rbmk.ticketguru.ticketStatus;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.hibernate.validator.constraints.Length;

import fi.rbmk.ticketguru.domain.Ticket;

@Entity
@Table(name = "TicketStatuses")
public class TicketStatus {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ticketStatus_ID")
	private Long id;

	@NotEmpty(message = "Ticket status is required")
	@Length(max = 50)
	@Column(name = "name")
	private String name;
	
	@JsonIgnore
	@OneToMany(mappedBy = "ticketStatus")
	private List<Ticket> tickets;

	public TicketStatus() {
	}

	public TicketStatus(TicketStatus ticketStatus) {
	}

	public TicketStatus(String name) {
		this.name = name;
	}
	
	//Getters

	public Long getId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}
	
	public List<Ticket> getTickets() {
		return tickets;
	}
	
	//Setters

	public void setName(String name) {
		this.name = name;
	}

	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}

}