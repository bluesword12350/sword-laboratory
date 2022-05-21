package top.bluesword.java.lang.enumtest;

public enum DemoEnum {
	ONE("一"),
	TWO("二"),;
	private String name;
	DemoEnum(String name) {
		this.name = name;
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
