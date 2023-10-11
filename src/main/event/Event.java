package src.main.event;

import java.util.Date;
import java.util.List;

import src.main.user.User;

public class Event{
    //  Attributes
    public String eventName;
    public int eventID;
    public List<User> attendees;
	public Date startDate;
	public Date endDate;

    //  Constructor
    public Event(String eventName, int eventID, List<User> attendees, Date startDate, Date endDate) {
        this.eventName = eventName;
        this.eventID = eventID;
        this.attendees = attendees;
        this.startDate = startDate;
        this.endDate = endDate;
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