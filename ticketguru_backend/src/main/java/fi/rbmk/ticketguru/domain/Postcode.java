package fi.rbmk.ticketguru.domain;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Length;

@Entity
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
