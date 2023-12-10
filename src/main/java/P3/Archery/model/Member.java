package P3.Archery.model;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "users")
public class Member extends User {

    private String password;

    private String gender;
    private String address;
    private int postcode;
    private int cellphoneNr;
    private Date dateOfBirth;
    private int archerySkillLevel;
    private int accessLevel;
    private boolean hasLocker;


    public Member(String name, String email, String password, String gender, String address, int postcode,
                  int cellphoneNr, Date dateOfBirth, int archerySkillLevel, int accessLevel, boolean hasLocker
                  ) {
        super(name, email);
        this.gender = gender;
        this.address = address;
        this.postcode = postcode;
        this.cellphoneNr = cellphoneNr;
        this.dateOfBirth = dateOfBirth;
        this.archerySkillLevel = archerySkillLevel;
        this.accessLevel = accessLevel;
        this.hasLocker = hasLocker;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPostcode() {
        return postcode;
    }

    public void setPostcode(int postcode) {
        this.postcode = postcode;
    }

    public int getCellphoneNr() {
        return cellphoneNr;
    }

    public void setCellphoneNr(int cellphoneNr) {
        this.cellphoneNr = cellphoneNr;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getArcherySkillLevel() {
        return archerySkillLevel;
    }

    public void setArcherySkillLevel(int archerySkillLevel) {
        this.archerySkillLevel = archerySkillLevel;
    }

    public int getAccessLevel() {
        return accessLevel;
    }

    public void setAccessLevel(int accessLevel) {
        this.accessLevel = accessLevel;
    }

    public boolean isHasLocker() {
        return hasLocker;
    }

    public void setHasLocker(boolean hasLocker) {
        this.hasLocker = hasLocker;
    }
}
