package fi.rbmk.ticketguru.postcode;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Length;

import fi.rbmk.ticketguru.*;
import fi.rbmk.ticketguru.domain.Venue;
import fi.rbmk.ticketguru.eventOrganizer.EventOrganizer;

@Entity
@Table(name = "Postcodes")
public class Postcode {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "postcode_ID")
	private Long id;
	
	@NotEmpty(message = "City name is required")
	@Length(max = 250)
	@Column(name = "city")
	private String city;
	
	@NotEmpty(message = "Country name is required")
	@Length(max = 250)
	@Column(name = "country")
	private String country;

	@OneToMany(mappedBy = "postcode")
	private List<Venue> venues;

	@OneToMany(mappedBy = "postcode")
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
		return "PostCodes [postcode_ID=" + id + ", city=" + city + ", country=" + country + "]";
	}
	
}
