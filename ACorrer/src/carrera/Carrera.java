package carrera;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Carrera {

	private Categoria[] categoriasFemeninas;
	private Categoria[] categoriasMasculinas;
	private String salida;
	private Competidor[] competidores;
	private int[] finalistas;

	private Carrera(String entrada, String salida) {

		this.salida = salida;
		int cantCompetidoresFinalistas;

		Scanner fileScanner = null;

		try {
			fileScanner = new Scanner(new File(entrada));

			this.competidores = new Competidor[fileScanner.nextInt()];
			this.categoriasFemeninas = new Categoria[fileScanner.nextInt()];
			this.categoriasMasculinas = new Categoria[fileScanner.nextInt()];
			this.finalistas = new int[fileScanner.nextInt()];

			for (int i = 0; i < this.categoriasFemeninas.length; i++) {
				this.categoriasFemeninas[i] = new Categoria(fileScanner.nextInt(), fileScanner.nextInt());
			}

			for (int i = 0; i < this.categoriasMasculinas.length; i++) {
				this.categoriasMasculinas[i] = new Categoria(fileScanner.nextInt(), fileScanner.nextInt());
			}

			for (int i = 0; i < this.competidores.length; i++) {
				this.competidores[i] = new Competidor(fileScanner.nextInt(), fileScanner.next());
			}

			for (int i = 0; i < this.finalistas.length; i++) {
				this.finalistas[i] = fileScanner.nextInt();
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			fileScanner.close();
		}

	}

}
