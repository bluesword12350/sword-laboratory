package org.apache.poi.xssf.streaming;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.util.CellRangeAddressList;
import org.apache.poi.xssf.usermodel.*;
import org.junit.jupiter.api.Test;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author 李林峰
 */
class SXSSFWorkbookTest {

    @Test
    void createColorTable() throws IOException {
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
        FileOutputStream fileOutputStream = new FileOutputStream("颜色卡.xlsx");
        try(table;fileOutputStream) {
            table.write(fileOutputStream);
        }
    }

}
