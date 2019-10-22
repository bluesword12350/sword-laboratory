package top.bluesword.web.laboratory.controller;

import cn.afterturn.easypoi.entity.vo.TemplateExcelConstants;
import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.TemplateExportParams;
import cn.afterturn.easypoi.view.PoiBaseView;
import io.swagger.annotations.ApiOperation;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import top.bluesword.web.laboratory.bean.DataGenerate;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * @author 李林峰
 */
@Controller
@RequestMapping("template")
public class TemplateController {

    @RequestMapping("/exportExcelByPoiBaseView")
    @ApiOperation("模板导出")
    public void exportExcelByPoiBaseView(HttpServletRequest request, HttpServletResponse response) {
        ModelMap modelMap = new ModelMap();
        TemplateExportParams params = new TemplateExportParams("doc/test.xlsx");
        Map<String, Object> map = DataGenerate.generateMap();
        modelMap.put(TemplateExcelConstants.FILE_NAME, "test");
        modelMap.put(TemplateExcelConstants.PARAMS, params);
        modelMap.put(TemplateExcelConstants.MAP_DATA, map);
        PoiBaseView.render(modelMap, request, response,
                TemplateExcelConstants.EASYPOI_TEMPLATE_EXCEL_VIEW);
    }

    @RequestMapping("/exportExcelByExcelExportUtil")
    @ApiOperation("Util模板导出")
    public void exportExcelByExcelExportUtil(HttpServletResponse response) {
        Map<String, Object> map = DataGenerate.generateMap();
        response.setHeader("content-disposition", "attachment;filename=" + "测试文件.xlsx");
        TemplateExportParams params = new TemplateExportParams("doc/test.xlsx");
        Workbook workbook = ExcelExportUtil.exportExcel(params, map);
        try (ServletOutputStream outputStream = response.getOutputStream()){
            workbook.write(outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
