package src.event;

import src.user.User;
import java.time.*;
import java.util.List;

public class Event{
    //  Attributes
    public String eventName;
    public int eventID;
    public List<User> attendees;
	public ZonedDateTime startTime;
	public ZonedDateTime endTime;

    //  Constructor
    public Event(String eventName, int eventID, List<User> attendees, ZonedDateTime startTime, ZonedDateTime endTime) {
        this.eventName = eventName;
        this.eventID = eventID;
        this.attendees = attendees;
        this.startTime = startTime;
        this.endTime = endTime;
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
    
}