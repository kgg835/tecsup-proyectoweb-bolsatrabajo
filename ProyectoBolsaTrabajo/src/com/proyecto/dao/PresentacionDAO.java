package com.proyecto.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.proyecto.exception.DAOExcepcion;
import com.proyecto.modelo.Presentacion;
import com.proyecto.util.ConexionBD;

public class PresentacionDAO extends BaseDAO {
	//Metodo para Insertar una Presentacion del Postulante
	public Presentacion insertarPresentacion(Presentacion vo)throws DAOExcepcion {
		String query = "insert into presentacion(descripcion_pres) values (?)";
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, vo.getDescripcionPres());
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
			vo.setIdPresentacion(id);

		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarResultSet(rs);
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		return vo;
	}
	//Metodo para obtener un Presentacion del Postulante
	public Presentacion obtenerPresentacion(int idPresentacion) throws DAOExcepcion {
		Presentacion vo = new Presentacion();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			String query = "select idPresentacion, descripcion_pres from presentacion where idPRESENTACION=?";
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setInt(1, idPresentacion);
			rs = stmt.executeQuery();
			if (rs.next()) {
				vo.setIdPresentacion(rs.getInt(1));
				vo.setDescripcionPres(rs.getString(2));

			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarResultSet(rs);
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		return vo;
	}
	//Metodo que elimina una Presentacion del postulante
	public void eliminarPresentacion(int idPresentacion) throws DAOExcepcion {
		String query = "delete from presentacion WHERE idPRESENTACION=?";
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setInt(1, idPresentacion);
			int i = stmt.executeUpdate();
			if (i != 1) {
				throw new SQLException("No se pudo eliminar");
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
	}
	//metodo que actualiza la presentacion de un Postulante
	public Presentacion actualizar(Presentacion vo) throws DAOExcepcion {
		String query = "update presentacion set descripcion_pres=? where idPRESENTACION=?";
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setInt(1, vo.getIdPresentacion());
			stmt.setString(2, vo.getDescripcionPres());

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
		return vo;
	}
}
