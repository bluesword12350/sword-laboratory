package top.bluesword.web.laboratory;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 李林峰
 */
@Controller
@RequestMapping("export-excel")
public class ExportExcelService {

    @GetMapping
    public void get(HttpServletResponse response){
        response.setHeader("content-disposition", "attachment;filename=test.xlsx");
        try (SXSSFWorkbook table = new SXSSFWorkbook();
             ServletOutputStream outputStream = response.getOutputStream()) {
            SXSSFSheet sheet = table.createSheet("颜色卡");
            sheet.setDefaultColumnWidth(20);
            sheet.setDefaultRowHeightInPoints(15);
            IndexedColors[] values = IndexedColors.values();
            int rowIndex = 0;
            for (int i = 0,j = 0,rowNumber = 6; j < rowNumber; j++) {
                SXSSFRow name = sheet.createRow(rowIndex++);
                SXSSFRow color = sheet.createRow(rowIndex++);
                for (int index = 0;i < (values.length/rowNumber*(j+1)); index++,i++){
                    IndexedColors value = values[i];
                    name.createCell(index).setCellValue(value.name());
                    CellStyle colorStyle = table.createCellStyle();
                    colorStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
                    colorStyle.setFillForegroundColor(value.index);
                    color.createCell(index).setCellStyle(colorStyle);
                }
            }
            table.write(outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
