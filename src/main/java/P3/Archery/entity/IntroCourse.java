package P3.Archery.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

@Document(collection = "events")
public class IntroCourse extends Event{

    private List<GuestUser> guestAttendees;

    public IntroCourse(String eventName, User eventCreator, ZonedDateTime startTime, ZonedDateTime endTime, String location, EventType eventType, List<GuestUser> guestAttendees) {
        super(eventName, eventCreator, startTime, endTime, location, eventType);
        this.guestAttendees = guestAttendees;
    }

    public void addIntroCourseRegistration (GuestUser guestUser) {
       this.guestAttendees.add(guestUser);
    }

    public void removeIntroCourseRegistration(GuestUser guestUser) {
        this.guestAttendees.remove(guestUser);
    }
}