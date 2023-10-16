package P3.Archery.service;

import P3.Archery.entity.Competition;

import java.util.List;
import java.util.Optional;

public interface CompetitionService {
    Competition create(Competition competition);
    Optional<Competition> getById(String id);
    List<Competition> getAll();
    Competition update(Competition competition);
    void deleteById(String id);
}
