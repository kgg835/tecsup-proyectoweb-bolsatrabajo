package com.proyecto.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.proyecto.exception.DAOExcepcion;
import com.proyecto.modelo.PreferenciaSalarial;
import com.proyecto.util.ConexionBD;

public class PreferenciaSalarialDAO extends BaseDAO{
	//Metodo para Ingresar el Idioma 
	public PreferenciaSalarial insertarIdioma(PreferenciaSalarial monto) throws DAOExcepcion {
		String query = "insert into IDIOMA(nombreIdioma,nivelEscrito,nivelOral) values (?,?,?)";
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setDouble(1, monto.getMontoSoles());
			stmt.setDouble(2, monto.getMontoDolares());
		//	stmt.setString(3,idioma.getNivelOral());
//			stmt.setString(1, vo.getNombre());
//			stmt.setString(2, vo.getDescripcion());
			int i = stmt.executeUpdate();
			if (i != 1) {
				throw new SQLException("No se pudo insertar");
			}
			// Obtener el ultimo id
			int id = 0;
			query = "select last_insert_id()";
			stmt = con.prepareStatement(query);
			rs = stmt.executeQuery();
			if (rs.next()) {
				id = rs.getInt(1);
			}
			monto.setIdSalario(id);

		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarResultSet(rs);
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		return monto;
	}
}
