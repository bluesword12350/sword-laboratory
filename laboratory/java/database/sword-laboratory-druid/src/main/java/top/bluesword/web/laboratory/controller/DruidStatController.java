package top.bluesword.web.laboratory.controller;

import com.alibaba.druid.stat.DruidStatManagerFacade;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 李林峰
 */
@RestController
@RequestMapping("/druidStat")
public class DruidStatController {

    private final DruidStatManagerFacade managerFacade = DruidStatManagerFacade.getInstance();

    @GetMapping("/stat")
    public Object druidStat(){
        return managerFacade.getDataSourceStatDataList();
    }

    @GetMapping("/sqlStatDataList")
    public Object sqlStat(){
        return managerFacade.getSqlStatDataList(null);
    }
}