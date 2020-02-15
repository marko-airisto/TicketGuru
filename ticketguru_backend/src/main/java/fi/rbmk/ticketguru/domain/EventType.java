package fi.rbmk.ticketguru.domain;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class EventType {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String eventTypeName, eventTypeInfo;
	
	
	@OneToMany(cascade= CascadeType.ALL, mappedBy = "id")
	private List<Event> events;
	
	public EventType() {
		super();
	}
	
	public Long getEventType_ID() {
		return id;
	}

	public void setEventType_ID(Long eventType_ID) {
		this.id = eventType_ID;
	}
	
	
	public String getEventTypeName() {
		return eventTypeName;
	}

	public void setEventTypeName(String eventTypeName) {
		this.eventTypeName = eventTypeName;
	}
	
	public String getEventTypeInfo() {
		return eventTypeInfo;
	}

	public void setEventTypeInfo(String eventTypeInfo) {
		this.eventTypeInfo = eventTypeInfo;
	}
	
		
	
	@Override
	public String toString() {
		return "EventTypes[eventType_ID=" + id + ", eventTypeName=" + eventTypeName + ", eventTypeInfo=" + eventTypeInfo + "]";
	}

	public EventType(Long eventType_ID, String eventTypeName, String eventTypeInfo, List<Event> events) {
		super();
		this.id = eventType_ID;
		
		this.eventTypeName = eventTypeName;
		this.eventTypeInfo = eventTypeInfo;
		
		this.events = events;
	}
	
}