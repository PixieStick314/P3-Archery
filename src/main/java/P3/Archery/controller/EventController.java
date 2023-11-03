package P3.Archery.controller;


import P3.Archery.entity.*;
import P3.Archery.repository.EventRepository;
import P3.Archery.service.EventService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/event")
public class EventController {

    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }


    @PostMapping("/create")
    public ResponseEntity create(@RequestBody Event event) {
        switch (event.getEventType()) {
            case COMPETITION -> {
                Competition competition = new Competition(event);
                return new ResponseEntity(eventService.create(competition), HttpStatus.OK);
            }
            case TRAINING -> {
                Training training = new Training(event, new ArrayList<>());
                return new ResponseEntity(eventService.create(training),HttpStatus.OK);
            }
            case INTRO -> {
                IntroCourse introCourse = new IntroCourse(event, new ArrayList<>());
                return new ResponseEntity(eventService.create(introCourse), HttpStatus.OK);
            }
            default -> {
                return new ResponseEntity(HttpStatus.BAD_REQUEST);
            }
        }
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
