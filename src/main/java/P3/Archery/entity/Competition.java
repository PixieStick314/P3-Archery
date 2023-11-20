package P3.Archery.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

@Document(collection = "events")
public class Competition extends Event{
    List<CompetitionForm> registrationList;


    public Competition(String eventName, User eventCreator, ZonedDateTime startTime, ZonedDateTime endTime, String location, EventType eventType, List<CompetitionForm> registrationList) {
        super(eventName, eventCreator, startTime, endTime, location, eventType);
        this.registrationList = registrationList;
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