package org.sam.alura.tienda.prueba;

import java.io.FileNotFoundException;

import javax.persistence.EntityManager;

import org.sam.alura.tienda.modelo.Pedido;
import org.sam.alura.tienda.utils.JPAUtils;

public class PruebaDeDesempeniho {
	public static void main(String[] args) throws FileNotFoundException {
		LoadRecords.cargarRegistros();
		
		EntityManager em = JPAUtils.getEntityManager();
		
		Pedido pedido = em.find(Pedido.class, 3l);
		
		System.out.println(pedido.getFecha());
	}

}
