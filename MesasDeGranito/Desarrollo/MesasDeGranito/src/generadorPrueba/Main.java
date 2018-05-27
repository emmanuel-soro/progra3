package generadorPrueba;

import ejercicio.Negocio;

public class Main {

	public static void main(String[] args) {

		// Generador.generarCasoAleatorio(200000, "stress.in");
		Generador.generarCasoEstres(Negocio.PATH_SALIDA + "caso08.in");
		System.out.println("Generado!");
	}

}
