package top.bluesword.laboratory;

import java.util.Comparator;
import java.util.Objects;

/**
 * @author 李林峰
 */
public class YieldComparator implements Comparator<Fund> {

    @Override
    public int compare(Fund o1, Fund o2) {
        Double yield1 = o1.getYield();
        yield1 = Objects.isNull(yield1) ? 0 : yield1;
        Double yield2 = o2.getYield();
        yield2 = Objects.isNull(yield2) ? 0 : yield2;
        if (yield1 > yield2) {
            return -1;
        } else if (yield1.equals(yield2)) {
            return 0;
        } else {
            return 1;
        }
    }

}
