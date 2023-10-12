package src.event;

import src.user.User;
import java.time.ZonedDateTime;
import java.util.List;

public class Training extends Event{

    public List<User> trainers;
    public String skillLevel;

    public Training(String eventName, int eventID, List<User> attendees, ZonedDateTime startTime, ZonedDateTime endTime,
                    String location, List<User> trainers) {
        super(eventName, eventID, attendees, startTime, endTime, location);
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