package P3.Archery.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "users")
public class User{
    //  Attributes

	public enum Role {
		GUEST,
		USER,
		ADMIN;
	}

	@Id
	private String id;

    private String name;
    private String email;

	private List<Role> roles;

    //  Constructor
	public User(String name, String email) {
		this.name = name;
		this.email = email;
	}

    //  Getters & Setters


	public String getId() {
		return id;
	}

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

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

}