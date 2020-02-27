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
	private String e_o_name, e_o_streetAddress, e_o_Tel, e_o_email, e_o_www, e_o_contactPerson;
	private Long e_o_postcode_ID;
	
	@NotEmpty(message = "Organizers name is required")
	@Length(max= 100)
	@Column(name = "name")
	private String name;
	
	@NotEmpty(message = "Postcode is required")
	@Column(name = "postcode_ID")
	private Long postcode;
	
	
	
	@OneToMany(cascade= CascadeType.ALL, mappedBy = "eventOrganizers")
	private List<Event> event_orgs;
	
	public EventOrganizer() {
	}

	public EventOrganizer(EventOrganizer eventOrganizer) {
	}
	
	public Long getId() {
		return id;
	}

	public String getE_o_name() {
		return e_o_name;
	}

	public String getE_o_streetAddress() {
		return e_o_streetAddress;
	}

	public String getE_o_Tel() {
		return e_o_Tel;
	}

	public String getE_o_email() {
		return e_o_email;
	}

	public String getE_o_www() {
		return e_o_www;
	}

	public String getE_o_contactPerson() {
		return e_o_contactPerson;
	}

	public Long getE_o_postcode_ID() {
		return e_o_postcode_ID;
	}

	
	public List<Event> getEvent_orgs() {
		return event_orgs;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setE_o_name(String e_o_name) {
		this.e_o_name = e_o_name;
	}

	public void setE_o_streetAddress(String e_o_streetAddress) {
		this.e_o_streetAddress = e_o_streetAddress;
	}

	public void setE_o_Tel(String e_o_Tel) {
		this.e_o_Tel = e_o_Tel;
	}

	public void setE_o_email(String e_o_email) {
		this.e_o_email = e_o_email;
	}

	public void setE_o_www(String e_o_www) {
		this.e_o_www = e_o_www;
	}

	public void setE_o_contactPerson(String e_o_contactPerson) {
		this.e_o_contactPerson = e_o_contactPerson;
	}

	public void setE_o_postcode_ID(Long e_o_postcode_ID) {
		this.e_o_postcode_ID = e_o_postcode_ID;
	}

	
	public void setEvent_orgs(List<Event> event_orgs) {
		this.event_orgs = event_orgs;
	}

	
}