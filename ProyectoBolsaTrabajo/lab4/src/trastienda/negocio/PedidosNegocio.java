package trastienda.negocio;

import java.util.Collection;

import trastienda.dao.PedidoDAO;
import trastienda.excepcion.DAOExcepcion;
import trastienda.modelo.DetallePedido;
import trastienda.modelo.Pedido;

public class PedidosNegocio {

	public void realizarPedido( String idUsuario, String fecha, String estado, double total, Collection<DetallePedido> detalles)  throws DAOExcepcion {
		
		Pedido p = new Pedido();
		p.setIdUsuario(idUsuario);
		p.setFecha(fecha);
		p.setEstado(estado);
		p.setTotal(total);
		
		p.setDetalles(detalles);
		
		PedidoDAO dao = new PedidoDAO();
		try {
			dao.insertar(p);
		} catch (DAOExcepcion e) {
			throw e;
		}		

	}
}
