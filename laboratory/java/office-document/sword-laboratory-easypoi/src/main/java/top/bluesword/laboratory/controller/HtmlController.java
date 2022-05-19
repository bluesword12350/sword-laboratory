package top.bluesword.laboratory.controller;

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
import top.bluesword.laboratory.bean.User;
import top.bluesword.laboratory.config.TemplateProperties;
import top.bluesword.laboratory.bean.DataGenerate;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author 李林峰
 */
@Controller
@RequestMapping("html")
public class HtmlController {

    @Autowired
    TemplateProperties templateProperties;

    @GetMapping("excelToHtml")
    public void toHtml(HttpServletResponse response) throws IOException {
        Map<String, Object> map = DataGenerate.generateMap();
        TemplateExportParams params = new TemplateExportParams(templateProperties.getUrl());
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
        List<User> users = getUsers();
        context.setVariable("users", users);
        String result = templateEngine.process("excelTemplate", context);
        try(Workbook workbook = ExcelXorHtmlUtil.htmlToExcel(result, ExcelType.XSSF);
            ServletOutputStream outputStream = response.getOutputStream()) {
            response.setHeader("content-disposition", "attachment;filename=test.xlsx");
            workbook.write(outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List<User> getUsers() {
        List<User> users = new ArrayList<>();
        users.add(User.builder().name("u1").level("super admin").build());
        users.add(User.builder().name("u2").level("admin").build());
        users.add(User.builder().name("u3").build());
        users.add(User.builder().name("u4").level("member").createDate(System.currentTimeMillis()).build());
        return users;
    }

}