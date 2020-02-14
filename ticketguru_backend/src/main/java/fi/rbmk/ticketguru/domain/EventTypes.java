package fi.rbmk.ticketguru.domain;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class EventTypes {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long eventType_ID;
	private String eventTypeName, eventTypeInfo;
	
	
	@OneToMany(cascade= CascadeType.ALL, mappedBy = "eventType_ID")
	private List<Event> events;
	
	public EventTypes() {
		super();
	}
	
	public Long getEventType_ID() {
		return eventType_ID;
	}

	public void setEventType_ID(Long eventType_ID) {
		this.eventType_ID = eventType_ID;
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
		return "EventTypes[eventType_ID=" + eventType_ID + ", eventTypeName=" + eventTypeName + ", eventTypeInfo=" + eventTypeInfo + "]";
	}

	public EventTypes(Long eventType_ID, String eventTypeName, String eventTypeInfo, List<Event> events) {
		super();
		this.eventType_ID = eventType_ID;
		
		this.eventTypeName = eventTypeName;
		this.eventTypeInfo = eventTypeInfo;
		
		this.events = events;
	}
	
}