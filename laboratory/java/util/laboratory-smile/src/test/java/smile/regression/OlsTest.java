package smile.regression;

import org.junit.jupiter.api.Test;
import smile.data.DataFrame;
import smile.data.formula.Formula;

class OlsTest {

    @Test
    void fit(){
        Formula formula = Formula.of("y", "a", "b", "c");
        int[][] ints = {{14, 1, 2, 3}, {46, 5, 7, 9}, {34, 7, 6, 5}, {38, 9, 4, 7},{40,4,6,8}};
        DataFrame dataFrame = DataFrame.of(ints, "y", "a", "b", "c");
        LinearModel linearModel = OLS.fit(formula, dataFrame);
        System.out.println(linearModel.formula());
    }

}
