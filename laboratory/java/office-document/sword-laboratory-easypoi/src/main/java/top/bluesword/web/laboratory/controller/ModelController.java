package top.bluesword.web.laboratory.controller;

import cn.afterturn.easypoi.entity.vo.NormalExcelConstants;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.afterturn.easypoi.excel.entity.result.ExcelImportResult;
import cn.afterturn.easypoi.view.PoiBaseView;
import com.alibaba.fastjson.JSON;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import top.bluesword.web.laboratory.bean.DataGenerate;
import top.bluesword.web.laboratory.bean.ExcelTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;

/**
 * @author 李林峰
 */
@Controller
@Api(tags = "easyPoi测试接口")
@RequestMapping("model")
public class ModelController {
	
	@PostMapping("importExcel")
	@ApiOperation("最简导入")
    @ResponseBody
	public String importExcel(@ApiParam(required = true) MultipartFile file){
		if (file.isEmpty()) {
            return "文件为空";
        }
		int max = 1024*1024;
		if (file.getSize()/(max)>1) {
			return "文件过大";
		}
		try (InputStream inputStream = file.getInputStream()) {
			ImportParams params = new ImportParams();
			params.setTitleRows(1);
			params.setNeedVerify(true);
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
	
	@GetMapping("/exportExcel")
	@ApiOperation("最简导出")
	public void exportExcelByBean(ModelMap map,HttpServletRequest request,HttpServletResponse response){
		ExportParams params = new ExportParams("测试导出表格","表格1");
        map.put(NormalExcelConstants.DATA_LIST, DataGenerate.generateList());
        map.put(NormalExcelConstants.CLASS, ExcelTemplate.class);
        map.put(NormalExcelConstants.PARAMS, params);
        map.put(NormalExcelConstants.FILE_NAME, "test");
        PoiBaseView.render(map, request, response, NormalExcelConstants.EASYPOI_EXCEL_VIEW);
	}

}
