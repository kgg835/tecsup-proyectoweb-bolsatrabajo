package trastienda.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

import trastienda.excepcion.DAOExcepcion;
import trastienda.util.ConexionBD;

public class ProductoDAO extends BaseDAO {

	public int obtenerTotal() throws DAOExcepcion {
		System.out.println("obtenerTotal()");
		Connection cons = null;
		CallableStatement callstmt = null;
		int resultado = -1;
		try {
			String call = "{CALL sp_productos_total(?)}";
			cons = ConexionBD.obtenerConexion();
			callstmt = (CallableStatement) cons.prepareCall(call);
			callstmt.registerOutParameter(1, Types.INTEGER);
			callstmt.execute();
			resultado = callstmt.getInt(1);
		} catch (SQLException e) {
			throw new DAOExcepcion(e.toString());
		} catch (Exception e) {
			throw new DAOExcepcion(e.toString());
		} finally {
			cerrarCallable(callstmt);
			cerrarConexion(cons);
		}
		return resultado;
	}
}
