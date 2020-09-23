package top.bluesword.web.laboratory.controller;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.TemplateExportParams;
import io.swagger.annotations.ApiOperation;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import top.bluesword.web.laboratory.bean.DataFragment;
import top.bluesword.web.laboratory.bean.DataModel;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.*;

/**
 * @author 李林峰
 */
@Controller
@RequestMapping("two-dimensional-list")
public class TwoDimensionalListController {

    private final Random random = new Random();

    @GetMapping("export-by-template")
    @ApiOperation("通过模板导出")
    public void exportTwoDimensionalList(HttpServletResponse response){
        try (
                InputStream inputStream = Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("templates/二维列表.xlsx"));
                Workbook book = WorkbookFactory.create(inputStream);
                ServletOutputStream outputStream = response.getOutputStream()
        ){
            TemplateExportParams params = new TemplateExportParams();
            params.setTemplateWb(book);
            response.setCharacterEncoding(StandardCharsets.UTF_8.displayName());
            response.setHeader("content-disposition", "attachment;filename=" + "test.xlsx");
            Map<String, Object> dataMap = new HashMap<>(1);
            dataMap.put("list",twoDimensionalList());
            ExcelExportUtil.exportExcel(params, dataMap).write(outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List<DataModel> twoDimensionalList() {
        List<DataModel> list = new ArrayList<>();
        list.add(randomDataModel());
        list.add(randomDataModel());
        list.add(randomDataModel());
        return list;
    }

    private DataModel randomDataModel() {
        DataModel dataModel = new DataModel();
        dataModel.setKey(String.valueOf(random.nextInt()));
        dataModel.setFragments(randomFragments());
        return dataModel;
    }

    private List<DataFragment> randomFragments() {
        List<DataFragment> list = new ArrayList<>();
        list.add(randomDataFragment());
        list.add(randomDataFragment());
        list.add(randomDataFragment());
        list.add(randomDataFragment());
        list.add(randomDataFragment());
        list.add(randomDataFragment());
        return list;
    }

    private DataFragment randomDataFragment() {
        DataFragment dataFragment = new DataFragment();
        dataFragment.setId(random.nextLong());
        return dataFragment;
    }

}
