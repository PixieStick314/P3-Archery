package P3.Archery.controller;


import P3.Archery.entity.Member;
import P3.Archery.entity.User;
import P3.Archery.service.UserService;
import P3.Archery.util.TokenManager;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

import java.util.Optional;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;
    private final TokenManager tokenManager;

    public UserController(UserService userService, TokenManager tokenManager) {
        this.userService = userService;
        this.tokenManager = tokenManager;
    }

    @PostMapping("/create")
    public ResponseEntity create(@RequestBody Member member) {
        return new ResponseEntity(userService.create(member), HttpStatus.OK);
    }

    @PostMapping("/update/{userId}")
    public ResponseEntity updateUser(@PathVariable(value = "userId") String id, @RequestBody Member member) {
        Member targetUser = (Member) userService.getById(id).get();
        if (targetUser != null) {
            targetUser.setName(member.getName());
            targetUser.setPassword(targetUser.getPassword());
            targetUser.setGender(member.getGender());
            targetUser.setAddress(member.getAddress());
            targetUser.setPostcode(member.getPostcode());
            targetUser.setCellphoneNr(member.getCellphoneNr());
            targetUser.setDateOfBirth(member.getDateOfBirth());
            targetUser.setEmail(member.getEmail());
            targetUser.setArcherySkillLevel(member.getArcherySkillLevel());
            System.out.println(member.getEmail());
            return new ResponseEntity(userService.update(targetUser), HttpStatus.OK);
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

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Member user) {
        //  Authenticate w/ UserService
        Boolean authenticatedUser = userService.authenticate(user.getEmail(), user.getPassword());

        if (authenticatedUser != null){
            Authentication authentication = new UsernamePasswordAuthenticationToken(user.getAccessLevel(), authenticatedUser, null);

            String token = tokenManager.generateToken(authentication);
            //  Return user information and token:
            Map<String, Object> response = new HashMap<>();
            response.put("user", user);
            response.put("token", token);

            //  return authenticated user and token
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Authentication error");
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logout(HttpServletRequest request) {
        tokenManager.invalidateToken();
        return ResponseEntity.ok("logout success");
    }
}
