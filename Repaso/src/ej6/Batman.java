package ej6;

public class Batman {
	int squares = 81;

	void go() {
		incr(++squares);
		System.out.println(squares);
	}

	void incr(int squares) {
		squares += 10;
	}
	
	public static void main(String[] args) {
		new Batman().go();
	}
}
