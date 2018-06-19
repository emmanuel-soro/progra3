package ej8;

public class Sales extends Employee{

	
	//puede ser protected o public, no se puede achicar la visibilidad 
	@Override
	protected double getSalesAmount() {
		return 1230.45;
	}

}
