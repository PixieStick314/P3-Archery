/*User
  	Attributes:
		Name,
    	Gender,
    	Address,
	    Postcode,
    	Cellphone nr,
	    Date of birth,
    	E-mail,
	    ArcherySkillLevel,
    	isSuperUser,
    	isAdmin,
	    isTrainer
	Methods:
		register(),
    	createEvent(isSuperUser)
		modifyEvent(isSuperUser)
		deleteEvent(isSuperUser)
		addUser(isSuperUser)
		removeUser(isSuperUser)
		modifyUser(isSuperUser)
		modifySuperUser(isAdmin)
		modifyTrainerStatus(isSuperuser)
*/

import java.util.Date;

public class User{
    private String name;
    private int gender;
    private String address;
    private int postcode;
    private int cellphoneNr;
    private Date dateOfBirth;
    private String eMail;
    private int archerySkillLevel;
    private boolean isSuperUser;
    private boolean isAdmin;
    private boolean isTrainer;

    
}