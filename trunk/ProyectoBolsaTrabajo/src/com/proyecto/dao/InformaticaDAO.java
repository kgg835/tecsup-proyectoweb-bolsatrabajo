package com.proyecto.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.proyecto.exception.DAOExcepcion;
import com.proyecto.modelo.Informatica;
import com.proyecto.util.ConexionBD;

public class InformaticaDAO extends BaseDAO{

	//Metodo para Ingresar el Curso de Informatica 
	public Informatica insertarInformatica(Informatica info) throws DAOExcepcion {
		String query = "insert into informatica(tipoInformatica,nivelInformatica) values (?,?)";
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, info.getTipoInformatica());
			stmt.setString(2, info.getNivelInformatica());
			int i = stmt.executeUpdate();
			if (i != 1) {
				throw new SQLException("No se pudo insertar informatica");
			}
			// Obtener el ultimo id
			int id = 0;
			query = "select last_insert_id()";
			stmt = con.prepareStatement(query);
			rs = stmt.executeQuery();
			if (rs.next()) {
				id = rs.getInt(1);
			}
			info.setIdInformatica(id);

		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarResultSet(rs);
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		return info;
	}
	
	//Actualiza la especialidad de Informatica del Postulante
	public Informatica actualizarInformatica(Informatica info) throws DAOExcepcion {
		String query = "update informatica set tipoInformatica=?,nivelInformatica=? where idINFORMATICA=?";
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, info.getTipoInformatica());
			stmt.setString(2, info.getNivelInformatica());
			
			int i = stmt.executeUpdate();
			if (i != 1) {
				throw new SQLException("No se pudo actualizar Informatica");
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		return info;
	}
	//Obtiene el conocimiento de Informatica deacuerdo al ID
	public Informatica obtenerInformatica(int idInfo) throws DAOExcepcion {
		Informatica info = new Informatica();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			String query = "select idINFORMATICA,tipoInformatica,nivelInformatica from informatica where idINFORMATICA=?";
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setInt(1,idInfo);
			rs = stmt.executeQuery();
			if (rs.next()) {
				info.setIdInformatica(rs.getInt(1));
				info.setTipoInformatica(rs.getString(2));
				info.setNivelInformatica(rs.getString(3));
				
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarResultSet(rs);
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		return info;
	}
}
