package fi.rbmk.ticketguru.domain;


import java.util.List;

@Entity
public class SaleRows {
	
	@Id
	@GeneratedValue(strategy=generationType.AUTO)
	private Long saleRow_ID;
	private Long saleEvent_ID;
	private Long ticket_ID;
	private Long discount; // Pitäisikö olla % vai alennus euroina vai...?

	@ManyToOne(cascade= CascadeType.ALL, mappedBy = "saleEvent_ID")
	private List<SaleEvents> saleEvents;
	
	// Miten tehdään OneToOne liittymä (Yksi SaleRow vastaa yhtä Tickets -taulun riviä)
	
	public SaleRows() {
		super();
	}
	
	public SaleRows(Long saleRow_ID, Long saleEvent_ID, Long ticket_ID, Long discount) {
		super();
		this.saleRow_ID = saleRow_ID;
		this.saleEvent_ID = saleEvent_ID;
		this.ticket_ID = ticket_ID;
		this.discount = discount;
	}

	public Long getSaleRow_ID() {
		return saleRow_ID;
	}

	public void setSaleRow_ID(Long saleRow_ID) {
		this.saleRow_ID = saleRow_ID;
	}

	public Long getSaleEvent_ID() {
		return saleEvent_ID;
	}

	public void setSaleEvent_ID(Long saleEvent_ID) {
		this.saleEvent_ID = saleEvent_ID;
	}

	public Long getTicket_ID() {
		return ticket_ID;
	}

	public void setTicket_ID(Long ticket_ID) {
		this.ticket_ID = ticket_ID;
	}

	public Long getDiscount() {
		return discount;
	}

	public void setDiscount(Long discount) {
		this.discount = discount;
	}

	public List<SaleEvents> getSaleEvents() {
		return saleEvents;
	}

	public void setSaleEvents(List<SaleEvents> saleEvents) {
		this.saleEvents = saleEvents;
	}

	@Override
	public String toString() {
		return "SaleRows [saleRow_ID=" + saleRow_ID + ", saleEvent_ID=" + saleEvent_ID + ", ticket_ID=" + ticket_ID
				+ ", discount=" + discount + ", saleEvents=" + saleEvents + "]";
	}

	
}

