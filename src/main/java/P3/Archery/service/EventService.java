package P3.Archery.service;

import P3.Archery.entity.Competition;
import P3.Archery.entity.Event;
import P3.Archery.entity.IntroCourse;
import P3.Archery.entity.Training;

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
}
