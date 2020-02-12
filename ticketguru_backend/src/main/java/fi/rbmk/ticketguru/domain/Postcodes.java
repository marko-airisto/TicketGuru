package fi.rbmk.ticketguru.domain;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Postcodes {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long postcode_ID;
	private String city, country;
	
	
	@OneToMany(cascade= CascadeType.ALL, mappedBy = "postcode_ID")
	private List<Event> events;
	
	public Postcodes() {
		super();
	}
	
	public Long getPostcode_ID() {
		return postcode_ID;
	}

	public void setPostcode_ID(Long postcode_ID) {
		this.postcode_ID = postcode_ID;
	}
	
	
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
		
	
	@Override
	public String toString() {
		return "Postcodes[postcode_ID=" + postcode_ID + ", city=" + city + ", country=" + country + "]";
	}

	public Postcodes(Long postcode_ID, String city, String country, List<Event> events) {
		super();
		this.postcode_ID = postcode_ID;
		
		this.city = city;
		this.country = country;
		
		this.events = events;
	}
	
}