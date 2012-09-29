package com.proyecto.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.proyecto.exception.DAOExcepcion;
import com.proyecto.modelo.ConocimientoAdicional;
import com.proyecto.util.ConexionBD;

public class ConocimientoAdicionalDAO extends BaseDAO{
	
	//Metodo para Ingresar un conocimineto adicional 
	public ConocimientoAdicional insertarConocimiento(ConocimientoAdicional conocimiento) throws DAOExcepcion {
		String query = "insert into conocimiento_adicional(nombreConocimiento,descripcionConocimiento) values (?,?)";
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, conocimiento.getNombreConocimiento());
			stmt.setString(2, conocimiento.getDescrpcionConocimiento());
//			stmt.setString(1, vo.getNombre());
//			stmt.setString(2, vo.getDescripcion());
			int i = stmt.executeUpdate();
			if (i != 1) {
				throw new SQLException("No se pudo insertar el Conocimiento Adicional");
			}
			// Obtener el ultimo id
			int id = 0;
			query = "select last_insert_id()";
			stmt = con.prepareStatement(query);
			rs = stmt.executeQuery();
			if (rs.next()) {
				id = rs.getInt(1);
			}
			conocimiento.setIdConocimientoAdicional(id);

		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarResultSet(rs);
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		return conocimiento;
	}
	
	//Actualiza el Conocimiento Adicional del postulante
	public ConocimientoAdicional actualizarIdioma(ConocimientoAdicional conocimiento) throws DAOExcepcion {
		String query = "update conocimiento_adicional set conocimiento_adicional=?,descripcionConocimiento=? where idCONOCIMIENTO_ADICIONAL=?";
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, conocimiento.getNombreConocimiento());
			stmt.setString(2, conocimiento.getDescrpcionConocimiento());
			int i = stmt.executeUpdate();
			if (i != 1) {
				throw new SQLException("No se pudo actualizar el Conocimiento Adicional");
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		return conocimiento;
	}
	
	//Obtiene el Conocimiento Adicional deacuerdo al ID
	public ConocimientoAdicional obtenerConocimientoAdicional(int idConocimientoAd) throws DAOExcepcion {
		ConocimientoAdicional conocimiento = new ConocimientoAdicional();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			String query = "select idCONOCIMIENTO_ADICIONAL, nombreConocimiento,descripcionConocimiento from conocimiento_adicional where idCONOCIMIENTO_ADICIONAL=?";
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setInt(1,idConocimientoAd);
			rs = stmt.executeQuery();
			if (rs.next()) {
				conocimiento.setIdConocimientoAdicional(rs.getInt(1));
				conocimiento.setNombreConocimiento(rs.getString(2));
				conocimiento.setDescrpcionConocimiento(rs.getString(3));
				//idioma.setNivelOral(rs.getString(4));
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarResultSet(rs);
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		return conocimiento;
	}
}
