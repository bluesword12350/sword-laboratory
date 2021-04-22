package top.bluesword.laboratory;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.naming.Name;

@Repository
public interface PersonRepository extends CrudRepository<Person, Name> {
}
