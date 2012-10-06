package com.proyecto.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import com.proyecto.exception.DAOExcepcion;
import com.proyecto.modelo.Postulante;
import com.proyecto.util.ConexionBD;

public class PostulanteDAO extends BaseDAO {
	// Metodo que inserta un postulante
	public Postulante insertarPostulante(Postulante postulante)
			throws DAOExcepcion {
		String query = "INSERT INTO persona(tipo_persona,nombrePersona,"
				+ "apellidosPersona,dni,codPersona,passwordPe,email,"
				+ "pais,provincia,ciudad,direccion,telefonoFijo,"
				+ "numeroCelular,fechaNacimiento,sexo,estadoCivil,"
				+ "PER_idPRESENTACION,PER_idPREFERENCIAS_SALARIALES)"
				+ "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";// ?:por cada
		// columna
		Connection con = null;
		PreparedStatement stmt = null;// sentencias preparadas
		ResultSet rs = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);

			stmt.setString(1, postulante.getTipoPersona());
			stmt.setString(2, postulante.getNombre());
			stmt.setString(3, postulante.getApellidos());
			stmt.setString(4, postulante.getDni());
			stmt.setString(5, postulante.getCodPostulante());
			stmt.setString(6, postulante.getPasswordPE());
			stmt.setString(7, postulante.getEmail());
			stmt.setString(8, postulante.getPaisPostulante());
			stmt.setString(9, postulante.getProvinciaPostulante());
			stmt.setString(10, postulante.getCiudadPostulante());
			stmt.setString(11, postulante.getDireccion());
			stmt.setString(12, postulante.getTelefonoFijo());
			stmt.setString(13, postulante.getTelefonoCel());
			stmt.setString(14, postulante.getFechaNacimiento());
			stmt.setString(15, postulante.getSexo());
			stmt.setString(16, postulante.getEstadoCivil());
			stmt.setInt(17, postulante.getIdPresentacion());
			stmt.setInt(18, postulante.getIdPreferencia_Salarial());
			int i = stmt.executeUpdate();// executeUpdate() devuelve un entero=#
											// de filas afectadas
			if (i != 1) {
				throw new SQLException("No se pudo insertar al Postulante");
			}
			// Obtener el ultimo id
			int id = 0;
			query = "select last_insert_id()";
			stmt = con.prepareStatement(query);
			rs = stmt.executeQuery();// devuelve un ResultSet= a una tabla
			if (rs.next()) {
				id = rs.getInt(1);
			}
			postulante.setIdPostulante(id);
		} catch (Exception e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarResultSet(rs);
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		return postulante;
	}

	// Metodo para obtener un Postulante

	public Postulante obtenerPostulante(int idPostulante) throws DAOExcepcion {
		Postulante postulante = new Postulante();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			String query = "SELECT idPERSONA,tipo_persona,"
					+ "nombrePersona,apellidosPersona,dni,"
					+ "codPersona,passwordPe,email,pais,"
					+ "provincia,ciudad,direccion,telefonoFijo,"
					+ "numeroCelular,fechaNacimiento,sexo,estadoCivil,"
					+ "PER_idPRESENTACION,PER_idPREFERENCIAS_SALARIALES "
					+ "FROM persona WHERE idPERSONA=?";
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setInt(1, idPostulante);
			rs = stmt.executeQuery();
			if (rs.next()) {//
				// postulante.setNombre(rs.getString(1));
				// postulante.setDni(rs.getString(2));
				postulante.setIdPostulante(rs.getInt(1));
				postulante.setTipoPersona(rs.getString(2));
				postulante.setNombre(rs.getString(3));
				postulante.setApellidos(rs.getString(4));
				postulante.setDni(rs.getString(5));
				postulante.setCodPostulante(rs.getString(6));
				postulante.setPasswordPE(rs.getString(7));
				postulante.setEmail(rs.getString(8));
				postulante.setPaisPostulante(rs.getString(9));
				postulante.setProvinciaPostulante(rs.getString(10));
				postulante.setCiudadPostulante(rs.getString(11));
				postulante.setDireccion(rs.getString(12));
				postulante.setTelefonoFijo(rs.getString(13));
				postulante.setTelefonoCel(rs.getString(14));
				postulante.setFechaNacimiento(rs.getString(15));
				postulante.setSexo(rs.getString(16));
				postulante.setEstadoCivil(rs.getString(17));
				postulante.setIdPresentacion(rs.getInt(18));
				postulante.setIdPreferencia_Salarial(rs.getInt(19));

			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarResultSet(rs);
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		return postulante;
	}

	// metodo que actualiza los datos del Postulante
	public Postulante actualizarPostulante(Postulante postulante)
			throws DAOExcepcion {
		String query = "update PERSONA set nombrePersona=?,apPellidos=?,email=? where idPERSONA=?";
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, postulante.getNombre());
			stmt.setString(2, postulante.getApellidos());
			stmt.setString(3, postulante.getEmail());
			stmt.setInt(4, postulante.getIdPostulante());

			// stmt.setString(1, vo.getNombre());
			// stmt.setString(2, vo.getDescripcion());
			// stmt.setInt(3, vo.getIdCategoria());
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
		return postulante;
	}

	// Metodo para listar todos los postulantes
	public Collection<Postulante> listarPostulante() throws DAOExcepcion {
		Collection<Postulante> c = new ArrayList<Postulante>();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConexionBD.obtenerConexion();
			String query = "select idPERSONA,tipo_persona,nombrePersona,"
					+ "apPellidos,dni,codPersona,passwordPe,email,pais,provincia,"
					+ "ciudad,direccion,telefonoFijo,numeroCelular,fechaNacimiento,"
					+ "sexo,estadoCivil " + "from PERSONA "
					+ "order by nombrePersona";
			stmt = con.prepareStatement(query);
			rs = stmt.executeQuery();// me extrae los datos de tabla Persona x
										// Columna
			while (rs.next()) {// Aqui se llena los datos en el objeto
								// Postulante
				Postulante postulante = new Postulante();
				postulante.setIdPostulante(rs.getInt("idPERSONA"));
				postulante.setTipoPersona(rs.getString("tipo_persona"));
				postulante.setNombre(rs.getString("nombrePersona"));
				postulante.setApellidos(rs.getString("apPellidos"));
				postulante.setDni(rs.getString("dni"));
				postulante.setCodseleccion(rs.getString("codPersona"));
				postulante.setPasswordPE(rs.getString("passwordPe"));
				postulante.setEmail(rs.getString("email"));
				// postulante.setPais();
				// postulante.setprovincia();
				// postulante.setCiudad();
				postulante.setDireccion(rs.getString("direccion"));
				postulante.setTelefonoFijo(rs.getString("telefonoFijo"));
				postulante.setTelefonoCel(rs.getString("numeroCelular"));
				postulante.setFechaNacimiento(rs.getString("fechaNacimiento"));
				postulante.setSexo(rs.getString("sexo"));
				postulante.setEstadoCivil(rs.getString("estadoCivil"));

				// vo.setIdCategoria(rs.getInt("id_categoria"));
				// vo.setNombre(rs.getString("nombre"));
				// vo.setDescripcion(rs.getString("descripcion"));
				c.add(postulante);
			}

		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarResultSet(rs);
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		return c;
	}

	public Collection<Postulante> buscarPostulante(String nrodni)
			throws DAOExcepcion {
		String query = "select idPERSONA,tipo_persona,nombrePersona,apPellidos from categoria where dni= ?";
		Collection<Postulante> listaPostulante = new ArrayList<Postulante>();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, nrodni);
			rs = stmt.executeQuery();
			while (rs.next()) {
				Postulante postulante = new Postulante();

				postulante.setIdPostulante(rs.getInt("idPERSONA"));
				postulante.setTipoPersona(rs.getString("tipo_persona"));
				postulante.setNombre(rs.getString("nombrePersona"));
				postulante.setApellidos(rs.getString("apPellidos"));
				// vo.setIdCategoria(rs.getInt("id_categoria"));
				// vo.setNombre(rs.getString("nombre"));
				// vo.setDescripcion(rs.getString("descripcion"));
				listaPostulante.add(postulante);
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarResultSet(rs);
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		System.out.println(listaPostulante.size());
		return listaPostulante;
	}

	// Metodo para eliminar un Postulante
	public void eliminarPostulante(int idPostulante) throws DAOExcepcion {
		String query = "delete from PERSONA WHERE idPERSONA=?";
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = ConexionBD.obtenerConexion();// para la conection
			stmt = con.prepareStatement(query);
			stmt.setInt(1, idPostulante);
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

}
