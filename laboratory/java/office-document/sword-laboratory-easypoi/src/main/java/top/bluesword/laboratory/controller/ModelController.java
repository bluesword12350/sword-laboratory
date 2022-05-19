package top.bluesword.laboratory.controller;

import cn.afterturn.easypoi.entity.vo.NormalExcelConstants;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.afterturn.easypoi.excel.entity.result.ExcelImportResult;
import cn.afterturn.easypoi.view.PoiBaseView;
import com.fasterxml.jackson.databind.ObjectMapper;
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
import top.bluesword.laboratory.bean.BaseExcelTemplate;
import top.bluesword.laboratory.bean.DataGenerate;
import top.bluesword.laboratory.bean.ExcelTemplate;
import top.bluesword.laboratory.bean.MergedCellExcelTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.util.List;

/**
 * @author 李林峰
 */
@Controller
@Api(tags = "easyPoi测试接口")
@RequestMapping("model")
public class ModelController {

	private final ObjectMapper objectMapper = new ObjectMapper();

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
            if (importExcel.isVerifyFail()) {
				return objectMapper.writeValueAsString(importExcel.getFailList());
			}else {
				return objectMapper.writeValueAsString(importExcel.getList());
			}
		} catch (Exception e1) {
			return e1.toString();
		}
	}

	@PostMapping("import-merged-cell")
	@ApiOperation("合并单元格导入")
	@ResponseBody
	public String importMergedCell(@ApiParam(required = true) MultipartFile file) throws Exception {
		if (file.isEmpty()) {
			return "文件为空";
		}
		int max = 1024*1024;
		if (file.getSize() > max) {
			return "文件过大";
		}
		try (InputStream inputStream = file.getInputStream()) {
			ImportParams params = new ImportParams();
			params.setTitleRows(0);
			params.setNeedVerify(true);
			ExcelImportResult<ExcelTemplate> importExcel = ExcelImportUtil.importExcelMore(inputStream, MergedCellExcelTemplate.class, params);
			if (importExcel.isVerifyFail()) {
				return objectMapper.writeValueAsString(importExcel.getFailList());
			}else {
				return objectMapper.writeValueAsString(importExcel.getList());
			}
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

	@PostMapping("import-excel/exclude-blank-lines")
	@ApiOperation("过滤空白行导入")
	@ResponseBody
	public String importExcelExcludeBlankLines(@ApiParam(required = true) MultipartFile file){
		if (file.isEmpty()) {
			return "文件为空";
		}
		int max = 1024*1024;
		if (file.getSize()/(max)>1) {
			return "文件过大";
		}
		List<?> data;
		try (InputStream inputStream = file.getInputStream()) {
			ImportParams params = new ImportParams();
			params.setTitleRows(0);
			params.setStartRows(0);
			ExcelImportResult<?> importExcel = ExcelImportUtil.importExcelMore(inputStream, BaseExcelTemplate.class, params);
			data = importExcel.getList();
			return objectMapper.writeValueAsString(data);
		} catch (Exception e1) {
			return e1.toString();
		}
	}

}
