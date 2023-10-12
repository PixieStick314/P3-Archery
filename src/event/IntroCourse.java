package src.event;

import src.user.GuestUser;
import src.user.User;
import java.time.ZonedDateTime;
import java.util.List;

public class IntroCourse extends Event{

    private List<GuestUser> guestAttendees;

    public IntroCourse(String eventName, User eventCreator, int eventID, List<User> attendees, ZonedDateTime startTime, ZonedDateTime endTime,
                       String location, List<GuestUser> guestAttendees) {
        super(eventName, eventCreator, eventID, startTime, endTime, location);
        this.guestAttendees = guestAttendees;
    }

    public void addIntroCourseRegistration (GuestUser guestUser) {
       this.guestAttendees.add(guestUser);
    }

    public void removeIntroCourseRegistration(GuestUser guestUser) {
        this.guestAttendees.remove(guestUser);
    }
}