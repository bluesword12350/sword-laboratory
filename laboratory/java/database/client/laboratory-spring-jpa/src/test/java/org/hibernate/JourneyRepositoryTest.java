package org.hibernate;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import top.bluesword.laboratory.LaboratoryApplication;
import top.bluesword.laboratory.model.Journey;
import top.bluesword.laboratory.model.mock.JourneyMock;
import top.bluesword.laboratory.repository.JourneyRepository;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest(classes = LaboratoryApplication.class)
public class JourneyRepositoryTest {

    @Resource
    private JourneyRepository journeyRepository;

    @Test
    void save(){
        journeyRepository.save(JourneyMock.mock());
    }

    @Test
    void batchSave(){
        List<Journey> journeyList = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            journeyList.add(JourneyMock.mock());
        }
        journeyRepository.saveAll(journeyList);
    }
}
