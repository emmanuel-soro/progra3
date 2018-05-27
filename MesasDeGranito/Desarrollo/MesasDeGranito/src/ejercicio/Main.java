package ejercicio;
import java.io.FileNotFoundException;

import javax.print.attribute.ResolutionSyntax;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {

		Negocio negocio = new Negocio("caso02.in", "caso02.out");
		negocio.resolver();
		
		negocio = new Negocio("caso03.in", "caso03.out");
		negocio.resolver();
		negocio = new Negocio("caso04.in", "caso04.out");
		negocio.resolver();
		negocio = new Negocio("caso05.in", "caso05.out");
		negocio.resolver();
		negocio = new Negocio("caso06.in", "caso06.out");
		negocio.resolver();
	}

}
