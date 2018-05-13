package carrera;

public class Main {

	public static void main(String[] args) {

		

		Carrera carrera = new Carrera("01.in", "01.out");

		long startTime = System.nanoTime();
		carrera.resolver();
		long estimatedTime = System.nanoTime() - startTime;

		System.out.println("Metodo resolver demoró:" + estimatedTime + " nanosegundos.");

		Carrera carrera2 = new Carrera("01.in", "01-mejorado.out");

		startTime = System.nanoTime();
		carrera2.resolverMejorado();
		estimatedTime = System.nanoTime() - startTime;

		System.out.println("Metodo resolver mejorado demoró:" + estimatedTime + " nanosegundos.");
	}

}
