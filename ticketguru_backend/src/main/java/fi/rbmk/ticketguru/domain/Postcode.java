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
	
	@OneToMany(cascade= CascadeType.ALL, mappedBy = "id")
	private List<Venue> venue;
	
	public Postcode() {
		super();
	}
	
	public Postcode(Long postcode_ID, String city, String country) {
		super();
		this.id = postcode_ID;
		this.city = city;
		this.country = country;
	}

	// Getterit
	
	public Long getPostcode_ID() {
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
	
	public void setPostcode_ID(Long postcode_ID) {
		this.id = postcode_ID;
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
		return "PostCodes [postcode_ID=" + id + ", city=" + city + ", country=" + country + "]";
	}
	
}
