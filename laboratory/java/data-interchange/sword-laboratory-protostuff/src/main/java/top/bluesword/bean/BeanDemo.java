package top.bluesword.bean;

import lombok.Data;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

/**
 * @author 李林峰
 */
@Data
public class BeanDemo {

	private String string;

	private BigDecimal bigDecimal;

	private ZonedDateTime date;

	private InsideBeanDemo insideBeanDemo;

}