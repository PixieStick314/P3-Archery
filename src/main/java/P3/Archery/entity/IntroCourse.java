package P3.Archery.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

@Document(collection = "events")
public class IntroCourse extends Event{

    private List<GuestUser> guestAttendees;

    public IntroCourse(Event event, List<GuestUser> guestAttendees) {
        super(event.getEventName(), event.getEventCreator(), event.getStartTime(), event.getEndTime(), event.getLocation(), event.getEventType());
        this.guestAttendees = guestAttendees;
    }

    public void addIntroCourseRegistration (GuestUser guestUser) {
       this.guestAttendees.add(guestUser);
    }

    public void removeIntroCourseRegistration(GuestUser guestUser) {
        this.guestAttendees.remove(guestUser);
    }
}