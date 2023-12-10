package P3.Archery.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "guests")
public class GuestUser extends User {

    public GuestUser(String name, String email) {
        super(name, email);
    }

}
