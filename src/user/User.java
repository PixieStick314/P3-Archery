package src.user;

import java.util.Date;

public class User{
    //  Attributes
    public String name;
    public String gender;
    public String address;
    public int postcode;
    public int cellphoneNr;
    public Date dateOfBirth;
    public String eMail;
    public int archerySkillLevel;
    public int accessLevel;
	public boolean hasLocker;


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
	public void register(User name, User eMail){

	}

	public void addUser(){
		
	}

	public void modifyUser(){

	}

	public void removeUser(){

	}
}