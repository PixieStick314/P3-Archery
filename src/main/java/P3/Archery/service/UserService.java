package P3.Archery.service;

import P3.Archery.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.Optional;

public interface UserService extends UserDetailsService {
    User create(User user);
    Optional<User> getById(String id);
    List<User> getAll();
    User update(User user);

    User getByEmail(String email);

    void deleteById(String id);

}
