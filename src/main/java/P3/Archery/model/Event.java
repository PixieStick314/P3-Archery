package P3.Archery.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.*;
import java.util.ArrayList;
import java.util.List;

//TODO: Make all fields private
@Document(collection = "events")
public class Event{
    //  Attributes
    public String eventName;
    public User eventCreator;

    @Id
    public String eventID;
    public List<User> attendees = new ArrayList<>();
	public ZonedDateTime startTime;
	public ZonedDateTime endTime;
    public String location;

    private EventType eventType;

    public enum EventType {
        INTRO,
        TRAINING,
        COMPETITION,
        OTHER
    }

    public Event(String eventName, User eventCreator, ZonedDateTime startTime, ZonedDateTime endTime, String location, EventType eventType) {
        this.eventName = eventName;
        this.eventCreator = eventCreator;
        this.attendees.add(eventCreator);
        this.startTime = startTime;
        this.endTime = endTime;
        this.location = location;
        this.eventType = eventType;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public User getEventCreator() {
        return eventCreator;
    }

    public void setEventCreator(User eventCreator) {
        this.eventCreator = eventCreator;
    }

    public String getEventID() {
        return eventID;
    }

    public void setEventID(String eventID) {
        this.eventID = eventID;
    }

    public void setAttendees(List<User> attendees) {
        this.attendees = attendees;
    }

    public ZonedDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(ZonedDateTime startTime) {
        this.startTime = startTime;
    }

    public ZonedDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(ZonedDateTime endTime) {
        this.endTime = endTime;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public EventType getEventType() {
        return eventType;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }

    public void addAttendee(User user){
        this.attendees.add(user);
    }

    public void removeAttendee(User user){
        this.attendees.remove(user);
    }

    public List<User> getAttendees() {
        return attendees;
    }

    public int getAttendeeCount() {
        return attendees.size();
    }
    
}