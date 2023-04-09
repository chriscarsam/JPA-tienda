package org.sam.alura.tienda.prueba;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import org.sam.alura.tienda.dao.CategoriaDAO;
import org.sam.alura.tienda.dao.ProductoDao;
import org.sam.alura.tienda.modelo.Categoria;
import org.sam.alura.tienda.modelo.Producto;
import org.sam.alura.tienda.utils.JPAUtils;

public class RegistroDeProducto {
	public static void main(String[] args) {
		
		Categoria celulares = new Categoria("CELULARES");
								
		EntityManager em = JPAUtils.getEntityManager();

		em.getTransaction().begin();
		
		em.persist(celulares);
		
		celulares.setNombre("LIBROS");
		
		em.flush();
		em.clear();
		
		celulares = em.merge(celulares);
		celulares.setNombre("SOFTWARES");
		
		em.flush();
		em.clear();
		
		celulares = em.merge(celulares);
		em.remove(celulares);
		em.flush();
	}
}
