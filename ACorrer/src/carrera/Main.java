package carrera;

public class Main {

	public static void main(String[] args) {

		Carrera carrera = new Carrera("01.in", "01.out");

		long startTime = System.nanoTime();
		carrera.resolver();
		long estimatedTime = System.nanoTime() - startTime;

		System.out.println("Metodo resolver demoró:" + estimatedTime + " nanosegundos.");

		carrera = new Carrera("02.in", "02.out");

		startTime = System.nanoTime();
		carrera.resolver();
		estimatedTime = System.nanoTime() - startTime;

		System.out.println("Metodo resolver demoró:" + estimatedTime + " nanosegundos.");

		carrera = new Carrera("03.in", "03.out");

		startTime = System.nanoTime();
		carrera.resolver();
		estimatedTime = System.nanoTime() - startTime;

		System.out.println("Metodo resolver demoró:" + estimatedTime + " nanosegundos.");

		carrera = new Carrera("04.in", "04.out");

		startTime = System.nanoTime();
		carrera.resolver();
		estimatedTime = System.nanoTime() - startTime;

		System.out.println("Metodo resolver demoró:" + estimatedTime + " nanosegundos.");

		carrera = new Carrera("05.in", "05.out");

		startTime = System.nanoTime();
		carrera.resolver();
		estimatedTime = System.nanoTime() - startTime;

		System.out.println("Metodo resolver demoró:" + estimatedTime + " nanosegundos.");

		carrera = new Carrera("06.in", "06.out");

		startTime = System.nanoTime();
		carrera.resolver();
		estimatedTime = System.nanoTime() - startTime;

		System.out.println("Metodo resolver demoró:" + estimatedTime + " nanosegundos.");

		carrera = new Carrera("07.in", "07.out");

		startTime = System.nanoTime();
		carrera.resolver();
		estimatedTime = System.nanoTime() - startTime;

		System.out.println("Metodo resolver demoró:" + estimatedTime + " nanosegundos.");

		carrera = new Carrera("08.in", "08.out");

		startTime = System.nanoTime();
		carrera.resolver();
		estimatedTime = System.nanoTime() - startTime;

		System.out.println("Metodo resolver demoró:" + estimatedTime + " nanosegundos.");

		carrera = new Carrera("09.in", "09.out");

		startTime = System.nanoTime();
		carrera.resolver();
		estimatedTime = System.nanoTime() - startTime;

		System.out.println("Metodo resolver demoró:" + estimatedTime + " nanosegundos.");

		carrera = new Carrera("10.in", "10.out");

		startTime = System.nanoTime();
		carrera.resolver();
		estimatedTime = System.nanoTime() - startTime;

		System.out.println("Metodo resolver demoró:" + estimatedTime + " nanosegundos.");

		carrera = new Carrera("11.in", "11.out");

		startTime = System.nanoTime();
		carrera.resolver();
		estimatedTime = System.nanoTime() - startTime;

		System.out.println("Metodo resolver demoró:" + estimatedTime + " nanosegundos.");

	}

}
