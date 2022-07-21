package top.bluesword.laboratory.bean;

import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * @author 李林峰
 */
@Slf4j
public class DataGenerate {
    public static Map<String, Object> generateMap() {
        Map<String, Object> map = new HashMap<>(1);
        map.put("list", generateList());
        return map;
    }

    public static List<ExcelTemplate> generateList() {
        List<ExcelTemplate> list = new ArrayList<>();
        int i = 0;
        list.add(new ExcelTemplate(i++, UUID.randomUUID().toString(),"red",null));
        list.add(new ExcelTemplate(i++, UUID.randomUUID().toString(),"red",true));
        list.add(new ExcelTemplate(i++, UUID.randomUUID().toString(),"red",false));
        log.info("total:{}",i);
        return list;
    }
}
