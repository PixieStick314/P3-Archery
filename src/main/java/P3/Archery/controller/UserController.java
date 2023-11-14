package P3.Archery.controller;

import P3.Archery.entity.User;
import P3.Archery.service.UserService;
import org.bson.types.ObjectId;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) { this.userService = userService; }

    @PostMapping("/create")
    public ResponseEntity create(@RequestBody User user) {
        return new ResponseEntity(userService.create(user), HttpStatus.OK);
    }

    @PostMapping("/update/{userId}")
    public ResponseEntity updateUser(@PathVariable(value = "userId") String id, @RequestBody User user) {
        Optional<User> targetUser = userService.getById(id);
        if (targetUser.isPresent()) {
            targetUser.get().setName(user.getName());
            targetUser.get().setGender(user.getGender());
            targetUser.get().setAddress(user.getAddress());
            targetUser.get().setPostcode(user.getPostcode());
            targetUser.get().setCellphoneNr(user.getCellphoneNr());
            targetUser.get().setDateOfBirth(user.getDateOfBirth());
            targetUser.get().setEmail(user.getEmail());
            targetUser.get().setArcherySkillLevel(user.getArcherySkillLevel());
            return new ResponseEntity(userService.update(targetUser.get()), HttpStatus.OK);
        } else {
            return new ResponseEntity("User not found", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{userId}")
    public ResponseEntity getUser(@PathVariable(value = "userId") String id) {
        System.out.printf("Obtained id is: %s", id);
        Optional<User> userOpt = userService.getById(id);
        if (userOpt.isPresent()) {
            return new ResponseEntity(userOpt, HttpStatus.OK);
        } else {
            return new ResponseEntity("User not found", HttpStatus.BAD_REQUEST);
        }
    }


}
