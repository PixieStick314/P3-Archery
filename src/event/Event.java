package src.event;

import src.user.User;
import java.util.Date;
import java.util.List;

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
        //jens loop
    }

    public void removeAttendee(User user){
        //jens loop
    }

    public List<User> getAttendees() {
        return attendees;
    }

    public int getAttendeeCount() {
        return attendees.size();
    }
    //  Getters & Setters
    
}