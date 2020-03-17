package top.bluesword.component;

import com.alibaba.fastjson.JSON;
import lombok.Builder;
import lombok.Data;

/**
 * @author 李林峰
 */
@Data
@Builder
public class LiBaiStatistic {

    Integer storehouse;

    Integer enjoy;

    Integer shelve;

    Integer all;

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
