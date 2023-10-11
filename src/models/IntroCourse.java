package src.models;

import java.util.Date;
import java.util.List;

public class IntroCourse extends Event{

    private List<GuestUser> guestAttendees;

    public IntroCourse(String eventName, int eventID, List<User> attendees, Date startDate, Date endDate, List<GuestUser> guestAttendees) {
        super(eventName, eventID, attendees, startDate, endDate);
        this.guestAttendees = guestAttendees;
    }

    public void addIntroCourseRegistration (GuestUser guestUser) {
       this.guestAttendees.add(guestUser);
    }

    public void removeIntroCourseRegistration(GuestUser guestUser) {
        this.guestAttendees.remove(guestUser);
    }
}