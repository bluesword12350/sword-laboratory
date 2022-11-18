package top.bluesword.laboratory.controller;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.TemplateExportParams;
import lombok.RequiredArgsConstructor;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import top.bluesword.laboratory.bean.DataGenerate;
import top.bluesword.laboratory.config.TemplateProperties;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author 李林峰
 */
@Controller
@RequestMapping("template")
@RequiredArgsConstructor
public class TemplateController {

    private final TemplateProperties templateProperties;

    @GetMapping("/exportExcelByExcelExportUtil")
    public void exportExcelByExcelExportUtil(HttpServletResponse response) {
        Map<String, Object> map = DataGenerate.generateMap();
        TemplateExportParams params = new TemplateExportParams(templateProperties.getUrl());
        Workbook workbook = ExcelExportUtil.exportExcel(params, map);
        response.setHeader("content-disposition", "attachment;filename=" + "测试文件.xlsx");
        try (ServletOutputStream outputStream = response.getOutputStream()){
            workbook.write(outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @GetMapping("/exportExcelByExcelExportUtilAndTemplateWb")
    public void exportExcelByExcelExportUtilAndTemplateWb(HttpServletResponse response) {
        try (
                InputStream inputStream = Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream(templateProperties.getUrl()));
                Workbook book = WorkbookFactory.create(inputStream);
                ServletOutputStream outputStream = response.getOutputStream()
        ){
            TemplateExportParams params = new TemplateExportParams();
            params.setTemplateWb(book);
            response.setHeader("content-disposition", "attachment;filename=" + "测试文件.xlsx");
            ExcelExportUtil.exportExcel(params, DataGenerate.generateMap()).write(outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @GetMapping("export-excel-controls")
    public void exportExcelControls(HttpServletResponse response){
        try (
                InputStream inputStream = Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("templates/控件测试.xlsx"));
                Workbook book = WorkbookFactory.create(inputStream);
                ServletOutputStream outputStream = response.getOutputStream()
        ){
            TemplateExportParams params = new TemplateExportParams();
            params.setTemplateWb(book);
            response.setCharacterEncoding(StandardCharsets.UTF_8.displayName());
            response.setHeader("content-disposition", "attachment;filename=" + "test.xlsx");
            Map<String, Object> dataMap = new HashMap<>(3);
            //控制复选框，使用0（不勾选），1（勾选）来控制 {{controlX?1:0}} (还未找到混合勾选的实现方案)
            dataMap.put("control0",false);
            dataMap.put("control1","#N/A");
            dataMap.put("control2",true);
            ExcelExportUtil.exportExcel(params, dataMap).write(outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
