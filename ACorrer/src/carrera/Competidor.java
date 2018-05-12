package carrera;

public class Competidor {

	private int edad;
	private String sexo;
	private Categoria categoria;

	public Competidor(int edad, String sexo) {

		this.edad = edad;
		this.sexo = sexo;
	}

	public int getEdad() {
		return edad;
	}

	public String getSexo() {
		return sexo;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

}
