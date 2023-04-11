package org.sam.alura.tienda.dao;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import org.sam.alura.tienda.modelo.Pedido;
import org.sam.alura.tienda.modelo.Producto;

public class PedidoDao {
	
	private EntityManager em;

	public PedidoDao(EntityManager em) {
		this.em = em;
	}
	
	public void guardar(Pedido pedido) {
		this.em.persist(pedido);
	}
	
	public Pedido consultaPorId(Long id) {
		return em.find(Pedido.class, id);
	}
	
	public List<Pedido> consultarTodos(){
		String jqpl = "SELECT P FROM Pedido AS P";
		return em.createQuery(jqpl, Pedido.class).getResultList();
	}
	
	public List<Pedido> consultaPorNombre(String nombre){
		String jpql = " SELECT P FROM Pedido AS P WHERE P.nombre=:nombre ";
		return em.createQuery(jpql, Pedido.class).setParameter("nombre", nombre).getResultList();
	}
	
	public List<Pedido> consultaPorNombreDeCategoria(String nombre){
		String jpql = " SELECT p FROM Pedido AS p WHERE p.categoria.nombre=:nombre";
		return em.createQuery(jpql, Pedido.class).setParameter("nombre", nombre).getResultList();
	}
	
	public BigDecimal consultarPrecioPorNombreDeProducto(String nombre) {
		String jpql = " SELECT P.precio FROM Pedido AS P WHERE P.nombre=:nombre ";
		return em.createQuery(jpql, BigDecimal.class).setParameter("nombre", nombre).getSingleResult();
	}
}