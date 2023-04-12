package org.sam.alura.tienda.prueba;

import java.io.FileNotFoundException;

import javax.persistence.EntityManager;

import org.sam.alura.tienda.dao.PedidoDao;
import org.sam.alura.tienda.modelo.Pedido;
import org.sam.alura.tienda.utils.JPAUtils;

public class PruebaDeDesempeniho {
	public static void main(String[] args) throws FileNotFoundException {
		LoadRecords.cargarRegistros();
		
		EntityManager em = JPAUtils.getEntityManager();
		
		PedidoDao pedidoDao = new PedidoDao(em);
		Pedido pedidoConCliente = pedidoDao.consultarPedidoConCliente(2l);
		
		em.close();
		
		// System.out.println(pedido.getFecha());
		// System.out.println(pedido.getItems().size());
		System.out.println(pedidoConCliente.getCliente().getNombre());
	}

}
