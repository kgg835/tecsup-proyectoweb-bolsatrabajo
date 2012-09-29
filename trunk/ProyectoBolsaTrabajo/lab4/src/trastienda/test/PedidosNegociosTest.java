package trastienda.test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import junit.framework.Assert;
import trastienda.excepcion.DAOExcepcion;
import trastienda.modelo.DetallePedido;
import trastienda.negocio.PedidosNegocio;

public class PedidosNegociosTest {

	@Test
	public void realizarPedidoTest(){
		
		DetallePedido dp1 = new DetallePedido();
		dp1.setIdProducto(1);
		dp1.setPrecio(10);
		dp1.setCantidad(1);
		
		DetallePedido dp2 = new DetallePedido();
		dp2.setIdProducto(2);
		dp2.setPrecio(20);
		dp2.setCantidad(1);

		Collection<DetallePedido> detalles = new ArrayList<DetallePedido>();
		detalles.add(dp1);
		detalles.add(dp2);
		
		PedidosNegocio negocio = new PedidosNegocio();
		try {
			negocio.realizarPedido("david","2011-07-15", "1", 500, detalles);
		} catch (DAOExcepcion e) {
			Assert.fail("Falló la inserción");
		}		
	}
}
