package top.bluesword.web.laboratory;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.streaming.SXSSFCell;
import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ZeroCopyHttpOutputMessage;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author 李林峰
 */
@RestController
@RequestMapping("export-excel")
public class ExportExcelService {

    @GetMapping
    public Mono<Void> get(ServerHttpResponse response) {
        SXSSFWorkbook colorTable = createColorTable();
        String fileName = "test.xlsx";
        return Mono.fromCallable(() -> outputFile(colorTable, fileName)).flatMap(file -> downloadFile(response, file, fileName));
    }

    private File outputFile(SXSSFWorkbook colorTable, String fileName) throws IOException {
        File file = new File(fileName);
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        try(colorTable;fileOutputStream) {
            colorTable.write(new FileOutputStream(file));
        }
        return file;
    }

    private Mono<Void> downloadFile(ServerHttpResponse response, File file, String fileName) {
        response.getHeaders().set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename="+fileName);
        return ((ZeroCopyHttpOutputMessage) response).writeWith(file, 0, file.length());
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
