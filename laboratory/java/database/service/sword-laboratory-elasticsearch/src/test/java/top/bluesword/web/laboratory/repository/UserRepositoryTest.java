package top.bluesword.web.laboratory.repository;

import org.elasticsearch.index.query.QueryBuilders;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
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

    @Test
    void search(){
        NativeSearchQuery searchQuery = new NativeSearchQueryBuilder()
                .withQuery(QueryBuilders.wildcardQuery("name", "sw*"))
                .withFields("name")
                .build();
        Page<User> search = userRepository.search(searchQuery);
        System.out.println(search.getContent());
    }
}