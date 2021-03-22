package smile.data.formula;

import org.junit.jupiter.api.Test;

public class FormulaTest {

    @Test
    void of(){
        Formula formula = Formula.of("y", "a", "b", "c");
        System.out.println(formula);
    }
}
