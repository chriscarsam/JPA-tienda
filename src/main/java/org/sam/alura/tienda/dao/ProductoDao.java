package org.sam.alura.tienda.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.sam.alura.tienda.modelo.Producto;

public class ProductoDao {
	
	private EntityManager em;

	public ProductoDao(EntityManager em) {
		this.em = em;
	}
	
	public void guardar(Producto producto) {
		this.em.persist(producto);
	}
	
	public Producto consultaPorId(Long id) {
		return em.find(Producto.class, id);
	}
	
	public List<Producto> consultarTodos(){
		String jqpl = "SELECT P FROM Producto AS P";
		return em.createQuery(jqpl, Producto.class).getResultList();
	}
}
