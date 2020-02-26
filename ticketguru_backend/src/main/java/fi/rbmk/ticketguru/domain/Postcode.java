package fi.rbmk.ticketguru.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Postcodes")
public class Postcode {

	@Id
	@Column(name = "postcode_ID")
	private Long id;
	
	private String city;
	private String country;

	@OneToMany(mappedBy = "id")
	private List<Venue> venues;

	@OneToMany(mappedBy = "id")
	private List<EventOrganizer> eventOrganizers;

	public Postcode() {
		super();
	}

	public Postcode(Long id, String city, String country) {
		super();
		this.id = id;
		this.city = city;
		this.country = country;
	}

	// Getterit

	public Long getID() {
		return id;
	}

	public String getCity() {
		return city;
	}

	public String getCountry() {
		return country;
	}

	public List<Venue> getVenues() {
		return venues;
	}

	public List<EventOrganizer> getEventOrganizers() {
		return eventOrganizers;
	}

	// Setterit

	public void setID(Long id) {
		this.id = id;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "PostCodes [id=" + id + ", city=" + city + ", country=" + country + "]";
	}

}
