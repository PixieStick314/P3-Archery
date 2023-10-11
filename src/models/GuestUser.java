package src.models;

import java.util.Date;

public class GuestUser extends User{

    public GuestUser(String name, String gender, String address, int postcode, int cellphoneNr, Date dateOfBirth,
            String eMail, int archerySkillLevel, int accessLevel, boolean hasLocker) {
        super(name, gender, address, postcode, cellphoneNr, dateOfBirth, eMail, archerySkillLevel, accessLevel, hasLocker);
        //TODO Auto-generated constructor stub
    }
    
}
