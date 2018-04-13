package torneo;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class GeneradorCasosPrueba {

	public static void main(final String[] args) throws IOException {

		PrintWriter salida = new PrintWriter(new FileWriter("stress.in"));

		salida.println(100000);

		for (int i = 1; i <= 100000; i++) {
			salida.println(i + " " + i * 10);
		}

		salida.close();

	}

}
