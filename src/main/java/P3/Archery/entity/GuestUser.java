package P3.Archery.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "guests")
public class GuestUser extends User {
    public String name;
    public String email;

    public GuestUser(String name, String email) {
        super(name, email);
    }

}
