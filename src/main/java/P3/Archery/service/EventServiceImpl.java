package P3.Archery.service;

import P3.Archery.entity.*;
import P3.Archery.repository.EventRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;

    public EventServiceImpl(final EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public Event create(Event event) {
        return eventRepository.save(event);
    }

    @Override
    public Optional<Event> getById(String id) {
        return eventRepository.findById(id);
    }

    @Override
    public List<Event> getAll() {
        return eventRepository.findAll();
    }

    @Override
    public Event update(Event event) {
        return eventRepository.save(event);
    }

    @Override
    public void deleteById(String id) {
        eventRepository.deleteById(id);
    }

    @Override
    public List<Event> getAllCompetitions() {
        return eventRepository.findAll().stream().filter(e -> e.getEventType() == Event.EventType.COMPETITION).collect(Collectors.toList());
    }

    @Override
    public List<Event> getAllTrainings() {
        return eventRepository.findAll().stream().filter(e -> e.getEventType() == Event.EventType.TRAINING).collect(Collectors.toList());
    }

    @Override
    public List<Event> getAllIntroCourses() {
        return eventRepository.findAll().stream().filter(e -> e.getEventType() == Event.EventType.INTRO).collect(Collectors.toList());
    }
    @Override
    public void addGuestToCourse(String eventId, GuestUser guestUser) {
        IntroCourse course = (IntroCourse) eventRepository.findById(eventId)
                .orElseThrow(() -> new RuntimeException("Event not found"));
        course.addIntroCourseRegistration(guestUser);
        eventRepository.save(course);
    }
    @Override
    public void removeGuestFromCourse(String eventId, GuestUser guestUser){
        IntroCourse course = (IntroCourse) eventRepository.findById(eventId)
                .orElseThrow(() -> new RuntimeException("Event not found"));
        course.removeIntroCourseRegistration(guestUser);
        eventRepository.save(course);
    }
}
