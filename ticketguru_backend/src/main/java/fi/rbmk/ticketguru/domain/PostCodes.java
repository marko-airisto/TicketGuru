package fi.rbmk.ticketguru.domain;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class PostCodes {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long postcode_ID;
	private String city;
	private String country;
	
	@OneToMany(cascade= CascadeType.ALL, mappedBy = "postcode_ID")
	private List<Venue> venue;
	
	public PostCodes() {
		super();
	}
	
	public PostCodes(Long postcode_ID, String city, String country) {
		super();
		this.postcode_ID = postcode_ID;
		this.city = city;
		this.country = country;
	}

	// Getterit
	
	public Long getPostcode_ID() {
		return postcode_ID;
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
		this.postcode_ID = postcode_ID;
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
		return "PostCodes [postcode_ID=" + postcode_ID + ", city=" + city + ", country=" + country + "]";
	}
	
}
