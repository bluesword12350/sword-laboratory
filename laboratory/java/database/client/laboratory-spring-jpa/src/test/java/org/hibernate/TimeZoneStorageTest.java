package org.hibernate;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import top.bluesword.laboratory.LaboratoryApplication;
import top.bluesword.laboratory.model.mock.JourneyMock;
import top.bluesword.laboratory.repository.JourneyRepository;

@SpringBootTest(classes = LaboratoryApplication.class)
public class TimeZoneStorageTest {

    @Resource
    private JourneyRepository journeyRepository;

    @Test
    void save(){
        journeyRepository.save(JourneyMock.mock());
    }
}
