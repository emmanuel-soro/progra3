public class Mesada {

	private int largo;
	private int ancho;

	public Mesada(int ancho, int largo) {

		this.largo = largo;
		this.ancho = ancho;
	}

	public int getLargo() {
		return largo;
	}

	public int getAncho() {
		return ancho;
	}
	
	public long getSuperficie() {
		return this.ancho * this.largo;
	}

	@Override
	public String toString() {
		return "Mesada [largo=" + largo + ", ancho=" + ancho + "]";
	}
	

}
