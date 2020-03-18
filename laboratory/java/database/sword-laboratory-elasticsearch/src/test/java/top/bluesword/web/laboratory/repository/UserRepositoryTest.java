package top.bluesword.web.laboratory.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import top.bluesword.web.laboratory.model.User;

import java.time.Instant;

@SpringBootTest
class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Test
    void save(){
        User user = new User();
        user.setId("2");
        user.setName("sword2");
        user.setCreateTime(Instant.now().toEpochMilli());
        System.out.println(userRepository.save(user));
    }

    @Test
    void findAll(){
        Iterable<User> users = userRepository.findAll();
        users.forEach(System.out::println);
    }

    @Test
    void deleteById(){
        userRepository.deleteById("2");
    }

    @Test
    void findByName(){
        Iterable<User> users = userRepository.findByNameContaining("sw");
        System.out.println(users);
    }
}