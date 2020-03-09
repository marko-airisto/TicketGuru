package fi.rbmk.ticketguru.saleEvent;

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

import org.springframework.hateoas.ResourceSupport;

import fi.rbmk.ticketguru.saleRow.SaleRow;
import fi.rbmk.ticketguru.user.User;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
@Table(name = "SaleEvents")
public class SaleEvent extends ResourceSupport {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "saleEvent_ID")
	private Long id;

	@NotEmpty(message = "Please enter the date time")
	@Column(name = "dateTime")
	private LocalDateTime dateTime;

	@NotEmpty(message = "Please enter the user ID")
	@ManyToOne
	@JoinColumn(name = "user_ID")
	private User user;

	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "saleEvent")
	private List<SaleRow> saleRows;

	public SaleEvent() {
		super();
	}

	public SaleEvent(Long id, LocalDateTime dateTime, User user) {
		super();
		this.id = id;
		this.dateTime = dateTime;
		this.user = user;
	}

	// Getterit
	public Long getSaleEvent_ID() {
		return this.id;
	}

	public Long getSaleRow_ID() {
		return this.id;
	}

	public LocalDateTime getDateTime() {
		return this.dateTime;
	}

	public User getUser() {
		return this.user;
	}

	public List<SaleRow> getSaleRows() {
		return this.saleRows;
	}

	// Setterit
	public void setSaleEvent_ID(Long saleEvent_ID) {
		this.id = saleEvent_ID;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setSaleRows(List<SaleRow> saleRows) {
		this.saleRows = saleRows;
	}
}
