package top.bluesword.web.laboratory;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.streaming.SXSSFCell;
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

            SXSSFSheet sheet = table.createSheet("POI导出测试");

            SXSSFRow row1 = sheet.createRow(0);
            SXSSFCell row1cell1 = row1.createCell(0);
            row1cell1.setCellValue("蓝色前景");
            CellStyle baseTitleStyle = table.createCellStyle();
            baseTitleStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            baseTitleStyle.setFillForegroundColor(IndexedColors.BLUE.index);
            row1cell1.setCellStyle(baseTitleStyle);

            table.write(outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
