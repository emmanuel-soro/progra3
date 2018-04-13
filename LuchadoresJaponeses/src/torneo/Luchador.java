package torneo;

public class Luchador {

	private double peso;
	private double altura;

	public Luchador(final double peso, final double altura) {

		this.peso = peso;
		this.altura = altura;
	}

	public boolean domina(Luchador otroLuchador) {

		if (this.peso > otroLuchador.peso && this.altura > otroLuchador.altura) {
			return true;
		} else if (this.peso == otroLuchador.peso && this.altura > otroLuchador.altura) {
			return true;
		} else if (this.peso > otroLuchador.peso && this.altura == otroLuchador.altura) {
			return true;
		}
		return false;
	}
}
