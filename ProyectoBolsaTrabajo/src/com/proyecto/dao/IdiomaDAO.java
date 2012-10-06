package com.proyecto.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.proyecto.exception.DAOExcepcion;
import com.proyecto.modelo.Idioma;
import com.proyecto.util.ConexionBD;

public class IdiomaDAO extends BaseDAO{
	//Metodo para Ingresar el Idioma 
	public Idioma insertarIdioma(Idioma idioma) throws DAOExcepcion {
		String query = "insert into IDIOMA(nombreIdioma," +
				"nivelEscrito,nivelOral) values (?,?,?)";
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, idioma.getNombreIdioma());
			stmt.setString(2, idioma.getNivelEscrito());
			stmt.setString(3,idioma.getNivelOral());
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
	//Actualiza el Idioma del postulante
	public Idioma actualizarIdioma(Idioma idioma) throws DAOExcepcion {
		String query = "update IDIOMA set nombreIdioma=?,nivelEscrito=?," +
				"nivelOral=? where idIDIOMA=?";
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, idioma.getNombreIdioma());
			stmt.setString(2, idioma.getNivelEscrito());
			stmt.setString(3, idioma.getNivelOral());
			int i = stmt.executeUpdate();
			if (i != 1) {
				throw new SQLException("No se pudo actualizar");
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		return idioma;
	}
	//Obtiene el idioma deacuerdo al ID
	public Idioma obtenerIdioma(int idIdioma) throws DAOExcepcion {
		Idioma idioma = new Idioma();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			String query = "select idIDIOMA, nombreIdioma,nivelEscrito," +
					"nivelOral from idioma where idIDIOMA=?";
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setInt(1,idIdioma);
			rs = stmt.executeQuery();
			if (rs.next()) {
				idioma.setIdIdioma(rs.getInt(1));
				idioma.setNombreIdioma(rs.getString(2));
				idioma.setNivelEscrito(rs.getString(3));
				idioma.setNivelOral(rs.getString(4));
			}
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
