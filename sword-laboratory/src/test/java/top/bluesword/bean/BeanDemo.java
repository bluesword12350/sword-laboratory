package top.bluesword.bean;

/**
 * @author 李林峰
 */
public class BeanDemo {

	public String string;

	private InsideBeanDemo insideBeanDemo;

	public BeanDemo() {
	}

	public InsideBeanDemo getInsideBeanDemo() {
		return insideBeanDemo;
	}

	public void setInsideBeanDemo(InsideBeanDemo insideBeanDemo) {
		this.insideBeanDemo = insideBeanDemo;
	}
}