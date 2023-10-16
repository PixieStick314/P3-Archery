package P3.Archery.repository;

import P3.Archery.entity.Locker;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LockerRepository extends MongoRepository<Locker, String> {
}
