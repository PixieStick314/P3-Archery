package P3.Archery.repository;

import P3.Archery.entity.IntroCourse;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IntroCourseRepository extends MongoRepository<IntroCourse, String> {
}
