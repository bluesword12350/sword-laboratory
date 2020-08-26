package top.bluesword.web.laboratory.controller;

import cn.afterturn.easypoi.entity.vo.TemplateExcelConstants;
import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.TemplateExportParams;
import cn.afterturn.easypoi.view.PoiBaseView;
import io.swagger.annotations.ApiOperation;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import top.bluesword.web.laboratory.bean.DataGenerate;
import top.bluesword.web.laboratory.config.TemplateProperties;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author 李林峰
 */
@Controller
@RequestMapping("template")
public class TemplateController {

    @Autowired
    TemplateProperties templateProperties;

    @GetMapping("/exportExcelByPoiBaseView")
    @ApiOperation("模板导出")
    public void exportExcelByPoiBaseView(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> modelMap = new HashMap<>(5);
        TemplateExportParams params = new TemplateExportParams(templateProperties.getUrl());
        Map<String, Object> map = DataGenerate.generateMap();
        modelMap.put(TemplateExcelConstants.FILE_NAME, "test");
        modelMap.put(TemplateExcelConstants.PARAMS, params);
        modelMap.put(TemplateExcelConstants.MAP_DATA, map);
        PoiBaseView.render(modelMap, request, response,
                TemplateExcelConstants.EASYPOI_TEMPLATE_EXCEL_VIEW);
    }

    @GetMapping("/exportExcelByExcelExportUtil")
    @ApiOperation("Util模板导出")
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
    @ApiOperation("Util模板流导出")
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

}
