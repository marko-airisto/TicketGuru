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
public class EventTypes {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "eventType_ID")
	private Long id;
	private String eventTypeName, eventTypeInfo;
	
	
	@NotEmpty(message = "Event type name is required")
	@Length(max= 100)
	@Column(name = "typename")
	private String typename;
	
	@NotEmpty(message = "Event info is required")
	@Length(max= 500)
	@Column(name = "typeinfo")
	private String typeinfo;
	
	
	
	@OneToMany(cascade= CascadeType.ALL, mappedBy = "typeid")
	private List<Event> events;
	
	public EventTypes() {
	}
	
	public EventTypes(EventTypes eventTypes) {
	}

	public Long getId() {
		return id;
	}

	public String getEventTypeName() {
		return eventTypeName;
	}

	public String getEventTypeInfo() {
		return eventTypeInfo;
	}

	public String getTypename() {
		return typename;
	}

	public String getTypeinfo() {
		return typeinfo;
	}

	public List<Event> getEvents() {
		return events;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setEventTypeName(String eventTypeName) {
		this.eventTypeName = eventTypeName;
	}

	public void setEventTypeInfo(String eventTypeInfo) {
		this.eventTypeInfo = eventTypeInfo;
	}

	public void setTypename(String typename) {
		this.typename = typename;
	}

	public void setTypeinfo(String typeinfo) {
		this.typeinfo = typeinfo;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}
	
	
	
		
	
	
	
}