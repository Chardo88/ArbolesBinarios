package alum;

import java.util.Comparator;

public class Alumno implements Comparable<Alumno>, Comparator<Alumno>{

	String Nombre = null;
	double Promedio = 0.00;
	
	
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public double getPromedio() {
		return Promedio;
	}
	public void setPromedio(double promedio) {
		Promedio = promedio;
	}
	
	
	@Override
	public int compare(Alumno o1, Alumno o2) {
		return o1.compareTo(o2);
	}
	@Override
	public int compareTo(Alumno o) {	
		if (this.Promedio == o.Promedio) return 0;
		else if (this.Promedio > o.Promedio) return 1;
		else return -1;
	}
	@Override
	public String toString() {
		return "Alumno [Nombre=" + Nombre + ", Promedio=" + Promedio + "]";
	}
	
	
	
	

	
	
	
	
}
