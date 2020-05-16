package top.bluesword.web.laboratory.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import top.bluesword.web.laboratory.domain.DataModel;
import top.bluesword.web.laboratory.domain.DataModel_;
import top.bluesword.web.laboratory.mock.DataModelMock;

import java.util.List;
import java.util.Optional;

import static top.bluesword.web.laboratory.mock.DataModelMock.mock;

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
    void pageRequest(){
        Page<DataModel> all = dataJpaRepository.findAll(PageRequest.of(0,1));
        System.out.println(all);
    }

    @Test
    void save(){
        DataModel dataModel = mock();
        System.out.println(dataJpaRepository.save(dataModel));
    }

    @Test
    void update(){
        List<DataModel> dataModels = dataJpaRepository.findAll();
        if (!dataModels.isEmpty()) {
            DataModel dataModel = dataModels.get(0);
            dataModel.setFragments(DataModelMock.mockFormatList());
            dataJpaRepository.save(dataModel);
        }
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