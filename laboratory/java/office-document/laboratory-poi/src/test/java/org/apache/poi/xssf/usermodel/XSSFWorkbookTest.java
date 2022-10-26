package org.apache.poi.xssf.usermodel;

import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddressList;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 李林峰
 */
@Slf4j
class XSSFWorkbookTest {

    @Test
    void importExcel() throws IOException {
        InputStream inputStream = new FileInputStream("import.xlsx");
        Workbook workbook = new XSSFWorkbook(inputStream);
        List<Map<String,Object>> data = new ArrayList<>();
        try (inputStream;workbook) {
            Sheet sheet = workbook.getSheetAt(1);
            for(int rowNum = 1; rowNum <= sheet.getLastRowNum(); rowNum++) {
                Row row = sheet.getRow(rowNum);
                Map<String,Object> rowData = new HashMap<>(36);
                data.add(rowData);
                rowData.put("itemNo",row.getCell(0).getStringCellValue());
                rowData.put("shippingMethod",row.getCell(1).getStringCellValue());
                Cell cell = row.getCell(3);
                rowData.put("customerOrderId", cell.getStringCellValue());
                rowData.put("chineseDesc",row.getCell(9).getStringCellValue());
            }
        }
        log.info("data:{}",data);
    }

    @Test
    void createExplicitListConstraint() throws IOException {
        XSSFWorkbook wb = new XSSFWorkbook();
        XSSFSheet sheet = wb.createSheet("下拉框测试");

        XSSFDataValidationHelper dvHelper = new XSSFDataValidationHelper(sheet);
        DataValidationConstraint dvConstraint = dvHelper.createExplicitListConstraint(new String[]{"a", "b", "c"});
        CellRangeAddressList addressList = new CellRangeAddressList(1, 500, 3, 3);
        DataValidation validation = dvHelper.createValidation(dvConstraint, addressList);
        validation.setShowErrorBox(true);
        sheet.addValidationData(validation);

        FileOutputStream fileOutputStream = new FileOutputStream("下拉框.xlsx");
        try(wb;fileOutputStream) {
            wb.write(fileOutputStream);
        }
    }
}
