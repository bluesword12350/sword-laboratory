package top.bluesword.web.laboratory.controller;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.ExcelXorHtmlUtil;
import cn.afterturn.easypoi.excel.entity.ExcelToHtmlParams;
import cn.afterturn.easypoi.excel.entity.TemplateExportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import top.bluesword.web.laboratory.bean.DataGenerate;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

/**
 * @author 李林峰
 */
@Controller
@RequestMapping("html")
public class HtmlController {

    @GetMapping("excelToHtml")
    public void toHtml(HttpServletResponse response) throws IOException {
        Map<String, Object> map = DataGenerate.generateMap();
        TemplateExportParams params = new TemplateExportParams("doc/test.xlsx");
        Workbook workbook = ExcelExportUtil.exportExcel(params, map);
        response.getOutputStream().write(ExcelXorHtmlUtil.excelToHtml(new ExcelToHtmlParams(workbook)).getBytes());
    }

    @GetMapping("htmlToExcel")
    public void htmlToExcel(HttpServletResponse response) {
        try(InputStream resourceAsStream = getClass().getResourceAsStream("/html/sample.html");
            Workbook workbook = ExcelXorHtmlUtil.htmlToExcel(resourceAsStream, ExcelType.XSSF);
            ServletOutputStream outputStream = response.getOutputStream()) {
            response.setHeader("content-disposition", "attachment;filename=test.xlsx");
            workbook.write(outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Autowired
    TemplateEngine templateEngine;

    @GetMapping("htmlToExcelByThymeleaf")
    public void htmlToExcelByThymeleaf(HttpServletResponse response) {
        Context context = new Context();
        List<String> users = List.of("user1", "user5");
        context.setVariable("usernameList", users);
        String result = templateEngine.process("excelTemplate", context);
        try(Workbook workbook = ExcelXorHtmlUtil.htmlToExcel(result, ExcelType.XSSF);
            ServletOutputStream outputStream = response.getOutputStream()) {
            response.setHeader("content-disposition", "attachment;filename=test.xlsx");
            workbook.write(outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
