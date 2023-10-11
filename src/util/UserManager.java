package src.util;

import java.util.ArrayList;
import java.util.List;

import src.main.user.User;

public class UserManager {
    private List<User> users;

    public UserManager() {
        this.users = new ArrayList<>();
    }

    public void register(User user){
        // Validate and add the user to the users list
        // E.g., check if the email already exists, etc.
    }

    public void addUser(User user){
        this.users.add(user);
    }

    public void modifyUser(User user, String newName, String newEmail){
        // Modify user attributes
        user.setName(newName);
        user.seteMail(newEmail);
        // Further modification...
    }

    public void removeUser(User user){
        this.users.remove(user);
    }

    // More methods, e.g., findUserByEmail, getAllUsers, etc...
}
