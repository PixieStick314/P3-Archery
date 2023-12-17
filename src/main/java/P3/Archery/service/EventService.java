package P3.Archery.service;

import P3.Archery.model.*;

import java.util.List;
import java.util.Optional;

public interface EventService {
    Event create(Event event);
    Optional<Event> getById(String id);
    List<Event> getAll();
    Event update(Event event);
    Event register(Event event, User user);
    Event introRegister(Event event, GuestUser guestUser);
    void deleteById(String id);

    List<Event> getAllCompetitions();
    List<Event> getAllTrainings();
    List<Event> getAllIntroCourses();
}
