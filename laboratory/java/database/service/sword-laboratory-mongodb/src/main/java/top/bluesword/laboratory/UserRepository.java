package top.bluesword.laboratory;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author 李林峰
 */
@Repository
public interface UserRepository extends MongoRepository<User,Long> {
}
