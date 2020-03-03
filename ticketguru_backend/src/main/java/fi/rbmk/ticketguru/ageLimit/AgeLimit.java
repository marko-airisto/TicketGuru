package fi.rbmk.ticketguru.ageLimit;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.hibernate.validator.constraints.Length;

import fi.rbmk.ticketguru.event.Event;

@Entity
@Table(name = "AgeLimits")
public class AgeLimit {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ageLimit_ID")
	private Long id;

	@NotEmpty(message = "Age limit must be set")
	@Length(max = 50)
	@Column(name = "name")
	private String name;

	@Length(max = 500)
	@Column(name = "specifier")
	private String specifier;
	
	@JsonIgnore
	@OneToMany(mappedBy = "ageLimit")
	private List<Event> events;

	public AgeLimit() {
	}

	public AgeLimit(AgeLimit ageLimit) {
	}
	
	public AgeLimit(String name) {
		this.name = name;
	}

	public AgeLimit(String name, String specifier) {
		this.name = name;
		this.specifier = specifier;
	}
	
	//Getters

	public Long getId() {
		return this.id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getSpecifier() {
		return this.specifier;
	}
	
	public List<Event> getEvents() {
		return events;
	}
	
	//Setters
	
	public void setName(String name) {
		this.name = name;
	}

	public void setSpecifier(String specifier) {
		this.specifier = specifier;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}

}