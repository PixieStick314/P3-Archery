package P3.Archery.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "users")
public class User{
    //  Attributes

	@Id
	private String id;

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

	public void addUser(User user, String name, String gender, String address, int postcode, int cellphoneNr, Date dateOfBirth, String eMail, int archerySkillLevel, int accessLevel, boolean hasLocker) throws Exception {
		if(user.accessLevel == 0) {
			//create new user and send to database
			//to be implemented when i know how database works
			User newUser = new User(name, gender, address, postcode, cellphoneNr, dateOfBirth, eMail, archerySkillLevel, accessLevel, hasLocker);
		} else throw new Exception("Du skal være superuser for at kunne bruge denne funktion");
	}
/*
	public void modifyUser(User user, String buttonValue, String change) {
		if (user.accessLevel == 0 || user == this) {
			System.out.println("Hvad kunne du tænke dig at ændre?");
			System.out.println("1. Navn\n" +
					"2. Køn\n" +
					"3. Addresse\n" +
					"4. Telefon nummer\n" +
					"5. Fødselsdag\n" +
					"6. Email\n" +
					"7. Bueskytte niveau\n" +);
			System.out.println("Hvad skal det ændres til?");
			//change = userChange.nextLine();
			switch (buttonValue) {
				//hvor meget verification skal vi bruge?
				case "name":
					this.name = change;
					break;
				case "adresse":
					this.address = change;
					break;
				case "Køn":
					this.gender = change;
					break;
				case "cellphoneNr":
					this.cellphoneNr = change;
					break;
				case "dateOfBirth":
					this.dateOfBirth = change;
					break;
				case "eMail":
					this.eMail = change;
					break;
				case "archerySkillLevel":
					this.archerySkillLevel = change;
					break;
				default:
					throw new Exception("Der skete en fejl, prøv venligst igen");
			}
		}
		else {
			printf("Access denied")
		}
	}

	public void removeUser(User admin, User RemovedUser){
		if(admin.accessLevel == 0 || RemovedUser == this) {
			RemovedUser = null;
			//dunno how to remove user from db yet, to be implemented.
		} else {
			throw new Exception("Du skal være superuser eller den bruger der skal fjernes for, at denne funktion kan andvendes");
		}
	}

	public void register(userNameField, userGenderField, userAddressField, userPostcodeField, userCellphoneNrField, userDateOfBirthField, userEMailField){
		//uses registration information from textfields to create a new user
		String name = userNameField.getText();
		String gender = userGenderField.getText();
		String address = userAddressField.getText();
		int postcode = Integer.parseInt(userPostcodeField.getText());
		int cellphoneNr = Integer.parseInt(userCellphoneNrField.getText());
		String dateOfBirth = userDateOfBirthField.getText();
		String eMail = userEMailField.getText();

		User newUser = new User(name, gender, address, postcode, cellphoneNr, dateOfBirth, eMail, 0, 0, false);
	}*/
}