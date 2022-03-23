package top.bluesword.laboratory.excel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 李林峰
 */
@Controller
@RequestMapping("excel/import")
public class ImportExcelController {

    @PostMapping
    @ResponseBody
    public List<Map<String,Object>> importExcel(MultipartFile file) throws IOException {
        InputStream inputStream = file.getInputStream();
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
        return data;
    }
}
