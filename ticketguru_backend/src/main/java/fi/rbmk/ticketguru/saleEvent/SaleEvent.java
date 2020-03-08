package fi.rbmk.ticketguru.saleEvent;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

import fi.rbmk.ticketguru.saleRow.SaleRow;

import javax.persistence.Id;

import javax.persistence.OneToMany;

@Entity
@Table(name = "SaleEvents")
public class SaleEvent {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "saleEvent_ID")
	private Long id;

	@NotEmpty(message = "Please enter the date time")
	@Column(name = "dateTime")
	private LocalDateTime dateTime;

	@NotEmpty(message = "Please enter the user ID")
	@Column(name = "user_ID")
	private Long user;

	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "saleEvent")
	private List<SaleRow> saleRows;

	public SaleEvent() {
		super();
	}

	public SaleEvent(Long id, LocalDateTime dateTime, Long user) {
		super();
		this.id = id;
		this.dateTime = dateTime;
		this.user = user;
	}

	// Getterit
	public Long getId() {
		return this.id;
	}

	public LocalDateTime getSaleEventDateTime() {
		return this.dateTime;
	}

	public Long getUser_ID() {
		return this.user;
	}

	public List<SaleRow> getSaleRows() {
		return this.saleRows;
	}

	// Setterit
	public void setSaleEvent_ID(Long saleEvent_ID) {
		this.id = saleEvent_ID;
	}

	public void setSaleEventDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

	public void setUser_ID(Long user_ID) {
		this.user = user_ID;
	}

	public void setSaleRows(List<SaleRow> saleRows) {
		this.saleRows = saleRows;
	}

	@Override
	public String toString() {
		return "SaleEvents [saleEvent_ID=" + id + ", saleEventDateTime=" + dateTime + ", user_ID=" + user + "]";
	}

}
