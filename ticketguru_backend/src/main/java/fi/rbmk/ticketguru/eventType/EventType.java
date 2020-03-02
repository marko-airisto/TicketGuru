package fi.rbmk.ticketguru.eventType;

import fi.rbmk.ticketguru.event.Event;

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

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "EventType")
public class EventType {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "eventType_ID")
	private Long id;	
	
	@NotEmpty(message = "Event type name is required")
	@Length(max= 100)
	@Column(name = "name")
	private String name;
	
	@NotEmpty(message = "Event info is required")
	@Length(max= 500)
	@Column(name = "info")
	private String info;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "eventType")
	private List<Event> events;
	
	public EventType() {
	}
	
	public EventType(EventType eventType) {
  	}
  
  	public EventType(Long id, String name, String info) {
		super();
		this.id = id;
		this.name = name;
   		this.info = info;
	}
  
	//Getters
	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getInfo() {
		return info;
	}

	public List<Event> getEvents() {
		return events;
	}	
  
	//Setters
  	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}
  
  	public void setInfo(String info) {
		this.info = info;
	}
	
	@Override
	public String toString() {
		return "EventType[id=" + id + ", name=" + name + ", info=" + info + "]";
	}
}