package com.proyecto.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.proyecto.exception.DAOExcepcion;
import com.proyecto.modelo.Referencia;
import com.proyecto.util.ConexionBD;

public class ReferenciaDAO extends BaseDAO {
	// Metodo para Ingresar una Referencia del Postulante
	public Referencia insertarReferencia(Referencia referencia)
			throws DAOExcepcion {
		String query = "insert into referencia(nombreRef,REF_idPERSONA," +
				"apellidosRefer,emailRef,telefonoRef,relacionRef," +
				"puestoEmpresaRef,experienciaRelacionadaRef) " +
				"values (?,?,?,?,?,?,?,?)";
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, referencia.getNombreReferencia());
			stmt.setInt(2, referencia.getCodPostulante());
			stmt.setString(3, referencia.getApellidoReferencia());
			stmt.setString(4, referencia.getEmail());
			stmt.setString(5, referencia.getTelefonoReferencia());
			stmt.setString(6, referencia.getRelacion());
			stmt.setString(7, referencia.getPuestoEmpresa());
			stmt.setString(8, referencia.getExperienciaRelacionada());
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
			referencia.setIdReferencia(id);

		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarResultSet(rs);
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		return referencia;
	}

	//Metodo que actualiza la Referencia del postulante
	public Referencia actualizarReferencia(Referencia referencia)
			throws DAOExcepcion {
		String query = "UPDATE referencia SET nombreRef=?," +
				"apellidosRefer=?,emailRef=?,telefonoRef=?," +
				"relacionRef=?,puestoEmpresaRef=?," +
				"experienciaRelacionadaRef=? where idREFERENCIA=?";
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, referencia.getNombreReferencia());
			stmt.setString(2, referencia.getApellidoReferencia());
			stmt.setString(3, referencia.getEmail());
			stmt.setString(4,referencia.getTelefonoReferencia());
			stmt.setString(5,referencia.getRelacion());
			stmt.setString(6,referencia.getPuestoEmpresa());
			stmt.setString(7,referencia.getExperienciaRelacionada());
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
		return referencia;
	}
	//Obtiene una Referncia deacuerdo al ID
	public Referencia obtenerReferencia(int idReferencia) throws DAOExcepcion {
		Referencia referencia = new Referencia();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			String query = "SELECT idREFERENCIA, nombreRef," +
					"REF_idPERSONA,apellidosRefer,emailRef," +
					"telefonoRef,relacionRef,puestoEmpresaRef," +
					"experienciaRelacionadaRef FROM referencia " +
					"WHERE idREFERENCIA=?";
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setInt(1,idReferencia);
			rs = stmt.executeQuery();
			if (rs.next()) {
				referencia.setIdReferencia(rs.getInt(1));
				referencia.setNombreReferencia(rs.getString(2));
				referencia.setCodPostulante(rs.getInt(3));
				referencia.setApellidoReferencia(rs.getString(4));
				referencia.setEmail(rs.getString(5));
				referencia.setTelefonoReferencia(rs.getString(6));
				referencia.setRelacion(rs.getString(7));
				referencia.setPuestoEmpresa(rs.getString(8));
				referencia.setExperienciaRelacionada(rs.getString(9));
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarResultSet(rs);
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		return referencia;
	}
}
