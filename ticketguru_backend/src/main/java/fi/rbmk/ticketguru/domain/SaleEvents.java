package fi.rbmk.ticketguru.domain;

import java.util.Date;
import java.util.List;


@Entity
public class SaleEvents {
	
	@Id
	@GeneratedValue(strategy=generationType.AUTO)
	private Long saleEvent_ID;
	private Date saleEventDateTime;
	private Long user_ID;
	
	@OneToMany(cascade= CascadeType.ALL, mappedBy = "saleEvent_ID")
	private List<SaleRows> saleRows;
	
	public SaleEvents() {
		super();
	}
	
	public SaleEvents(Long saleEvent_ID, Date saleEventDateTime, Long user_ID) {
		super();
		this.saleEvent_ID = saleEvent_ID;
		this.saleEventDateTime = saleEventDateTime;
		this.user_ID = user_ID;
	}

	public Long getSaleEvent_ID() {
		return saleEvent_ID;
	}

	public void setSaleEvent_ID(Long saleEvent_ID) {
		this.saleEvent_ID = saleEvent_ID;
	}

	public Date getSaleEventDateTime() {
		return saleEventDateTime;
	}

	public void setSaleEventDateTime(Date saleEventDateTime) {
		this.saleEventDateTime = saleEventDateTime;
	}

	public Long getUser_ID() {
		return user_ID;
	}

	public void setUser_ID(Long user_ID) {
		this.user_ID = user_ID;
	}

	@Override
	public String toString() {
		return "SaleEvents [saleEvent_ID=" + saleEvent_ID + ", saleEventDateTime=" + saleEventDateTime + ", user_ID="
				+ user_ID + "]";
	}
	
}
