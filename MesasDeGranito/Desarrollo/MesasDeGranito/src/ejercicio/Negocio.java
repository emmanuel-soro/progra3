package ejercicio;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

public class Negocio extends EjercicioOIA {

	private Mesada[] mesadas;
	private List<Mesada> listaBases;
	private final static String PATH_ENTRADA = "../../Preparacion de prueba/Lote de Prueba/Entrada/";
	private final static String PATH_SALIDA = "../../Ejecucion de prueba/Salida obtenida/";

	public Negocio(String entrada, String salida) throws FileNotFoundException {

		super(new File(PATH_ENTRADA + entrada), new File(PATH_SALIDA + salida));
		Scanner fileScanner = new Scanner(this.entrada);

		int lineas = fileScanner.nextInt();
		mesadas = new Mesada[lineas];
		listaBases = new ArrayList<>();

		for (int i = 0; i < lineas; i++) {
			mesadas[i] = new Mesada(fileScanner.nextInt(), fileScanner.nextInt());
		}

		fileScanner.close();

	}

	@Override
	public void resolver() {

		ordernarMesadas();
		
		boolean agrego;
		listaBases.add(mesadas[0]);
		for (int i = 1; i < mesadas.length; i++) {
			agrego = false;
			for (Mesada mesada : listaBases) {
				if (mesadas[i].getAncho() <= mesada.getAncho() && mesadas[i].getLargo() <= mesada.getLargo()
						|| mesadas[i].getAncho() <= mesada.getLargo()
								&& mesadas[i].getLargo() <= mesada.getAncho()) {

					break;
				}
				agrego = true;
			}
			if (agrego) {
				listaBases.add(mesadas[i]);
			}
			
		}

	

	FileWriter fw = null;
	PrintWriter pw = null;
	try
	{
		fw = new FileWriter(salida);
		pw = new PrintWriter(fw);
		// ----------------------------------------------------------------------------------
		pw.print(listaBases.size());
	}catch(
	IOException e)
	{
		e.printStackTrace();
	}finally
	{
		if (fw != null) {

			try {
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		pw.close();
	}

	}

	private void ordernarMesadas() {
		List<Mesada> list = Arrays.asList(mesadas);

		Collections.sort(list, new Comparator<Mesada>() {

			@Override
			public int compare(Mesada o1, Mesada o2) {

				return o2.getSuperficie() > o1.getSuperficie() ? 1 : o2.getSuperficie() == o1.getSuperficie() ? 0 : -1;
			}
		});
		
		mesadas = (Mesada[]) list.toArray();
	}

}
