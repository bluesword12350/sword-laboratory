package top.bluesword.java.grammar;

public class NewTest {
	public static void main(String[] args) {
		new A();
	}
}

class C {
    C() {
        System.out.println("Create C");
    }
}

class D {
    D() {
        System.out.println("Create D");
    }
}

class B{
	D c = new D();
	
	{
		System.out.println("run B");
	}
	
	static {
		System.out.println("Load B");
	}

	public B() {
		System.out.println("Create B");
	}
}

class A extends B {
	C c = new C();
	
	static {
		System.out.println("Load A");
	}
	
	{
		System.out.println("run A");
	}

	public A() {
		System.out.println("Create A");
	}
}