package src.event;
/*Training (Subclass of event)
    Attributes:
		Inherited from event
	Methods:
		addTrainer(User user)
		removeTrainer(User user)
*/

import src.user.User;

import java.util.Date;
import java.util.List;

public class Training extends Event{

    public Training(String eventName, int eventID, List<User> attendees, Date startDate, Date endDate) {
        super(eventName, eventID, attendees, startDate, endDate);
    }
}