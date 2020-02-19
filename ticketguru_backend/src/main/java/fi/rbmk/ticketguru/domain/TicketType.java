package fi.rbmk.ticketguru.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Length;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
@Table(name="TicketTypes")
public class TicketType {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "ticketType_ID")
	private Long id;
	
	@NotEmpty(message = "Ticket type is required")
	@Length(max = 100)
	@Column(name = "name")
	private String name;
	
	public TicketType() {}
	
	public TicketType(TicketType ticketType) {}
	
	public TicketType(String name) {
		this.name = name;
	}

	public Long getId() { return this.id; }
	public String getName() { return this.name; }

	public void setName(String name) { this.name = name; }

}