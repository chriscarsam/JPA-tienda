package org.sam.alura.tienda.prueba;

import java.math.BigDecimal;
import javax.persistence.EntityManager;

import org.sam.alura.tienda.dao.CategoriaDao;
import org.sam.alura.tienda.dao.ClienteDao;
import org.sam.alura.tienda.dao.PedidoDao;
import org.sam.alura.tienda.dao.ProductoDao;
import org.sam.alura.tienda.modelo.Categoria;
import org.sam.alura.tienda.modelo.Cliente;
import org.sam.alura.tienda.modelo.ItemsPedido;
import org.sam.alura.tienda.modelo.Pedido;
import org.sam.alura.tienda.modelo.Producto;
import org.sam.alura.tienda.utils.JPAUtils;

public class RegistroDePedido {
	public static void main(String[] args) {
		registrarProducto();
		
		EntityManager em = JPAUtils.getEntityManager();
		
		ProductoDao productoDao = new ProductoDao(em);
		Producto producto = productoDao.consultaPorId(1l);
		
		ClienteDao clienteDao = new ClienteDao(em);
		PedidoDao pedidoDao = new PedidoDao(em);
		
		Cliente cliente = new Cliente("Juan", "k675kjb");
		Pedido pedido = new Pedido(cliente);
		pedido.agregarItems(new ItemsPedido(5, producto, pedido));	
		
		em.getTransaction().begin();	
		
		clienteDao.guardar(cliente);
		pedidoDao.guardar(pedido);
		
		em.getTransaction().commit();		
		 
	}

	private static void registrarProducto() {
		Categoria celulares = new Categoria("CELULARES");

		Producto celular = new Producto("Sansung X1", "Very good", new BigDecimal("800"), celulares);

	    EntityManager em = JPAUtils.getEntityManager();
	    ProductoDao productoDao = new ProductoDao(em);
        CategoriaDao categoriaDao = new CategoriaDao(em);
        
	    em.getTransaction().begin();
	    
	    categoriaDao.guardar(celulares);
	    productoDao.guardar(celular);	
	    
	    em.getTransaction().commit();
	    em.close();
	}
}
