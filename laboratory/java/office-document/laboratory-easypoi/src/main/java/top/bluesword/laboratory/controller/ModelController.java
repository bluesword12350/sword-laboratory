package top.bluesword.laboratory.controller;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.afterturn.easypoi.excel.entity.result.ExcelImportResult;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import top.bluesword.laboratory.bean.BaseExcelTemplate;
import top.bluesword.laboratory.bean.ExcelTemplate;
import top.bluesword.laboratory.bean.MergedCellExcelTemplate;

import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 李林峰
 */
@Controller
@RequestMapping("model")
public class ModelController {

	private final ObjectMapper objectMapper = new ObjectMapper();

	@PostMapping("importExcel")
    @ResponseBody
	public List<ExcelTemplate> importExcel(MultipartFile file) throws Exception {
		if (file.isEmpty()) {
			throw new RuntimeException("文件为空");
        }
		int max = 1024*1024;
		if (file.getSize()/(max)>1) {
			throw new RuntimeException("文件过大");
		}
		ImportParams params = new ImportParams();
		params.setTitleRows(0);
		params.setNeedVerify(false);
		ExcelImportResult<ExcelTemplate> importExcel;
		try (InputStream inputStream = file.getInputStream()) {
            importExcel = ExcelImportUtil.importExcelMore(inputStream, ExcelTemplate.class, params);
		}
		if (importExcel.isVerifyFail()) {
			throw new RuntimeException(objectMapper.writeValueAsString(importExcel.getFailList()));
		}else {
			return importExcel.getList();
		}
	}

	@PostMapping("import-merged-cell")
	@ResponseBody
	public String importMergedCell(MultipartFile file) throws Exception {
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

	@PostMapping("import-excel/exclude-blank-lines")
	@ResponseBody
	public String importExcelExcludeBlankLines(MultipartFile file){
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
			data = removeEmptyLine(importExcel);
			return objectMapper.writeValueAsString(data);
		} catch (Exception e1) {
			return e1.toString();
		}
	}

	private <T> List<T> removeEmptyLine(ExcelImportResult<T> importExcel) throws IllegalAccessException {
		List<T> data = new ArrayList<>();
		for (T o : importExcel.getList()) {
			boolean isNotEmptyLine = false;
			Field[] declaredFields = o.getClass().getDeclaredFields();
			for (Field declaredField : declaredFields) {
				if ("rowNum".equals(declaredField.getName())) {
					continue;
				}
				declaredField.setAccessible(true);
				Object value = declaredField.get(o);
				declaredField.setAccessible(false);
				if (!ObjectUtils.isEmpty(value)) {
					isNotEmptyLine = true;
					break;
				}
			}
			if (isNotEmptyLine) {
				data.add(o);
			}
		}
		return data;
	}

}
