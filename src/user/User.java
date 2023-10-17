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
	private String password


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

	public void addUser(User user, String name, String gender, String address, int postcode, int cellphoneNr, Date dateOfBirth, String eMail, int archerySkillLevel, int accessLevel, boolean hasLocker) {
		if(user.accessLevel == 0) {
			//create new user and send to database
			//to be implemented when i know how database works
			User /*?*/ = new User(name, gender, address, postcode, cellphoneNr, dateOfBirth, eMail, archerySkillLevel, accessLevel, hasLocker);
		} else throw new Exception("Du skal være superuser for at kunne bruge denne funktion");
	}

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

}