package top.bluesword.laboratory.excel;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.streaming.SXSSFCell;
import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 李林峰
 */
@RestController
@RequestMapping("excel/export")
public class ExportExcelController {

    @GetMapping
    public void get(HttpServletResponse response) throws IOException {
        SXSSFWorkbook colorTable = createColorTable();
        String fileName = "test.xlsx";
        downloadFile(response, colorTable, fileName);
    }

    private void downloadFile(HttpServletResponse response, SXSSFWorkbook workbook, String fileName) throws IOException {
        response.setHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename="+fileName);
        ServletOutputStream outputStream = response.getOutputStream();
        try(outputStream;workbook) {
            workbook.write(outputStream);
        }
    }

    public static SXSSFWorkbook createColorTable() {
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
        return table;
    }

}
