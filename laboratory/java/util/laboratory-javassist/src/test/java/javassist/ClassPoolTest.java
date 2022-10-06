package javassist;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

public class ClassPoolTest {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Test
    void test() throws NotFoundException {
        ClassPool classPool = ClassPool.getDefault();
        CtClass ctClass = classPool.get("java.lang.String");
        log.info(Arrays.toString(ctClass.getFields()));
    }

}
