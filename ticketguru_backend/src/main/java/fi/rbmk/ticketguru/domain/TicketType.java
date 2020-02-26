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
@Table(name = "TicketTypes")
public class TicketType {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ticketType_ID")
	private Long id;

	@NotEmpty(message = "Ticket type is required")
	@Length(max = 100)
	@Column(name = "name")
	private String name;
	
	@OneToMany(mappedBy = "ticketType")
	private List<EventTickets> eventTickets;

	public TicketType() {
	}

	public TicketType(TicketType ticketType) {
	}

	public TicketType(String name) {
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

	public List<EventTickets> getEventTickets() {
		return eventTickets;
	}

	public void setEventTickets(List<EventTickets> eventTickets) {
		this.eventTickets = eventTickets;
	}

}