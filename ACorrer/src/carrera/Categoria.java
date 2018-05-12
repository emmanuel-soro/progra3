package carrera;

public class Categoria {

	private int edadMinina;
	private int edadMaxima;
	private int[] podio;

	public Categoria(int edadMinina, int edadMaxima) {
		this.edadMinina = edadMinina;
		this.edadMaxima = edadMaxima;
		this.podio = new int[3];
	}

	public int getEdadMinina() {
		return edadMinina;
	}

	public int getEdadMaxima() {
		return edadMaxima;
	}

	public int[] getPodio() {
		return podio;
	}

}
