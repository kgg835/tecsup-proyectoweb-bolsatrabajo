package com.proyecto.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.proyecto.exception.DAOExcepcion;
import com.proyecto.modelo.Estudio;
import com.proyecto.util.ConexionBD;

public class EstudioDAO extends BaseDAO {

	// Metodo para Ingresar es Estudio del Postulante
	public Estudio insertarEstudio(Estudio estudio) throws DAOExcepcion {
		String query = "INSERT INTO estudio("
				+ "tituloEstudio,fechaInicio,fechaFin,"
				+ "descrpcioninstitucion,pais,NivelEstudio,"
				+ "estado,areaEstudio,promedio,materiasAprobadas,"
				+ "cantidadMaterias,EST_idPERSONA" + ") "
				+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, estudio.getTituloEstudio());
			stmt.setString(2, estudio.getFechaInicio());
			stmt.setString(3, estudio.getFechaFinal());
			stmt.setString(4, estudio.getDescripcionInstutucion());
			stmt.setString(5, estudio.getPais());
			stmt.setString(6, estudio.getNivelEstudio());
			stmt.setString(7, estudio.getEstado());
			stmt.setString(8, estudio.getAreaEstudio());
			stmt.setDouble(9, estudio.getPromedio());
			stmt.setInt(10, estudio.getMateriasAprovadas());
			stmt.setInt(11, estudio.getCantidadMaterias());
			stmt.setInt(12, estudio.getIdPersona());
			//stmt.setInt(13, estudio.getIdPresentacion());
			// stmt.setString(1, vo.getNombre());
			// stmt.setString(2, vo.getDescripcion());
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
			estudio.setIdEstudios(id);

		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarResultSet(rs);
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		return estudio;
	}

	// //Actualiza el Estudio del postulante
	// public Idioma actualizarIdioma(Idioma idioma) throws DAOExcepcion {
	// String query = "update IDIOMA set nombreIdioma=?,nivelEscrito=?," +
	// "nivelOral=? where idIDIOMA=?";
	// Connection con = null;
	// PreparedStatement stmt = null;
	// try {
	// con = ConexionBD.obtenerConexion();
	// stmt = con.prepareStatement(query);
	// stmt.setString(1, idioma.getNombreIdioma());
	// stmt.setString(2, idioma.getNivelEscrito());
	// stmt.setString(3, idioma.getNivelOral());
	// int i = stmt.executeUpdate();
	// if (i != 1) {
	// throw new SQLException("No se pudo actualizar");
	// }
	// } catch (SQLException e) {
	// System.err.println(e.getMessage());
	// throw new DAOExcepcion(e.getMessage());
	// } finally {
	// this.cerrarStatement(stmt);
	// this.cerrarConexion(con);
	// }
	// return idioma;
	// }

	// Obtiene el Estudio del Postulante de acuerdo al ID
	public Estudio obtenerEstudio(int idEstudio) throws DAOExcepcion {
		Estudio estudio = new Estudio();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			String query = "SELECT idESTUDIO,tituloEstudio,"
					+ "fechaInicio,fechaFin," + "descrpcioninstitucion,"
					+ "pais,NivelEstudio,estado,"
					+ "areaEstudio,promedio,materiasAprobadas,"
					+ "cantidadMaterias,EST_idPERSONA " + "FROM estudio "
					+ "WHERE idESTUDIO=?";
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setInt(1, idEstudio);
			rs = stmt.executeQuery();
			if (rs.next()) {
				estudio.setIdEstudios(rs.getInt(1));
				estudio.setTituloEstudio(rs.getString(2));
				estudio.setFechaInicio(rs.getString(3));
				estudio.setFechaFinal(rs.getString(4));
				estudio.setDescripcionInstutucion(rs.getString(5));
				estudio.setPais(rs.getString(6));
				estudio.setNivelEstudio(rs.getString(7));
				estudio.setEstado(rs.getString(8));
				estudio.setAreaEstudio(rs.getString(9));
				estudio.setPromedio(rs.getDouble(10));
				estudio.setMateriasAprovadas(rs.getInt(11));
				estudio.setCantidadMaterias(rs.getInt(12));
				estudio.setIdPersona(rs.getInt(13));
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarResultSet(rs);
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		return estudio;
	}
}
