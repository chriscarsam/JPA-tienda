package org.sam.alura.tienda.modelo;

import javax.persistence.Embeddable;

@Embeddable
public class DatosPersonales {
	
	private String nombre;
	private String dni;
	
	public DatosPersonales() {		
	}
	
	public DatosPersonales(String nombre, String dni) {
		super();
		this.nombre = nombre;
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}
	
	

}
