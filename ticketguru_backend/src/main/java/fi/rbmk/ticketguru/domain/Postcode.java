package fi.rbmk.ticketguru.domain;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Postcode {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String city;
	private String country;
	
	@OneToMany(cascade= CascadeType.ALL, mappedBy = "postcode_ID")
	private List<Venue> venue;
	
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
		return venue;
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

	public void setVenues(List<Venue> venue) {
		this.venue = venue;
	}

	@Override
	public String toString() {
		return "PostCodes [id=" + id + ", city=" + city + ", country=" + country + "]";
	}
	
}
