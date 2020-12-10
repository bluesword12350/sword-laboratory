package top.bluesword.laboratory.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import top.bluesword.laboratory.domain.DataModel;
import top.bluesword.laboratory.domain.log.EditLog;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class EditLogJpaRepositoryTest {

    @Autowired
    DataJpaRepository dataJpaRepository;
    @Autowired
    EditLogJpaRepository editLogJpaRepository;

    @Test
    void saveAll(){
        List<EditLog> editLogs = mockEditLogs();
        System.out.println(editLogJpaRepository.saveAll(editLogs));
    }

    private List<EditLog> mockEditLogs() {
        List<EditLog> editLogs = new ArrayList<>();
        EditLog editLog = new EditLog();
        editLog.setEditTime(Instant.now());
        editLogs.add(editLog);
        List<DataModel> all = dataJpaRepository.findAll();
        if (!all.isEmpty()){
            editLog.setDataModel(all.get(0));
        }
        return editLogs;
    }
}