package P3.Archery.service;

import P3.Archery.entity.*;

import java.util.List;
import java.util.Optional;

public interface EventService {
    Event create(Event event);
    Optional<Event> getById(String id);
    List<Event> getAll();
    Event update(Event event);
    void deleteById(String id);

    List<Event> getAllCompetitions();
    List<Event> getAllTrainings();
    List<Event> getAllIntroCourses();

    void addGuestToCourse(String eventId, GuestUser guestUser);
    void removeGuestFromCourse(String eventId, GuestUser guestUser);
}
