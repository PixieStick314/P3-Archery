package P3.Archery.service;

import P3.Archery.entity.IntroCourse;

import java.util.List;
import java.util.Optional;

public interface IntroCourseService {
    IntroCourse create(IntroCourse introCourse);
    Optional<IntroCourse> getById(String id);
    List<IntroCourse> getAll();
    IntroCourse update(IntroCourse introCourse);
    void deleteById(String id);
}
