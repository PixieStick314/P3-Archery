package P3.Archery.service;

import P3.Archery.entity.IntroCourse;
import P3.Archery.repository.IntroCourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IntroCourseServiceImpl implements IntroCourseService {

    private final IntroCourseRepository introCourseRepository;

    public IntroCourseServiceImpl(final IntroCourseRepository introCourseRepository) {
        this.introCourseRepository = introCourseRepository;
    }

    @Override
    public IntroCourse create(IntroCourse introCourse) {
        return introCourseRepository.save(introCourse);
    }

    @Override
    public Optional<IntroCourse> getById(String id) {
        return introCourseRepository.findById(id);
    }

    @Override
    public List<IntroCourse> getAll() {
        return introCourseRepository.findAll();
    }

    @Override
    public IntroCourse update(IntroCourse introCourse) {
        return introCourseRepository.save(introCourse);
    }

    @Override
    public void deleteById(String id) {
        introCourseRepository.deleteById(id);
    }
}
