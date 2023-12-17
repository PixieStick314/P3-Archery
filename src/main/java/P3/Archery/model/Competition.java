package P3.Archery.model;

import org.springframework.data.mongodb.core.mapping.Document;

import java.time.ZonedDateTime;
import java.util.List;

@Document(collection = "events")
public class Competition extends Event{
    List<CompetitionForm> registrationList;


    public Competition(String eventName, User eventCreator, ZonedDateTime startTime, ZonedDateTime endTime, String location, EventType eventType, String eventID, List<CompetitionForm> registrationList) {
        super(eventName, eventCreator, startTime, endTime, location, eventType, eventID);
        this.registrationList = registrationList;
    }

    public void addRegistration(Member user, Competition competition, int shootingClass, String face){
        CompetitionForm registration = new CompetitionForm(user, competition, shootingClass, face);
        registrationList.add(registration);
    }

    public String exportRegistration() {
        String fileName = "Placeholder";
        return fileName;
    }

}