package src.event;

import src.user.User;
import java.time.temporal.*;

public class CompetitionForm {
    private String name;
    private String gender;
    private long age;
    private int shootingClass;
    private String face;
    public CompetitionForm (User user, Competition competition, int shootingClass, String face) {
        this.name = user.name;
        this.gender = user.gender;
        this.age = user.dateOfBirth.until(competition.startTime.toLocalDate(), ChronoUnit.YEARS);
        this.shootingClass = shootingClass;
        this.face = face;
    }

}
