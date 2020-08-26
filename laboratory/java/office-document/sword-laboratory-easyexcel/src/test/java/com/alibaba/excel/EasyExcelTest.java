package com.alibaba.excel;

import org.junit.jupiter.api.Test;
import top.bluesword.model.DemoData;

import java.util.List;

class EasyExcelTest {

    @Test
    void simpleWrite() {
        String fileName = "write" + System.currentTimeMillis() + ".xlsx";
        EasyExcel.write(fileName, DemoData.class).sheet("模板").doWrite(List.of(new DemoData()));
    }

}
