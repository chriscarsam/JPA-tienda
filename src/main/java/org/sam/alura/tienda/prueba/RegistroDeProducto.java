package org.sam.alura.tienda.prueba;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import org.sam.alura.tienda.dao.ProductoDao;
import org.sam.alura.tienda.modelo.Categoria;
import org.sam.alura.tienda.modelo.Producto;
import org.sam.alura.tienda.utils.JPAUtils;

public class RegistroDeProducto {
	public static void main(String[] args) {
		
		Categoria celulares = new Categoria("CELULARES");
		Producto celular = new Producto("Samsung","teléfono usado", new BigDecimal("1000"), celulares);
						
		EntityManager em = JPAUtils.getEntityManager();
		
		ProductoDao productoDao = new ProductoDao(em);
		
		em.getTransaction().begin();
		
		productoDao.guardar(celular);
		
		em.getTransaction().commit();
		em.close();
		
	}
}
