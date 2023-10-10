package src.event;
/*IntroCourse (Subclass of event)
	Attributes:
		Inherited from event		
	Methods:
    	addIntroCourseRegistration (User),
		removeIntroCourseRegistration (User)
*/

import src.user.User;

import java.util.Date;
import java.util.List;

public class IntroCourse extends Event{

    public IntroCourse(String eventName, int eventID, List<User> attendees, Date startDate, Date endDate) {
        super(eventName, eventID, attendees, startDate, endDate);
    }
}