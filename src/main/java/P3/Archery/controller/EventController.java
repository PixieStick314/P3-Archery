package P3.Archery.controller;


import P3.Archery.auth.JwtUtil;
import P3.Archery.model.*;
import P3.Archery.model.request.RegisterReq;
import P3.Archery.service.EventService;
import P3.Archery.service.UserService;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/event")
public class EventController {

    private final EventService eventService;
    private final UserService userService;

    private final JwtUtil jwtUtil;

    public EventController(EventService eventService, UserService userService, JwtUtil jwtUtil) {
        this.eventService = eventService;
        this.userService = userService;
        this.jwtUtil = jwtUtil;
    }


    @PostMapping("/create")
    public ResponseEntity create(@RequestBody Event event) {
        switch (event.getEventType()) {
            case COMPETITION -> {
                Competition competition = new Competition(
                        event.getEventName(),
                        event.getEventCreator(),
                        event.getStartTime(),
                        event.getEndTime(),
                        event.getLocation(),
                        event.getEventType(),
                        event.getEventID(),
                        new ArrayList<>()
                );
                return new ResponseEntity(eventService.create(competition), HttpStatus.OK);
            }
            case TRAINING -> {
                Training training = new Training(
                        event.getEventName(),
                        event.getEventCreator(),
                        event.getStartTime(),
                        event.getEndTime(),
                        event.getLocation(),
                        event.getEventType(),
                        event.getEventID(),
                        new ArrayList<>()
                );
                return new ResponseEntity(eventService.create(training),HttpStatus.OK);
            }
            case INTRO -> {
                IntroCourse introCourse = new IntroCourse(
                        event.getEventName(),
                        event.getEventCreator(),
                        event.getStartTime(),
                        event.getEndTime(),
                        event.getLocation(),
                        event.getEventType(),
                        event.getEventID(),
                        new ArrayList<>()
                );
                return new ResponseEntity(eventService.create(introCourse), HttpStatus.OK);
            }
            default -> {
                return new ResponseEntity(HttpStatus.BAD_REQUEST);
            }
        }
    }

    @PostMapping("/register")
    public ResponseEntity register(HttpServletRequest req, @RequestBody RegisterReq registerReq) {
        Claims claims = jwtUtil.resolveClaims(req);
        if (claims != null) {
            Optional<User> member = userService.getById(jwtUtil.getId(claims));
            if (member != null) {
                System.out.println("Eventid from frontend: " + registerReq.getEventId());
                Optional<Event> event = eventService.getById(registerReq.getEventId());
                event.get().addAttendee(member.get());
                eventService.update(event.get());
            } else {
                return new ResponseEntity<>("Failed to get user", HttpStatus.BAD_REQUEST);
            }
        } else {
            return new ResponseEntity<>("Potentially invalid token", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity getAllEvents() {
        //TODO: once tokens are done, only return all if user is authenticated
       // return eventService.getAll();
        return new ResponseEntity<>(eventService.getAll(), HttpStatus.OK);

    }

    @GetMapping("/competition")
    public List<Event> getAllCompetitions() {
        return eventService.getAllCompetitions();
    }

    @GetMapping("/introcourse")
    public List<Event> getAllIntroCourses() {
        return eventService.getAllIntroCourses();
    }

    @GetMapping("/training")
    public List<Event> getAllTrainings() {
        return eventService.getAllTrainings();
    }

}
