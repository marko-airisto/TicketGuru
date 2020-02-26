package fi.rbmk.ticketguru.domain;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "eventOrganizers")
public class EventOrganizer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String companyName, companyStreetAddress, companyTel, companyEmail, companyWWW, companyContactPerson;
	private Long postcode_ID;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "eventOrganizer")
	private List<Event> events;

	public EventOrganizer() {
		super();
	}

	public Long getEventOrganizer_ID() {
		return id;
	}

	public void setEventOrganizer_ID(Long eventOrganizer_ID) {
		this.id = eventOrganizer_ID;
	}

	public Long getPostcode_ID() {
		return postcode_ID;
	}

	public void setPostcode_ID(Long postcode_ID) {
		this.postcode_ID = postcode_ID;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyStreetAddress() {
		return companyStreetAddress;
	}

	public void setCompanyStreetAddress(String companyStreetAddress) {
		this.companyStreetAddress = companyStreetAddress;
	}

	public String getCompanyTel() {
		return companyTel;
	}

	public void setCompanyTel(String companyTel) {
		this.companyTel = companyTel;
	}

	public String getCompanyEmail() {
		return companyEmail;
	}

	public void setCompanyEmail(String companyEmail) {
		this.companyEmail = companyEmail;
	}

	public String getCompanyWWW() {
		return companyWWW;
	}

	public void setCompanyWWW(String companyWWW) {
		this.companyWWW = companyWWW;
	}

	public String getCompanyContactPerson() {
		return companyContactPerson;
	}

	public void setCompanyContactPerson(String companyContactPerson) {
		this.companyContactPerson = companyContactPerson;
	}

	@Override
	public String toString() {
		return "EventOrganizers[eventOrganizer_ID=" + id + ", companyName=" + companyName + ", companyStreetAddress="
				+ companyStreetAddress + ", companyTel=" + companyTel + ", companyEmail=" + companyEmail
				+ ", companyWWW=" + companyWWW + ", companyContactPerson=" + companyContactPerson + ", postcode_ID="
				+ postcode_ID + "]";
	}

	public EventOrganizer(Long eventOrganizer_ID, Long postcode_ID, String companyName, String companyStreetAddress,
			String companyTel, String companyEmail, String companyWWW, String companyContactPerson,
			List<Event> events) {
		super();
		this.id = eventOrganizer_ID;
		this.postcode_ID = postcode_ID;
		this.companyName = companyName;
		this.companyStreetAddress = companyStreetAddress;
		this.companyTel = companyTel;
		this.companyEmail = companyEmail;
		this.companyWWW = companyWWW;
		this.companyContactPerson = companyContactPerson;
		this.events = events;
	}

}