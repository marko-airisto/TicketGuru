package fi.rbmk.ticketguru.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "SaleEvents")
public class SaleEvent {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long saleEvent_ID;
	private Date saleEventDateTime;
	private Long user_ID;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "saleEvent_ID")
	private List<SaleRow> saleRows;

	public SaleEvent() {
		super();
	}

	public SaleEvent(Long saleEvent_ID, Date saleEventDateTime, Long user_ID) {
		super();
		this.saleEvent_ID = saleEvent_ID;
		this.saleEventDateTime = saleEventDateTime;
		this.user_ID = user_ID;
	}

	// Getterit

	public Long getSaleEvent_ID() {
		return saleEvent_ID;
	}

	public Date getSaleEventDateTime() {
		return saleEventDateTime;
	}

	public Long getUser_ID() {
		return user_ID;
	}

	public List<SaleRow> getSaleRows() {
		return saleRows;
	}

	// Setterit

	public void setSaleEvent_ID(Long saleEvent_ID) {
		this.saleEvent_ID = saleEvent_ID;
	}

	public void setSaleEventDateTime(Date saleEventDateTime) {
		this.saleEventDateTime = saleEventDateTime;
	}

	public void setUser_ID(Long user_ID) {
		this.user_ID = user_ID;
	}

	public void setSaleRows(List<SaleRow> saleRows) {
		this.saleRows = saleRows;
	}

	@Override
	public String toString() {
		return "SaleEvents [saleEvent_ID=" + saleEvent_ID + ", saleEventDateTime=" + saleEventDateTime + ", user_ID="
				+ user_ID + "]";
	}

}
