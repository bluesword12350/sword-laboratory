package top.bluesword.laboratory;

import java.util.LinkedHashMap;

/**
 * @author 李林峰
 */
public class FundMap extends LinkedHashMap<String,Fund> {

    public void add(Fund fund) {
        put(fund.getCode(),fund);
    }

}
