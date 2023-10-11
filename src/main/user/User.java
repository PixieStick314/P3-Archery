package src.main.user;

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
	public User(String name, String gender, String address, 
				int postcode, int cellphoneNr, 
				Date dateOfBirth, String eMail, 
				int archerySkillLevel, int accessLevel, boolean hasLocker){
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


	public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

	public String getGender() {
		return gender;
	}

	public String getAddress() {
		return address;
	}

	public int getPostcode() {
		return postcode;
	}

	public int getCellphoneNr() {
		return cellphoneNr;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public String geteMail() {
		return eMail;
	}

	public int getArcherySkillLevel() {
		return archerySkillLevel;
	}

	public int getAccessLevel() {
		return accessLevel;
	}

	public boolean isHasLocker() {
		return hasLocker;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setPostcode(int postcode) {
		this.postcode = postcode;
	}

	public void setCellphoneNr(int cellphoneNr) {
		this.cellphoneNr = cellphoneNr;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public void setArcherySkillLevel(int archerySkillLevel) {
		this.archerySkillLevel = archerySkillLevel;
	}

	public void setAccessLevel(int accessLevel) {
		this.accessLevel = accessLevel;
	}

	public void setHasLocker(boolean hasLocker) {
		this.hasLocker = hasLocker;
	}

}