package src.user;

import java.util.Date;

public class User{
    //  Attributes
    private String name;
    private String gender;
    private String address;
    private int postcode;
    private int cellphoneNr;
    private Date dateOfBirth;
    private String eMail;
    private int archerySkillLevel;
    private int accessLevel;
	private boolean hasLocker;


    //  Constructor
	public User(String name, String gender, String address, int postcode, int cellphoneNr, Date dateOfBirth, String eMail, int archerySkillLevel, int accessLevel, boolean hasLocker){
		this.name = name;
		this.gender = gender;
		this.address = address;
		this.postcode = postcode;
		this.cellphoneNr = cellphoneNr;
		this.dateOfBirth = dateOfBirth;
		this.eMail = eMail;
		this.archerySkillLevel = archerySkillLevel;
		this.accessLevel = accessLevel;
		this.hasLocker = hasLocker;
	}

    //  Getters & Setters
	public void register(User name, User eMail, ){

	}

	public void addUser(){
		
	}

	public void modifyUser(){

	}

	public void removeUser(){

	}
}