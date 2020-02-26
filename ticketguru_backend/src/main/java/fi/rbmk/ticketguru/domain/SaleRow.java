package fi.rbmk.ticketguru.domain;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "SaleRows")
public class SaleRow {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long saleRow_ID;
	private Long saleEvent_ID;
	// private Long ticket_ID;
	private Long discount; // Pitäisikö olla % vai alennus euroina vai...? Varmaan % olisi paras -Mika

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "saleEvent_ID")
	private List<SaleEvent> saleEvents;

	// Miten tehdään OneToOne liittymä (Yksi SaleRow vastaa yhtä Tickets -taulun
	// riviä)
	// OneToOne liittymä voidaan tehdä vaikka kuten alla -Mika
	@OneToOne
	@JoinColumn(name = "ticket_ID", referencedColumnName = "ticket_ID")
	private Ticket ticket;

	public SaleRow() {
		super();
	}

	public SaleRow(Long saleRow_ID, Long saleEvent_ID, Ticket ticket, Long discount) {
		super();
		this.saleRow_ID = saleRow_ID;
		this.saleEvent_ID = saleEvent_ID;
		this.ticket = ticket;
		this.discount = discount;
	}

	// Getterit

	public List<SaleEvent> getSaleEvents() {
		return saleEvents;
	}

	public Long getSaleRow_ID() {
		return saleRow_ID;
	}

	public Long getSaleEvent_ID() {
		return saleEvent_ID;
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
		this.saleRow_ID = saleRow_ID;
	}

	public void setSaleEvent_ID(Long saleEvent_ID) {
		this.saleEvent_ID = saleEvent_ID;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

	public void setDiscount(Long discount) {
		this.discount = discount;
	}

	@Override
	public String toString() {
		return "SaleRows [saleRow_ID=" + saleRow_ID + ", saleEvent_ID=" + saleEvent_ID + ", ticket_ID=" + ticket
				+ ", discount=" + discount + ", saleEvents=" + saleEvents + "]";
	}

}
