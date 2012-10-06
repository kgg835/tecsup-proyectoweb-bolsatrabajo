package com.proyecto.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.proyecto.exception.DAOExcepcion;
import com.proyecto.modelo.RegistroPostulacion;
import com.proyecto.util.ConexionBD;



public class RegistroPostulacionDAO extends BaseDAO {

	public RegistroPostulacion insertar(RegistroPostulacion vo) throws DAOExcepcion {
		String query = "insert into registroPostulacion(fechPostulacion,EstadoPostulacion) values (?,?)";
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, vo.getFechPostulacion());
			stmt.setString(2, vo.getEstadoPostulacion());
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
			vo.setIdPostulacion(id);

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

	public RegistroPostulacion obtener(int idPostulacion) throws DAOExcepcion {
		RegistroPostulacion vo = new RegistroPostulacion();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			String query = "select id_categoria, nombre, descripcion from categoria where id_categoria=?";
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setInt(1, idPostulacion);
			rs = stmt.executeQuery();
			if (rs.next()) {
				vo.setIdPostulacion(rs.getInt(1));
				vo.setFechPostulacion(rs.getString(2));
				vo.setEstadoPostulacion(rs.getString(3));
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

	public void eliminar(int idPostulacion) throws DAOExcepcion {
		String query = "delete from RegistroPostulacion WHERE idpostulacion=?";
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setInt(1, idPostulacion);
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

	public RegistroPostulacion actualizar(RegistroPostulacion vo) throws DAOExcepcion {
		String query = "update registropostulacion set fechpostulacion=?,estadopostulacion=? where idpostulacion=?";
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, vo.getFechPostulacion());
			stmt.setString(2, vo.getEstadoPostulacion());
			stmt.setInt(3, vo.getIdPostulacion());
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

	
	
	//----------------------------------------------------------------------------------------------
	
//	public Collection<Categoria> listar() throws DAOExcepcion {
//		Collection<Categoria> c = new ArrayList<Categoria>();
//		Connection con = null;
//		PreparedStatement stmt = null;
//		ResultSet rs = null;
//		try {
//			con = ConexionBD.obtenerConexion();
//			String query = "select id_categoria,nombre,descripcion from categoria order by nombre";
//			stmt = con.prepareStatement(query);
//			rs = stmt.executeQuery();
//			while (rs.next()) {
//				Categoria vo = new Categoria();
//				vo.setIdCategoria(rs.getInt("id_categoria"));
//				vo.setNombre(rs.getString("nombre"));
//				vo.setDescripcion(rs.getString("descripcion"));
//				c.add(vo);
//			}
//
//		} catch (SQLException e) {
//			System.err.println(e.getMessage());
//			throw new DAOExcepcion(e.getMessage());
//		} finally {
//			this.cerrarResultSet(rs);
//			this.cerrarStatement(stmt);
//			this.cerrarConexion(con);
//		}
//		return c;
//	}
//
//}

}
