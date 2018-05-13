package carrera;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class Carrera {

	private Categoria[] categoriasFemeninas;
	private Categoria[] categoriasMasculinas;
	private String archivoSalida;
	private Competidor[] competidores;
	private int[] finalistas;

	public Carrera(String entrada) {

		this.archivoSalida = entrada.replaceFirst(".in", ".out");

		Scanner fileScanner = null;
		entrada = "aCorrer/" + entrada;
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
				this.competidores[i] = new Competidor(fileScanner.nextInt(), fileScanner.next().charAt(0));
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

		asignarCompetidoresCategorias();

		armarPodiosPorCategoria();

		escribirSalida();
	}

	private void asignarCompetidoresCategorias() {
		for (int i = 0; i < competidores.length; i++) {

			if (competidores[i].getSexo() == 'F') {

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
	}

	/**
	 * Siendo n competiores, m categorias masculinas/femeninas
	 *
	 * Complejidad O(f(n*(log m)))
	 */
	public void resolverMejorado() {

		asignarCompetidoresCategoriasBusquedaBinaria();
		armarPodiosPorCategoria();

		escribirSalida();
	}

	private void escribirSalida() {
		try (FileWriter fw = new FileWriter(new File("aCorrer/"+this.archivoSalida)); PrintWriter pw = new PrintWriter(fw);) {

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

	private void armarPodiosPorCategoria() {
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
	}

	private void asignarCompetidoresCategoriasBusquedaBinaria() {
		for (int i = 0; i < competidores.length; i++) {													//O(f(n))

			if (competidores[i].getSexo() == 'F') {

				Categoria categoria = busquedaBinaria(categoriasFemeninas, competidores[i]);	//O(f(log m))
				competidores[i].setCategoria(categoria);

			} else {

				Categoria categoria = busquedaBinaria(categoriasMasculinas, competidores[i]);	//O(f(log m))
				competidores[i].setCategoria(categoria);

			}
		}
	}

	private Categoria busquedaBinaria(Categoria categorias[], Competidor competidor) {
		int n = categorias.length;
		int centro;
		int inf = 0;
		int sup = n - 1;

		while (inf <= sup) {
			centro = (sup + inf) / 2;

			if (competidor.getEdad() >= categorias[centro].getEdadMinina()
					&& competidor.getEdad() < categorias[centro].getEdadMaxima() + 1) {
				return categorias[centro];
			} else if (competidor.getEdad() < categorias[centro].getEdadMinina()) {
				sup = centro - 1;
			} else {
				inf = centro + 1;
			}
		}

		return null;
	}

}
