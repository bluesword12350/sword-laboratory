package top.bluesword.web.laboratory.controller;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.ExcelXorHtmlUtil;
import cn.afterturn.easypoi.excel.entity.ExcelToHtmlParams;
import cn.afterturn.easypoi.excel.entity.TemplateExportParams;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import top.bluesword.web.laboratory.bean.DataGenerate;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * @author 李林峰
 */
@Controller
@RequestMapping("html")
public class HtmlController {

    @GetMapping("toHtml")
    public void toHtml(HttpServletResponse response) throws IOException {
        Map<String, Object> map = DataGenerate.generateMap();
        response.setHeader("content-disposition", "attachment;filename=" + "测试文件.xlsx");
        TemplateExportParams params = new TemplateExportParams("doc/test.xlsx");
        Workbook workbook = ExcelExportUtil.exportExcel(params, map);
        response.getOutputStream().write(ExcelXorHtmlUtil.excelToHtml(new ExcelToHtmlParams(workbook)).getBytes());
    }

}
