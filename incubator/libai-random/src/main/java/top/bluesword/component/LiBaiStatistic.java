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

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
