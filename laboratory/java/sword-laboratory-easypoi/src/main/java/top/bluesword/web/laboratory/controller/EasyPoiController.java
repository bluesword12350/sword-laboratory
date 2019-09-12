package top.bluesword.web.laboratory.controller;

import cn.afterturn.easypoi.entity.vo.NormalExcelConstants;
import cn.afterturn.easypoi.entity.vo.TemplateExcelConstants;
import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.afterturn.easypoi.excel.entity.TemplateExportParams;
import cn.afterturn.easypoi.excel.entity.result.ExcelImportResult;
import cn.afterturn.easypoi.view.PoiBaseView;
import com.alibaba.fastjson.JSON;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import top.bluesword.web.laboratory.bean.ExcelTemplate;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/**
 * @author 李林峰
 */
@Controller
@Api(tags = "easyPoi测试接口")
public class EasyPoiController {
	
	@PostMapping("importExcel")
	@ApiOperation("最简导入")
    @ResponseBody
	public String importExcel(@ApiParam(required = true) MultipartFile file){
		if (file.isEmpty()) {
            return "文件为空";
        }
		if (file.getSize()/(1024*1024)>1) {
			return "文件过大";
		}
		try (InputStream inputStream = file.getInputStream()) {
			ImportParams params = new ImportParams();
			params.setTitleRows(0);
			params.setNeedVerfiy(true);
            ExcelImportResult<ExcelTemplate> importExcel = ExcelImportUtil.importExcelMore(inputStream, ExcelTemplate.class, params);
            if (importExcel.isVerfiyFail()) {
				return JSON.toJSONString(importExcel.getFailList());
			}else {
				return JSON.toJSONString(importExcel.getList());
			}
		} catch (Exception e1) {
			return e1.toString();
		}
	}
	
	@RequestMapping("/exportExcel")
	@ApiOperation("最简导出")
    @ResponseBody
	public void exportExcelByBean(ModelMap map,HttpServletRequest request,HttpServletResponse response){
		ExportParams params = new ExportParams("测试导出表格","表格1");
        params.setFreezeCol(2);
        map.put(NormalExcelConstants.DATA_LIST, new ArrayList<ExcelTemplate>());
        map.put(NormalExcelConstants.CLASS, ExcelTemplate.class);
        map.put(NormalExcelConstants.PARAMS, params);
        map.put(NormalExcelConstants.FILE_NAME, "测试导出表格");
        PoiBaseView.render(map, request, response, NormalExcelConstants.EASYPOI_EXCEL_VIEW);
	}
	
	@RequestMapping("/exportExcelByTemplate")
	@ApiOperation("模板导出")
	public void exportExcelByTemplate(HttpServletRequest request, HttpServletResponse response) {
        ModelMap modelMap = new ModelMap();
        TemplateExportParams params = new TemplateExportParams("doc/test.xlsx");
        Map<String, Object> map = generateData();
        modelMap.put(TemplateExcelConstants.FILE_NAME, "用戶信息");
        modelMap.put(TemplateExcelConstants.PARAMS, params);
        modelMap.put(TemplateExcelConstants.MAP_DATA, map);
        PoiBaseView.render(modelMap, request, response,
            TemplateExcelConstants.EASYPOI_TEMPLATE_EXCEL_VIEW);
	}

	@RequestMapping("/exportExcelByTemplate2")
	@ApiOperation("模板导出2")
	public void exportExcelByTemplate2(HttpServletResponse response) {
        Map<String, Object> map = generateData();
        response.setHeader("content-disposition", "attachment;filename=" + "测试文件.xlsx");
        TemplateExportParams params = new TemplateExportParams("doc/test.xlsx");
        Workbook workbook = ExcelExportUtil.exportExcel(params, map);
        try (ServletOutputStream outputStream = response.getOutputStream()){
            workbook.write(outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Map<String, Object> generateData() {
        Map<String, Object> map = new HashMap<>(1);
        List<ExcelTemplate> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add(new ExcelTemplate(i, UUID.randomUUID().toString()));
        }
        map.put("list", list);
        return map;
    }
}
