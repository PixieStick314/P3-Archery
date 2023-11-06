package P3.Archery.controller;

import P3.Archery.entity.User;
import P3.Archery.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) { this.userService = userService; }

    @PostMapping("/register")
    public ResponseEntity create(@RequestBody User user) {
        return new ResponseEntity(userService.create(user), HttpStatus.OK);
    }
}
