import java.util.*;
class A {
	public void doit() {
		System.out.println("I am A");
	}
}
class B extends A {
	
	public void doit() {
		System.out.println("I am B");
	}
}
class C extends B {

	public void doit() {
		System.out.println("I am C");
	}
}
public class Test {

	public static void main(String[] args) {
		A x = new B();
		x.doit();
	}
}
