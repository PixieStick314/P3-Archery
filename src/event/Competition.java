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
    List<CompetitionForm> registrationList;

    public Competition(String eventName, User eventCreator, int eventID, ZonedDateTime startTime, ZonedDateTime endTime, String location) {
        super(eventName, eventCreator, eventID, startTime, endTime, location);
    }

    public void addRegistration(User user, Competition competition, int shootingClass, String face){
        CompetitionForm registration = new CompetitionForm(user, competition, shootingClass, face);
        registrationList.add(registration);
    }

    public String exportRegistration() {
        String fileName = "Placeholder";
        return fileName;
    }

}