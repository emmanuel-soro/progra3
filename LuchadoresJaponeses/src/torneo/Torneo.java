package torneo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Torneo {

	private String path;
	// private List<Luchador> luchadores;
	private Luchador[] luchadores;
	private int[] resultados;

	public Torneo(String path) throws FileNotFoundException {
		this.path = path;
		Scanner sc = new Scanner(new File(this.path));
		int cantidadLuchadores = sc.nextInt();

		luchadores = new Luchador[cantidadLuchadores];
		resultados = new int[cantidadLuchadores];

		// List<Luchador> luchadores = new ArrayList<Luchador>(0);
		
		for (int i = 0; i < luchadores.length; i++) {
			luchadores[i] = new Luchador(sc.nextDouble(), sc.nextDouble());
		}
		sc.close();

	}

	public void resolver() throws IOException {

		long startTime = System.currentTimeMillis();

		String[] pathSalida = this.path.split(".in");

		PrintWriter salida = new PrintWriter(new FileWriter(pathSalida[0] + ".out"));

		// TODO: optimizar recorriendo la mitad de la lista
		
		for (int i = 0; i < this.luchadores.length; i++) {
			//Integer totalDominado = 0;
			
			if(this.luchadores[i].domina(this.luchadores[this.luchadores.length - i -1])) {
				resultados[i]+=1;
			}else if(this.luchadores[this.luchadores.length - i - 1].domina(this.luchadores[i])) {
				resultados[this.luchadores.length - i -1] += 1;
			}
		}
		
		
//		for (Luchador luchador : luchadores) {
//			Integer totalDominado = 0;
//
//			for (Luchador otroLuchador : luchadores) {
//
//				if (luchador.equals(otroLuchador)) {
//					continue;
//				}
//
//				if (luchador.domina(otroLuchador)) {
//					totalDominado++;
//				}
//
//				
//			}
//
//		}

		for (int i = 0; i < resultados.length; i++) {
			salida.println(resultados[i]);
		}
		
		salida.close();

		long stopTime = System.currentTimeMillis();
		long elapsedTime = stopTime - startTime;

		String time = String.format("%d min, %d sec", TimeUnit.MILLISECONDS.toMinutes(elapsedTime),
				TimeUnit.MILLISECONDS.toSeconds(elapsedTime)
						- TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(elapsedTime)));

		System.out.println("Done! Duration:" + time);

	}

}
