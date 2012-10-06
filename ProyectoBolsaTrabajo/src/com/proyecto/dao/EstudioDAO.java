package com.proyecto.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.proyecto.exception.DAOExcepcion;
import com.proyecto.modelo.Estudio;
import com.proyecto.modelo.Idioma;
import com.proyecto.util.ConexionBD;

public class EstudioDAO extends BaseDAO{
	
	//Metodo para Ingresar el Idioma 
	public Estudio insertarIdioma(Estudio estudio) throws DAOExcepcion {
		String query = "insert into IDIOMA(nombreIdioma," +
				"nivelEscrito,nivelOral) values (?,?,?)";
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, estudio.getTituloEstudio());
			stmt.setString(2, estudio.getFechaInicio());
			stmt.setString(3,estudio.getFechaFinal());
			stmt.setString(4,estudio.getDescripcionInstutucion());
			stmt.setString(5,estudio.getPais());
			stmt.setString(6,estudio.getNivelEstudio());
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
			idioma.setIdIdioma(id);

		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarResultSet(rs);
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		return idioma;
	}
}
