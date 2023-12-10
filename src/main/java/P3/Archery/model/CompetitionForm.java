package P3.Archery.model;

//TODO: Remove
public class CompetitionForm {
    private String name;
    private String gender;
    private long age;
    private int shootingClass;
    private String face;
    public CompetitionForm (Member user, Competition competition, int shootingClass, String face) {
        this.name = user.getName();
        this.gender = user.getGender();
        //placeholder
        this.age = 69;
        this.shootingClass = shootingClass;
        this.face = face;
    }

}
