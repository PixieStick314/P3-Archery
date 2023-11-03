package P3.Archery.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import java.time.ZonedDateTime;
import java.util.List;

@Document(collection = "events")
public class Training extends Event{

    public List<User> trainers;
    public String skillLevel;

    public Training(Event event, List<User> trainers) {
        super(event.getEventName(), event.getEventCreator(), event.getStartTime(), event.getEndTime(), event.getLocation(), event.getEventType());
        this.trainers = trainers;
    }

    public void addTrainer(User user){
        if(user.getAccessLevel() <= 1) {
            this.trainers.add(user);
        }
        else {
            System.out.println("Error: You do not have permission");
        }
    }
    public void removeTrainer(User user){
        if(user.getAccessLevel() <= 1) {
            this.trainers.remove(user);
        }
        else {
            System.out.println("Error: You do not have permission");
        }
    }

    public Training repeatTraining(Training training){
        String newID = "0"; //ID assignment placeholder
        ZonedDateTime newStartTime = training.startTime.plusDays(7);
        ZonedDateTime newEndTime = training.endTime.plusDays(7);
        Training newTraining = new Training(training, training.trainers);
        return newTraining;
    }

}