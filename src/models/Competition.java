package src.models;

import java.util.Date;
import java.util.List;

public class Competition extends Event{

    public Competition(String eventName, int eventID, List<User > attendees, Date startDate, Date endDate) {
        super(eventName, eventID, attendees, startDate, endDate);
    }

    public void registrationForm(User user) {
        //TBD
    }

    public String exportRegistration() {
        String fileName = "Placeholder";
        return fileName;
    }

}