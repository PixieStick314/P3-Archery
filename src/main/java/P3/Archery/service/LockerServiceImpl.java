package P3.Archery.service;

import P3.Archery.entity.Locker;
import P3.Archery.repository.LockerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LockerServiceImpl implements LockerService {

    private final LockerRepository lockerRepository;

    public LockerServiceImpl(final LockerRepository lockerRepository) {
        this.lockerRepository = lockerRepository;
    }

    @Override
    public Locker createLocker(Locker locker) {
        return lockerRepository.save(locker);
    }

    @Override
    public List<Locker> getAllLockers() {
        return lockerRepository.findAll();
    }

    @Override
    public void deleteLockerById(String lockerId) {
        lockerRepository.deleteById(lockerId);
    }
}
