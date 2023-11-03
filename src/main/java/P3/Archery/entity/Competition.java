package P3.Archery.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "events")
public class Competition extends Event{
    List<CompetitionForm> registrationList = new ArrayList<>();

    public Competition(Event event) {
        super(event.getEventName(), event.getEventCreator(), event.getStartTime(), event.getEndTime(), event.getLocation(), event.getEventType());
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