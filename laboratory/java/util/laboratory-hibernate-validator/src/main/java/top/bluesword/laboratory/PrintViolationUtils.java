package top.bluesword.laboratory;

import lombok.extern.slf4j.Slf4j;

import javax.validation.ConstraintViolation;
import java.util.Set;

/**
 * @author 李林峰
 */
@Slf4j
public class PrintViolationUtils {

    public static <T> void print(Set<ConstraintViolation<T>> vm) {
        for (ConstraintViolation<T> constraintViolation : vm) {
            log.error("{}:{}", constraintViolation.getPropertyPath(), constraintViolation.getMessage());
        }
    }

}
