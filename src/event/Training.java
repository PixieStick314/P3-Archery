package src.event;

import src.user.User;
import java.util.Date;
import java.util.List;

public class Training extends Event{

    public List<User> trainers;

    public Training(String eventName, int eventID, List<User> attendees, Date startDate, Date endDate, List<User> trainers) {
        super(eventName, eventID, attendees, startDate, endDate);
        this.trainers = trainers;
    }

    public void addTrainer(User user){
        if(user.accessLevel <= 1) {
            this.trainers.add(user);
        }
        else {
            System.out.println("Error: You do not have permission");
        }
    }
    public void removeTrainer(User user){
        if(user.accessLevel <= 1) {
            this.trainers.remove(user);
        }
        else {
            System.out.println("Error: You do not have permission");
        }
    }

}