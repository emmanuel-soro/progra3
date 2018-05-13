package carrera;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class Carrera {

	private Categoria[] categoriasFemeninas;
	private Categoria[] categoriasMasculinas;
	private String salida;
	private Competidor[] competidores;
	private int[] finalistas;

	public Carrera(String entrada, String salida) {

		this.salida = salida;

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

	public void resolver() {

		for (int i = 0; i < competidores.length; i++) {

			if (competidores[i].getSexo().equals("F")) {

				for (int j = 0; j < this.categoriasFemeninas.length; j++) {

					if (competidores[i].getEdad() >= categoriasFemeninas[j].getEdadMinina()
							&& competidores[i].getEdad() < categoriasFemeninas[j].getEdadMaxima() + 1) {
						competidores[i].setCategoria(categoriasFemeninas[j]);
						break;
					}
				}

			} else {
				for (int j = 0; j < this.categoriasMasculinas.length; j++) {

					if (competidores[i].getEdad() >= categoriasMasculinas[j].getEdadMinina()
							&& competidores[i].getEdad() < categoriasMasculinas[j].getEdadMaxima() + 1) {
						competidores[i].setCategoria(categoriasMasculinas[j]);
						break;
					}
				}
			}
		}

		for (int i = 0; i < this.finalistas.length; i++) {
			int participante = this.finalistas[i];

			int[] podio = this.competidores[participante - 1].getCategoria().getPodio();

			if (podio[2] != 0) {
				continue;
			}

			for (int j = 0; j < podio.length; j++) {

				if (podio[j] == 0) {
					podio[j] = participante;
					break;
				}
			}
		}

		try (FileWriter fw = new FileWriter(new File(this.salida)); PrintWriter pw = new PrintWriter(fw);) {

			for (int i = 0; i < categoriasFemeninas.length; i++) {
				Categoria cat = categoriasFemeninas[i];
				pw.println((i + 1) + " " + cat.getPodio()[0] + " " + cat.getPodio()[1] + " " + cat.getPodio()[2]);
			}

			for (int i = 0; i < categoriasMasculinas.length; i++) {
				Categoria cat = categoriasMasculinas[i];
				pw.println((i + 1) + " " + cat.getPodio()[0] + " " + cat.getPodio()[1] + " " + cat.getPodio()[2]);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
