package P3.Archery.service;

import P3.Archery.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User create(User user);
    Optional<User> getById(String id);

    Optional<User> getByEmail(String email);
    List<User> getAll();
    User update(User user);
    void deleteById(String id);
}
