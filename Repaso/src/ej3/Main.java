package ej3;

public class Main {

	public static void main(String[] args) {
		Alpha a = new Beta();
		Beta b = (Beta) a;
		a.foo();
		b.foo();
	}
}
