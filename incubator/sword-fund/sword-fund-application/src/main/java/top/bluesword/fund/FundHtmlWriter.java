package top.bluesword.fund;

import top.bluesword.fund.fund.Fund;

import java.io.IOException;
import java.util.List;

/**
 * @author 李林峰
 */
public interface FundHtmlWriter {
    void write(List<Fund> funds, String fileName) throws IOException;

    void write(List<Fund> funds, String fileName, boolean showSellTime) throws IOException;
}
