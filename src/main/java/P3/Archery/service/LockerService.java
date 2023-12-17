package P3.Archery.service;

import P3.Archery.model.Locker;

import java.util.List;

public interface LockerService {
    Locker createLocker(Locker locker);
    List<Locker> getAllLockers();
    void deleteLockerById(String lockerId);
}
