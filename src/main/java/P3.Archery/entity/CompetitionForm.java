package P3.Archery.entity;

import java.time.temporal.*;

public class CompetitionForm {
    private String name;
    private String gender;
    private long age;
    private int shootingClass;
    private String face;
    public CompetitionForm (User user, Competition competition, int shootingClass, String face) {
        this.name = user.getName();
        this.gender = user.getGender();
        //placeholder
        this.age = 69;
        this.shootingClass = shootingClass;
        this.face = face;
    }

}
