package generadorPrueba;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Random;

public class Generador {

	public static void generarCasoAleatorio(int cantMesadas,String archivoSalida) {

		Random r = new Random();

		try (FileWriter fw = new FileWriter(new File(archivoSalida)); PrintWriter pw = new PrintWriter(fw);) {

			pw.println(cantMesadas);

			int largoMinimo = 1;
			int largoMaximo = 1000000;

			for (int i = 0; i < cantMesadas; i++) {
				int largo = r.nextInt(largoMaximo - largoMinimo);
				int ancho = r.nextInt(largoMaximo - largoMinimo);
				pw.println(ancho + " " + largo);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
