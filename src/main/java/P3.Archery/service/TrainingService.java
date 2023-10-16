package P3.Archery.service;

import P3.Archery.entity.Training;

import java.util.List;
import java.util.Optional;

public interface TrainingService {
    Training create(Training training);
    Optional<Training> getById(String id);
    List<Training> getAll();
    Training update(Training training);
    void deleteById(String id);
}
