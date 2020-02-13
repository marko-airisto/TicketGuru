package fi.rbmk.ticketguru.domain;


import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class SaleRow {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long saleRow_ID;
	private Long saleEvent_ID;
	private Long ticket_ID;
	private Long discount; // Pitäisikö olla % vai alennus euroina vai...?

	@OneToMany(cascade= CascadeType.ALL, mappedBy = "saleEvent_ID")
	private List<SaleEvent> saleEvents;
	
	// Miten tehdään OneToOne liittymä (Yksi SaleRow vastaa yhtä Tickets -taulun riviä)
	
	public SaleRow() {
		super();
	}
	
	public SaleRow(Long saleRow_ID, Long saleEvent_ID, Long ticket_ID, Long discount) {
		super();
		this.saleRow_ID = saleRow_ID;
		this.saleEvent_ID = saleEvent_ID;
		this.ticket_ID = ticket_ID;
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

	public Long getTicket_ID() {
		return ticket_ID;
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

	public void setTicket_ID(Long ticket_ID) {
		this.ticket_ID = ticket_ID;
	}

	public void setDiscount(Long discount) {
		this.discount = discount;
	}
	
	
	@Override
	public String toString() {
		return "SaleRows [saleRow_ID=" + saleRow_ID + ", saleEvent_ID=" + saleEvent_ID + ", ticket_ID=" + ticket_ID
				+ ", discount=" + discount + ", saleEvents=" + saleEvents + "]";
	}

}

