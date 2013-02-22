package com.proyecto.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.proyecto.exception.DAOExcepcion;
import com.proyecto.modelo.ExperienciaLaboral;
import com.proyecto.util.ConexionBD;

public class ExperienciaLaboralDAO extends BaseDAO {
	// Metodo para Ingresar una Experiencia Laboral
	public ExperienciaLaboral insertarExperienciaLaboral(
			ExperienciaLaboral experiencialaboral) throws DAOExcepcion {
		String query = "INSERT INTO experiencia_laboral(titulo_Puesto,"
				+ "empresa,pais,fechaInicio,fechaFinal,area,subArea,"
				+ "descripcionResponsabilidad,numeroPersonasCargo,"
				+ "EX_LAB_idPERSONA) VALUES (?,?,?,?,?,?,?,?,?,?)";
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, experiencialaboral.getTituloPuesto());
			stmt.setString(2, experiencialaboral.getEmpresa());
			stmt.setString(3, experiencialaboral.getPais());
			stmt.setString(4, experiencialaboral.getFechaInicio());
			stmt.setString(5, experiencialaboral.getFechaFinal());
			stmt.setString(6, experiencialaboral.getArea());
			stmt.setString(7, experiencialaboral.getSubArea());
			stmt.setString(8,
					experiencialaboral.getDescripcionResponsabilidad());
			stmt.setInt(9, experiencialaboral.getNumPersonasCargo());
			stmt.setInt(10, experiencialaboral.getIdPostulante());
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
			experiencialaboral.setIdExperienciaLaboral(id);

		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarResultSet(rs);
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		return experiencialaboral;
	}

	// Metodo que actualiza la Experiencia laboral del postulante
	public ExperienciaLaboral actualizarExperienciaLaboral(
			ExperienciaLaboral experiencia) throws DAOExcepcion {
		String query = "UPDATE experiencia_laboral SET titulo_Puesto=?,"
				+ "empresa=?,pais=?,fechaInicio=?,fechaFinal=?,area=?,"
				+ "subArea=?,descripcionResponsabilidad=?,numeroPersonasCargo=?"
				+ " WHERE idEXPERIENCIA_LABORAL=?";
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, experiencia.getTituloPuesto());
			stmt.setString(2, experiencia.getEmpresa());
			stmt.setString(3, experiencia.getPais());
			stmt.setString(4, experiencia.getFechaInicio());
			stmt.setString(5, experiencia.getFechaFinal());
			stmt.setString(6, experiencia.getArea());
			stmt.setString(7, experiencia.getSubArea());
			stmt.setString(8, experiencia.getDescripcionResponsabilidad());
			stmt.setInt(9, experiencia.getNumPersonasCargo());
			// stmt.setInt(10,experiencia.getPostulante().getIdPostulante());
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
		return experiencia;
	}

	// Obtiene la Experiencia Laboral deacuerdo al ID
	public ExperienciaLaboral obtenerExperienciaLaboral(int idExperiencia)
			throws DAOExcepcion {
		ExperienciaLaboral experiencia = new ExperienciaLaboral();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			String query = "SELECT idEXPERIENCIA_LABORAL,"
					+ "titulo_Puesto,empresa,pais,fechaInicio,"
					+ "fechaFinal,area,subArea,descripcionResponsabilidad,"
					+ "numeroPersonasCargo,EX_LAB_idPERSONA "
					+ "FROM experiencia_laboral "
					+ "WHERE idEXPERIENCIA_LABORAL=?";
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setInt(1, idExperiencia);
			rs = stmt.executeQuery();
			if (rs.next()) {
				experiencia.setIdExperienciaLaboral(rs.getInt(1));
				experiencia.setTituloPuesto(rs.getString(2));
				experiencia.setEmpresa(rs.getString(3));
				experiencia.setPais(rs.getString(4));
				experiencia.setFechaInicio(rs.getString(5));
				experiencia.setFechaFinal(rs.getString(6));
				experiencia.setArea(rs.getString(7));
				experiencia.setSubArea(rs.getString(8));
				experiencia.setDescripcionResponsabilidad(rs.getString(9));
				experiencia.setNumPersonasCargo(rs.getInt(10));
				experiencia.setIdPostulante(rs.getInt(11));
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarResultSet(rs);
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		return experiencia;
	}
}
