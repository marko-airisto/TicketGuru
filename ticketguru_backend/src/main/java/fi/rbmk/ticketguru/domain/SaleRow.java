package fi.rbmk.ticketguru.domain;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import org.hibernate.validator.constraints.Length;

@Entity
public class SaleRow {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "saleRow_ID")
	private Long id;
	
	@NotEmpty(message = "Sale event is required")
	@Column(name = "saleEvent_ID")
	private SaleEvent saleEvent;
	
	
	@Column(name = "Discount")
	private Long discount; // Pitäisikö olla % vai alennus euroina vai...? Varmaan % olisi paras -Mika

	@OneToMany(cascade= CascadeType.ALL, mappedBy = "saleEvent_ID")
	private List<SaleEvent> saleEvents;
	
	// Miten tehdään OneToOne liittymä (Yksi SaleRow vastaa yhtä Tickets -taulun riviä)
	// OneToOne liittymä voidaan tehdä vaikka kuten alla -Mika
	@OneToOne
	@JoinColumn(name = "ticket_ID", referencedColumnName = "ticket_ID")
	private Ticket ticket;
	
	public SaleRow() {
		super();
	}
	
	public SaleRow(Long id, SaleEvent saleEvent_ID, Ticket ticket, Long discount) {
		super();
		this.id = id;
		this.saleEvent = saleEvent_ID;
		this.ticket = ticket;
		this.discount = discount;
	}

	// Getterit

	public List<SaleEvent> getSaleEvents() {
		return saleEvents;
	}

	public Long getSaleRow_ID() {
		return id;
	}

	public Long getSaleEvent_ID() {
		return id;
	}

	public Ticket getTicket() {
		return ticket;
	}

	public Long getDiscount() {
		return discount;
	}

	public void setSaleEvents(List<SaleEvent> saleEvents) {
		this.saleEvents = saleEvents;
	}
	
	// Setterit
	
	
	public void setSaleRow_ID(Long saleRow_ID) {
		this.id = saleRow_ID;
	}

	public void setSaleEvent_ID(SaleEvent saleEvent) {
		this.saleEvent = saleEvent;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

	public void setDiscount(Long discount) {
		this.discount = discount;
	}
	
	
	@Override
	public String toString() {
		return "SaleRows [saleRow_ID=" + id + ", saleEvent_ID=" + saleEvent + ", ticket_ID=" + ticket
				+ ", discount=" + discount + ", saleEvents=" + saleEvents + "]";
	}

}

