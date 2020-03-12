package top.bluesword.java.lang.enumtest;

public enum DemoEnum {
	ONE(1,"一"),
	TWO(2,"二"),;
	private int index;
	private String name;
	private DemoEnum(int index,String name) {
		this.setIndex(index);
		this.setName(name);
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return name;
	}
}
