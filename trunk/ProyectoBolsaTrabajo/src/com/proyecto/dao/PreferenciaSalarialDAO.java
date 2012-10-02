package com.proyecto.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.proyecto.exception.DAOExcepcion;
import com.proyecto.modelo.PreferenciaSalarial;
import com.proyecto.util.ConexionBD;

public class PreferenciaSalarialDAO extends BaseDAO{
	//Metodo para Ingresar el Salario Preferencial 
	public PreferenciaSalarial insertarSalario(PreferenciaSalarial monto) throws DAOExcepcion {
		String query = "insert into preferencia_salarial(montoSoles,montoDolares) values (?,?)";
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setDouble(1, monto.getMontoSoles());
			stmt.setDouble(2, monto.getMontoDolares());

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
	
	//Actualiza el Idioma del postulante
	public PreferenciaSalarial actualizarSalario(PreferenciaSalarial monto) throws DAOExcepcion {
		String query = "UPDATE preferencia_salarial SET montoSoles=?,montoDolares=? WHERE idPREFERENCIA_SALARIAL=?";
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setDouble(1, monto.getMontoSoles());
			stmt.setDouble(2, monto.getMontoDolares());
			
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
		return monto;
	}
	
	//Obtiene el Salario deacuerdo al ID
	public PreferenciaSalarial obtenerSalario(int idPreferenciaSalarial) throws DAOExcepcion {
		PreferenciaSalarial monto = new PreferenciaSalarial();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			String query = "SELECT idPREFERENCIA_SALARIAL, montoSoles,montoDolares FROM preferencia_salarial WHERE idPREFERENCIA_SALARIAL=?";
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setInt(1,idPreferenciaSalarial);
			rs = stmt.executeQuery();
			if (rs.next()) {
				monto.setIdSalario(rs.getInt(1));
				monto.setMontoSoles(rs.getDouble(2));
				monto.setMontoDolares(rs.getDouble(3));
				
			}
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
