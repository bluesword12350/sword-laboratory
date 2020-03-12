package top.bluesword.web.laboratory;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
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
    public void get(HttpServletResponse response) throws IOException {
        SXSSFWorkbook table = new SXSSFWorkbook();
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
                SXSSFCell nameCell = name.createCell(index);
                nameCell.setCellValue(value.name());
                CellStyle colorStyle = table.createCellStyle();
                Font font = table.createFont();
                font.setColor(value.index);
                colorStyle.setFont(font);
                nameCell.setCellStyle(colorStyle);
                CellStyle fillForegroundColorStyle = table.createCellStyle();
                fillForegroundColorStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
                fillForegroundColorStyle.setFillForegroundColor(value.index);
                color.createCell(index).setCellStyle(fillForegroundColorStyle);
            }
        }

        response.setHeader("content-disposition", "attachment;filename=test.xlsx");
        ServletOutputStream outputStream = response.getOutputStream();
        try (table;outputStream) {
            table.write(outputStream);
        }
    }

}
