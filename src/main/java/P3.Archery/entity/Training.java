package P3.Archery.entity;

import java.time.ZonedDateTime;
import java.util.List;

public class Training extends Event{

    public List<User> trainers;
    public String skillLevel;

    public Training(String eventName, User eventCreator, int eventID, ZonedDateTime startTime, ZonedDateTime endTime,
                    String location, List<User> trainers) {
        super(eventName, eventCreator, eventID, startTime, endTime, location);
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