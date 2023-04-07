package org.sam.alura.tienda.modelo;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "productos")
public class Producto {
	
	private Long id;
	private String nombre;
	private String descripcion;
	private BigDecimal precio;
	
}
