package P3.Archery.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "users")
public class User{
    //  Attributes

	@Id
	private String id;

	private String password;

    private String name;
    private String gender;
    private String address;
    private int postcode;
    private int cellphoneNr;
    private Date dateOfBirth;
    private String email;
    private int archerySkillLevel;
    private int accessLevel;
    private boolean hasLocker;


    //  Constructor
	public User(String name, String gender, String address, 
				int postcode, int cellphoneNr, 
				Date dateOfBirth, String email,
				int archerySkillLevel, int accessLevel, boolean hasLocker, String password){
		this.name = name;
		this.gender = gender;
		this.address = address;
		this.postcode = postcode;
		this.cellphoneNr = cellphoneNr;
		this.dateOfBirth = dateOfBirth;
		this.email = email;
		this.archerySkillLevel = archerySkillLevel;
		this.accessLevel = accessLevel;
		this.hasLocker = hasLocker;
		this.password = password;
	}

    //  Getters & Setters


	public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

	public String getPassword() { return password; }

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

	public String getEmail() {
		return email;
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

	public void setPassword(String password) {this.password = password;}

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

	public void setEmail(String email) {
		this.email = email;
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

	public void addUser(User user, String name, String gender, String address, int postcode, int cellphoneNr, Date dateOfBirth, String email, int archerySkillLevel, int accessLevel, boolean hasLocker) throws Exception {
		if(user.accessLevel == 0) {
			//create new user and send to database
			//to be implemented when i know how database works
			User newUser = new User(name, gender, address, postcode, cellphoneNr, dateOfBirth, email, archerySkillLevel, accessLevel, hasLocker, password);
		} else throw new Exception("Du skal være superuser for at kunne bruge denne funktion");
	}

	public int getAuthorities() {
        return this.accessLevel;
    }
}