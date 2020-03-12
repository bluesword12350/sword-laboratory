package top.bluesword.web.laboratory.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.domain.Specification;
import top.bluesword.web.laboratory.domain.Data;
import top.bluesword.web.laboratory.domain.Data_;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class DataJpaRepositoryTest {

    @Autowired
    DataJpaRepository dataJpaRepository;

    @Test
    void findAll(){
        List<Data> all = dataJpaRepository.findAll();
        System.out.println(all);
    }

    @Test
    void save(){
        Data data = new Data();
        data.setId(3L);
        data.setKey("key%");
        data.setName("name1");
        data.setType("type1");
        data.setDate(Instant.now());
        System.out.println(dataJpaRepository.save(data));
    }

    @Test
    void findById(){
        Optional<Data> data = dataJpaRepository.findById(1L);
        data.ifPresent(System.out::println);
    }

    @Test
    void findAllIsNotNull(){
        List<Data> all = dataJpaRepository.findAll(
                (Specification<Data>) (root, query, builder) -> builder.isNotNull(root.get(Data_.KEY))
        );
        System.out.println(all);
    }

    @Test
    void findAllLike(){
        String keyWord = "key\\%%";
        dataJpaRepository.findAll(
                (Specification<Data>) (root, criteriaQuery, criteriaBuilder) ->
                        criteriaBuilder.like(root.get(Data_.KEY),keyWord)
        ).forEach(System.out::println);
    }

    @Test
    void specification(){
        String keyWord = "key\\%%";
        dataJpaRepository.findAll(
                (Specification<Data>) (root, criteriaQuery, criteriaBuilder) ->
                        criteriaBuilder.and(
                                criteriaBuilder.like(root.get(Data_.KEY),keyWord),
                                criteriaBuilder.isNotNull(root.get(Data_.KEY))
                        )
        ).forEach(System.out::println);
    }
}