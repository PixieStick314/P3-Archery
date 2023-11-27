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
    private String email;

    //  Constructor
	public User(String name, String email) {
		this.name = name;
		this.email = email;
	}

    //  Getters & Setters


	public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
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