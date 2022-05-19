package top.bluesword.laboratory.bean;

import java.util.*;

/**
 * @author 李林峰
 */
public class DataGenerate {
    public static Map<String, Object> generateMap() {
        Map<String, Object> map = new HashMap<>(1);
        map.put("list", generateList());
        return map;
    }

    public static List<ExcelTemplate> generateList() {
        List<ExcelTemplate> list = new ArrayList<>();
        int dataSize = 100;
        for (int i = 0; i < dataSize; i++) {
            list.add(new ExcelTemplate(i, UUID.randomUUID().toString(),"red"));
        }
        return list;
    }
}
