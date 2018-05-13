package generadorPrueba;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Random;

import carrera.Categoria;

public class Generador {

	public static void generarCasoAleatorio(int competidores, int categoriasFemeninas, int categoriasMasculinas,
			int finalistas, String archivoSalida) {

		Random r = new Random();

		try (FileWriter fw = new FileWriter(new File(archivoSalida)); PrintWriter pw = new PrintWriter(fw);) {

			pw.println(competidores + " " + categoriasFemeninas + " " + categoriasMasculinas + " " + finalistas);

			int edadMinima = 10;
			// int edadMaxima = 80;
			int topeEdadCategoria;

			topeEdadCategoria = edadMinima;

			for (int i = 0; i < categoriasFemeninas; i++) {

				pw.println(edadMinima + " " + topeEdadCategoria);
				edadMinima = topeEdadCategoria + 1;
				topeEdadCategoria = edadMinima ;
			}

			edadMinima = 10;
			topeEdadCategoria = edadMinima;

			for (int i = 0; i < categoriasMasculinas; i++) {
				pw.println(edadMinima + " " + topeEdadCategoria);
				edadMinima = topeEdadCategoria + 1;
				topeEdadCategoria = edadMinima ;
			}

			for (int i = 0; i < competidores; i++) {
				int edad = r.nextInt(69 - 10) + 10;
				String sexo = r.nextBoolean() ? "F" : "M";

				pw.println(edad + " " + sexo);
			}

			for (int i = 0; i < competidores; i++) {
				pw.println(i + 1);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
