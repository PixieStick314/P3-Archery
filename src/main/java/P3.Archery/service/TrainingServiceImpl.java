package P3.Archery.service;

import P3.Archery.entity.Training;
import P3.Archery.repository.TrainingRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrainingServiceImpl implements TrainingService {

    private final TrainingRepository trainingRepository;

    public TrainingServiceImpl(final TrainingRepository trainingRepository) {
        this.trainingRepository = trainingRepository;
    }

    @Override
    public Training create(Training training) {
        return trainingRepository.save(training);
    }

    @Override
    public Optional<Training> getById(String id) {
        return trainingRepository.findById(id);
    }

    @Override
    public List<Training> getAll() {
        return trainingRepository.findAll();
    }

    @Override
    public Training update(Training training) {
        return trainingRepository.save(training);
    }

    @Override
    public void deleteById(String id) {
        trainingRepository.deleteById(id);
    }

}
