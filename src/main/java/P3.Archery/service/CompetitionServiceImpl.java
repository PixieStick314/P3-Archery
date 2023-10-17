package P3.Archery.service;

import P3.Archery.entity.Competition;
import P3.Archery.repository.CompetitionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompetitionServiceImpl implements CompetitionService {
    private final CompetitionRepository competitionRepository;

    public CompetitionServiceImpl(final CompetitionRepository competitionRepository) {
        this.competitionRepository = competitionRepository;
    }

    @Override
    public Competition create(Competition competition) {
        return competitionRepository.save(competition);
    }

    @Override
    public Optional<Competition> getById(String id) {
        return competitionRepository.findById(id);
    }

    @Override
    public List<Competition> getAll() {
        return competitionRepository.findAll();
    }

    @Override
    public Competition update(Competition competition) {
        return competitionRepository.save(competition);
    }

    @Override
    public void deleteById(String id) {
        competitionRepository.deleteById(id);
    }
}
