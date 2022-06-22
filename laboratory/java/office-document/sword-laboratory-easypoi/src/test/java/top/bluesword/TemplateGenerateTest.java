package top.bluesword;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.jupiter.api.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.stream.IntStream;

class TemplateGenerateTest {

    @Test
    void generate() throws IOException {
        String[] titles = new String[]{"编号","名称","样式","日期","时间戳","三目","内部参数"};
        String[] row1 = new String[]{"{{fe:list t.id","t.name","t.style","fd:(t.date;yyyy-MM-dd)","fd:(t.timestamp;yyyy-MM-dd)","t.isNew ? '是':'否'","t.ex.name}}"};

        FileOutputStream outputStream = new FileOutputStream("test.xlsx");
        XSSFWorkbook table = new XSSFWorkbook();
        XSSFSheet sheet = table.createSheet("Sheet1");

        CellRangeAddress cra=new CellRangeAddress(0, 0, 0,5);
        sheet.addMergedRegion(cra);
        int rowIndex = 0;
        Row row = sheet.createRow(rowIndex++);
        Cell cell = row.createCell(0);
        cell.setCellValue("测试导出模板");
        XSSFRow titleRow = sheet.createRow(rowIndex++);
        XSSFRow valueRow = sheet.createRow(rowIndex);
        IntStream.range(0, titles.length).forEach(i -> titleRow.createCell(i).setCellValue(titles[i]));
        IntStream.range(0, row1.length).forEach(i -> valueRow.createCell(i).setCellValue(row1[i]));
        try (table;outputStream) {
            table.write(outputStream);
        }
    }
}
