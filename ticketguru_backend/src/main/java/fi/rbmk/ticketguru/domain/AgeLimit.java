package fi.rbmk.ticketguru.domain;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class AgeLimit {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	private String ageLimitName, ageLimitSpecifier;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "ageLimit")
	private List<Event> events;
	
	public AgeLimit() {
		super();
	}
	
	public Long getAgeLimit_ID() {
		return id;
	}

	public void setAgeLimit_ID(Long ageLimit_ID) {
		this.id = ageLimit_ID;
	}

	public String getAgeLimitName() {
		return ageLimitName;
	}

	public void setAgeLimitName(String ageLimitName) {
		this.ageLimitName = ageLimitName;
	}

	public String getAgeLimitSpecifier() {
		return ageLimitSpecifier;
	}

	public void setAgeLimitSpecifier(String ageLimitSpecifier) {
		this.ageLimitSpecifier = ageLimitSpecifier;
	}

	public List<Event> getEvents() {
		return events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}

	@Override
	public String toString() {
		return "AgeLimit [ageLimit_ID=" + id + ", ageLimitName=" + ageLimitName + ", ageLimitSpecifier="
				+ ageLimitSpecifier + ", events=" + events + "]";
	}

	public AgeLimit(Long ageLimit_ID, String ageLimitName, String ageLimitSpecifier, List<Event> events) {
		super();
		this.id = ageLimit_ID;
		this.ageLimitName = ageLimitName;
		this.ageLimitSpecifier = ageLimitSpecifier;
		this.events = events;
	}
	
}