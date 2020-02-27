package fi.rbmk.ticketguru.domain;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;


@Entity
@Table(name = "EventTypes")
public class EventOrganizer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "eventOrganizer_ID")
	private Long id;
	private String name, streetAddress, tel, email, www, contactPerson;
	private Long postcode_ID;
	
	@NotEmpty(message = "Organizers name is required")
	@Length(max= 100)
	@Column(name = "name")
	private String cname;
	
	@NotEmpty(message = "Postcode is required")
	@Column(name = "postcode_ID")
	private Long postcode;
	
	
	
	@OneToMany(cascade= CascadeType.ALL, mappedBy = "eventOrganizers")
	private List<Event> eventOrgs;
	
	public EventOrganizer() {
	}

	public EventOrganizer(EventOrganizer eventOrganizer) {
	}
	
	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getstreetAddress() {
		return streetAddress;
	}

	public String getTel() {
		return tel;
	}

	public String getEmail() {
		return email;
	}

	public String getWww() {
		return www;
	}

	public String getContactPerson() {
		return contactPerson;
	}

	public Long getPostcode_ID() {
		return postcode_ID;
	}

	
	public List<Event> getEventOrgs() {
		return eventOrgs;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setE_o_streetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setWww(String www) {
		this.www = www;
	}

	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}

	public void setPostcode_ID(Long postcode_ID) {
		this.postcode_ID = postcode_ID;
	}

	
	public void setEventOrgs(List<Event> eventOrgs) {
		this.eventOrgs = eventOrgs;
	}

	
}