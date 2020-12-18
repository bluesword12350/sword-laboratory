package top.bluesword.web.laboratory.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import top.bluesword.web.laboratory.model.TransportLocation;

import java.util.Optional;

@SpringBootTest
public class TransportLocationRepositoryTest {

    @Autowired
    TransportLocationRepository transportLocationRepository;

    @Test
    void findById(){
        String id = "CNSGH";
        Optional<TransportLocation> repository = transportLocationRepository.findById(id);
        if (repository.isPresent()){
            TransportLocation transportLocation = repository.get();
        }
        transportLocationRepository.findById(id).ifPresent(System.out::println);
    }

}