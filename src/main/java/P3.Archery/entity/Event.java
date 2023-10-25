package P3.Archery.entity;

import java.time.*;
import java.util.List;

public class Event{
    //  Attributes
    public String eventName;
    public User eventCreator;
    public int eventID;
    public List<User> attendees;
	public ZonedDateTime startTime;
	public ZonedDateTime endTime;
    public String location;

    //  Constructor
    public Event(String eventName, User eventCreator, int eventID, ZonedDateTime startTime, ZonedDateTime endTime, String location) {
        this.eventName = eventName;
        this.eventCreator = eventCreator;
        this.attendees.add(eventCreator);
        this.eventID = eventID;
        this.startTime = startTime;
        this.endTime = endTime;
        this.location = location;
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
    //  Getters & Setters

    public Event repeatEvent(Event event){
        int newID = 0; //ID assignment placeholder
        ZonedDateTime newStartTime = event.startTime.plusDays(7);
        ZonedDateTime newEndTime = event.endTime.plusDays(7);
        src.event.Training newEvent = new src.event.Training(event.eventName, event.eventCreator, newID, newStartTime, newEndTime, event.location);
        return newEvent;
    }
}