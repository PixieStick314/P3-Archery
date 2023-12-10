package P3.Archery.controller;


import P3.Archery.auth.JwtUtil;
import P3.Archery.model.Member;
import P3.Archery.model.User;
import P3.Archery.model.request.LoginReq;
import P3.Archery.model.response.ErrorRes;
import P3.Archery.model.response.LoginRes;
import P3.Archery.service.UserService;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;
    private final AuthenticationManager authenticationManager;

    private final BCryptPasswordEncoder passwordEncoder;
    private JwtUtil jwtUtil;

    public UserController(UserService userService, AuthenticationManager authenticationManager, JwtUtil jwtUtil, BCryptPasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/register")
    public ResponseEntity create(@RequestBody Member member) {
        if (userService.getByEmail(member.getEmail()) != null) {
            ErrorRes errorRes = new ErrorRes(HttpStatus.BAD_REQUEST, "Email already in use");
            return ResponseEntity.badRequest().body(errorRes);
        }
        member.setPassword(passwordEncoder.encode(member.getPassword()));
        userService.create(member);
        try {
            String token = jwtUtil.createToken(member);

            LoginRes loginRes = new LoginRes(member.getEmail(), token);

            return ResponseEntity.ok(loginRes);
        } catch (Exception e) {
            ErrorRes errorRes = new ErrorRes(HttpStatus.BAD_REQUEST, "Unexpected error, please consult admin");
            return ResponseEntity.badRequest().body(errorRes);
        }
    }

    @PostMapping("/update")
    public ResponseEntity updateUser(HttpServletRequest req, @RequestBody Member member) {
        Claims claims = jwtUtil.resolveClaims(req);
        if (claims != null) {
            String email = jwtUtil.getEmail(claims);
            Member targetUser = (Member) userService.getByEmail(email);
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
        return new ResponseEntity("Unexpected error, please consult admin", HttpStatus.BAD_REQUEST);
    }

    //TODO: login
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginReq loginReq) {
        try {
            //TODO: Sometimes if email is the one that's incorrect it'll give an error other than invalid username or pass
            Authentication authentication =
                    authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginReq.getEmail(), loginReq.getPassword()));
            String email = authentication.getName();
            Member user = (Member) userService.getByEmail(email);
            String token = jwtUtil.createToken(user);

            LoginRes loginRes = new LoginRes(email, token);

            return ResponseEntity.ok(loginRes);
        } catch (BadCredentialsException e) {
            ErrorRes errorRes = new ErrorRes(HttpStatus.BAD_REQUEST, "Invalid username or password");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorRes);
        } catch (Exception e) {
            ErrorRes errorRes = new ErrorRes(HttpStatus.BAD_REQUEST, "Unexpected error, please consult admin");
            return ResponseEntity.badRequest().body(errorRes);
        }
    }

    //TODO: logout
    @PostMapping("/logout")
    public ResponseEntity<?> logout(HttpServletRequest request) {
        return ResponseEntity.ok("logout success");
    }
}
