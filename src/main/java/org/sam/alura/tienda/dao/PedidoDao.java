package org.sam.alura.tienda.dao;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import org.sam.alura.tienda.modelo.Pedido;
import org.sam.alura.tienda.vo.RelatorioDeVentas;

public class PedidoDao {
	
	private EntityManager em;

	public PedidoDao(EntityManager em) {
		this.em = em;
	}
	
	public void guardar(Pedido pedido) {
		this.em.persist(pedido);
	}
	
	public void actualizar(Pedido pedido) {
		this.em.merge(pedido);
	}
	
	public void remover(Pedido pedido) {
		pedido=this.em.merge(pedido);
		this.em.remove(pedido);
	}
	
	public Pedido consultaPorId(Long id) {
		return em.find(Pedido.class, id);
	}
	
	public List<Pedido> consultarTodos(){
		String jqpl = "SELECT P FROM Pedido AS P";
		return em.createQuery(jqpl, Pedido.class).getResultList();
	}
	
	public BigDecimal valorTotalVendido() {
		String jpql = "SELECT SUM(p.valorTotal) FROM Pedido p";
		return em.createQuery(jpql, BigDecimal.class).getSingleResult();
	}
	
	public BigDecimal valorPromedioVendido() {
		String jpql = "SELECT AVG(p.valorTotal) FROM Pedido p";
		return em.createQuery(jpql, BigDecimal.class).getSingleResult();
	}
	
	public List<Object[]> relatorioDeVentas(){
		String jpql = "SELECT producto.nombre, "
				+ "SUM(item.cantidad), "
				+ "MAX(pedido.fecha) "
				+ "FROM Pedido pedido "
				+ "JOIN pedido.items item "
				+ "JOIN item.producto producto "
				+ "GROUP BY producto.nombre ";
		
		return em.createQuery(jpql, Object[].class).getResultList();
	}
	
	public List<RelatorioDeVentas> relatorioDeVentasVO(){
		String jpql = "SELECT new org.sam.alura.tienda.vo.RelatorioDeVentas(producto.nombre, "
				+ "SUM(item.cantidad), "
				+ "MAX(pedido.fecha)) "
				+ "FROM Pedido pedido "
				+ "JOIN pedido.items item "
				+ "JOIN item.producto producto "
				+ "GROUP BY producto.nombre ";
		
		return em.createQuery(jpql, RelatorioDeVentas.class).getResultList();
	}
	
	public Pedido consultarPedidoConCliente(Long id) {
		String jpql = "SELECT p FROM Pedido p JOIN FETCH p.cliente WHERE p.id=:id";
		return em.createQuery(jpql, Pedido.class).setParameter("id", id).getSingleResult();
	}
}

