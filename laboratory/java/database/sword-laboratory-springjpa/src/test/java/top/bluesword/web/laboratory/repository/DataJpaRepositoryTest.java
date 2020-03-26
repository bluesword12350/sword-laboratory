package top.bluesword.web.laboratory.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.domain.Specification;
import top.bluesword.web.laboratory.domain.DataModel;
import top.bluesword.web.laboratory.domain.DataModel_;
import top.bluesword.web.laboratory.domain.TypeEnum;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class DataJpaRepositoryTest {

    @Autowired
    DataJpaRepository dataJpaRepository;

    @Test
    void findAll(){
        List<DataModel> all = dataJpaRepository.findAll();
        System.out.println(all);
    }

    @Test
    void save(){
        DataModel dataModel = new DataModel();
        dataModel.setId(3L);
        dataModel.setKey("key%");
        dataModel.setName("name1");
        dataModel.setType(TypeEnum.CANDIDATE);
        dataModel.setDate(Instant.now());
        System.out.println(dataJpaRepository.save(dataModel));
    }

    @Test
    void findById(){
        Optional<DataModel> data = dataJpaRepository.findById(1L);
        data.ifPresent(System.out::println);
    }

    @Test
    void findAllIsNotNull(){
        List<DataModel> all = dataJpaRepository.findAll(
                (Specification<DataModel>) (root, query, builder) -> builder.isNotNull(root.get(DataModel_.KEY))
        );
        System.out.println(all);
    }

    @Test
    void findAllLike(){
        String keyWord = "key\\%%";
        dataJpaRepository.findAll(
                (Specification<DataModel>) (root, criteriaQuery, criteriaBuilder) ->
                        criteriaBuilder.like(root.get(DataModel_.KEY),keyWord)
        ).forEach(System.out::println);
    }

    @Test
    void specification(){
        String keyWord = "key\\%%";
        dataJpaRepository.findAll(
                (Specification<DataModel>) (root, criteriaQuery, criteriaBuilder) ->
                        criteriaBuilder.and(
                                criteriaBuilder.like(root.get(DataModel_.KEY),keyWord),
                                criteriaBuilder.isNotNull(root.get(DataModel_.KEY))
                        )
        ).forEach(System.out::println);
    }
}