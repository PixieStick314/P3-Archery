package P3.Archery.model;

import org.springframework.data.mongodb.core.mapping.Document;

import java.time.ZonedDateTime;
import java.util.List;

@Document(collection = "events")
public class Training extends Event{

    public List<User> trainers;
    //public String skillLevel;

    public Training(String eventName, User eventCreator, ZonedDateTime startTime, ZonedDateTime endTime, String location, EventType eventType, String eventID, List<User> trainers) {
        super(eventName, eventCreator, startTime, endTime, location, eventType, eventID);
        this.trainers = trainers;
        //this.skillLevel = skillLevel;
    }

    public void addTrainer(Member user){
        if(user.getAccessLevel() <= 1) {
            this.trainers.add(user);
        }
        else {
            System.out.println("Error: You do not have permission");
        }
    }
    public void removeTrainer(Member user){
        if(user.getAccessLevel() <= 1) {
            this.trainers.remove(user);
        }
        else {
            System.out.println("Error: You do not have permission");
        }
    }

}