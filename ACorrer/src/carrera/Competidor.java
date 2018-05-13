package carrera;

public class Competidor {

	private int edad;
	private char sexo;
	private Categoria categoria;

	public Competidor(int edad, char sexo) {

		this.edad = edad;
		this.sexo = sexo;
	}

	public int getEdad() {
		return edad;
	}

	public char getSexo() {
		return sexo;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

}
