package src.event;
/*Competition (Subclass of event)
    Attributes:
    	Inherited from event
    Methods:
    	registrationForm(),
		exportRegistrations()
*/

import src.user.User;

import java.time.ZonedDateTime;
import java.util.List;

public class Competition extends Event{

    public Competition(String eventName, int eventID, List<User > attendees, ZonedDateTime startTime, ZonedDateTime endTime) {
        super(eventName, eventID, attendees, startTime, endTime);
    }

    public void registrationForm(User user) {
        //TBD
    }

    public String exportRegistration() {
        String fileName = "Placeholder";
        return fileName;
    }

}