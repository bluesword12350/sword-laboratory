package top.bluesword.laboratory.repository;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.transaction.annotation.Transactional;
import top.bluesword.laboratory.domain.DataModel;
import top.bluesword.laboratory.domain.DataModel_;
import top.bluesword.laboratory.mock.DataModelMock;
import top.bluesword.laboratory.transfer.DataFragmentDTO;
import top.bluesword.laboratory.transfer.DataModelDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@SpringBootTest
class DataJpaRepositoryTest {

    @Autowired
    private DataJpaRepository dataJpaRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Test
    void coverFragment() {
        DataModel dataModel = DataModelMock.mock();
        dataModel = dataJpaRepository.save(dataModel);
        dataModel = dataJpaRepository.findById(dataModel.getId()).orElseThrow();
        DataModelDTO dataModelDTO = modelMapper.map(dataModel, DataModelDTO.class);
        List<DataFragmentDTO> fragments = dataModelDTO.getContext().getFragments();
        DataFragmentDTO dataFragment0 = fragments.get(0);
        dataFragment0.setTitle("修改同一条数据，原始ID为"+dataFragment0.getId());
        DataFragmentDTO dataFragment1 = fragments.get(1);
        dataFragment1.setId(null);
        dataFragment1.setTitle("新增的数据");
        DataModel dataModel1 = modelMapper.map(dataModelDTO, DataModel.class);
        DataModel dataModel2 = dataJpaRepository.save(dataModel1);
        log.info("{}",dataModel2);
    }

    @Test
    @Transactional
    void findAll(){
        List<DataModel> all = dataJpaRepository.findAll();
        List<DataModelDTO> dataModels = new ArrayList<>();
        for (DataModel dataModel : all) {
            DataModelDTO dto = modelMapper.map(dataModel, DataModelDTO.class);
            dataModels.add(dto);
        }
        System.out.println(dataModels);
    }

    @Test
    void pageRequest(){
        Page<DataModel> all = dataJpaRepository.findAll(PageRequest.of(0,1));
        System.out.println(all);
    }

    @Test
    void save(){
        DataModel dataModel = DataModelMock.mock();
        dataModel = dataJpaRepository.save(dataModel);
        DataModelDTO dataModelData = modelMapper.map(dataModel, DataModelDTO.class);
        log.info("{}",dataModelData);
    }

    @Test
    void update(){
        List<DataModel> dataModels = dataJpaRepository.findAll();
        if (!dataModels.isEmpty()) {
            DataModel dataModel = dataModels.get(0);
            dataModel.setContext(DataModelMock.mockContext());
            dataJpaRepository.save(dataModel);
        }
    }

    @Test
    @Transactional(rollbackFor = Throwable.class)
    void findById(){
        Optional<DataModel> data = dataJpaRepository.findById(624L);
        if (data.isEmpty()) {
            log.error("数据不存在");
            return;
        }
        DataModelDTO dataModelData = modelMapper.map(data.get(), DataModelDTO.class);
        log.info("{}",dataModelData);
    }

    @Test
    void findAllIsNotNull(){
        List<DataModel> all = dataJpaRepository.findAll(
                (Specification<DataModel>) (root, query, builder) -> builder.isNotNull(root.get(DataModel_.CODE))
        );
        System.out.println(all);
    }

    @Test
    void findAllLike(){
        String keyWord = "key\\%%";
        dataJpaRepository.findAll(
                (Specification<DataModel>) (root, criteriaQuery, criteriaBuilder) ->
                        criteriaBuilder.like(root.get(DataModel_.CODE),keyWord)
        ).forEach(System.out::println);
    }

    @Test
    void specification(){
        String keyWord = "key\\%%";
        dataJpaRepository.findAll(
                (Specification<DataModel>) (root, criteriaQuery, criteriaBuilder) ->
                        criteriaBuilder.and(
                                criteriaBuilder.like(root.get(DataModel_.CODE),keyWord),
                                criteriaBuilder.isNotNull(root.get(DataModel_.CODE))
                        )
        ).forEach(System.out::println);
    }

}