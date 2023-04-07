package org.sam.alura.tienda.prueba;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import org.sam.alura.tienda.dao.ProductoDao;
import org.sam.alura.tienda.modelo.Producto;
import org.sam.alura.tienda.utils.JPAUtils;

public class RegistroDeProducto {
	public static void main(String[] args) {
		Producto celular = new Producto();
		celular.setNombre("Samsung");
		celular.setDescripcion("teléfono usado");
		celular.setPrecio(new BigDecimal("1000"));
				
		EntityManager em = JPAUtils.getEntityManager();
		
		ProductoDao productoDao = new ProductoDao(em);
		
		em.getTransaction().begin();
		
		productoDao.guardar(celular);
		
		em.getTransaction().commit();
		em.close();
		
	}
}