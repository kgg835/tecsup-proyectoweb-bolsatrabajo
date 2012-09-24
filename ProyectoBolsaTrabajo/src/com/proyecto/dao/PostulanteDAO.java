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
	public Postulante insertar(Postulante postulante) throws DAOExcepcion {
		System.out.println("hola");
		String query = "insert into PERSONA(tipo_persona,nombrePersona,"
				+ "apPellidos,dni,codPersona,passwordPe,email,pais,"
				+ "provincia,ciudad,direccion,telefonoFijo,numeroCelular,"
				+ "fechaNacimiento,sexo,estadoCivil)"
				+ " values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";// ?:por cada
																// columna
		Connection con = null;
		PreparedStatement stmt = null;// sentencias preparadas
		ResultSet rs = null;
		try {
			System.out.println("hola try");
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, "postulante");// se le asigna el valor para q se
											// inserte a la columna asignada
			stmt.setString(2, postulante.getNombre());
			stmt.setString(3, "roman reynoso");
			stmt.setString(4, postulante.getDni());

			stmt.setString(5, "0000");

			stmt.setString(6, "0111");
			stmt.setString(7, "aroman@hotmail.com");
			stmt.setString(8, "peru");
			stmt.setString(9, "Lima");
			stmt.setString(10, "Lima");

			stmt.setString(11, "los alamos");
			stmt.setInt(12, 3273208);
			stmt.setInt(13, 0);
			stmt.setString(14, "23/09/25");
			stmt.setString(15, "M");
			stmt.setString(16, "soltero");
			System.out.println("5555");
			int i = stmt.executeUpdate();// executeUpdate() devuelve un entero=#
											// de filas afectadas
			System.out.println("i=" + i);
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

	public Postulante obtener(int idPostulante) throws DAOExcepcion {
		Postulante pos = new Postulante();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			String query = "select nombrePersona, dni from PERSONA where idPERSONA=?";
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setInt(1, idPostulante);
			rs = stmt.executeQuery();
			if (rs.next()) {//
				pos.setNombre(rs.getString(1));
				pos.setDni(rs.getString(2));
				// pos.setTipoPersona(rs.getString(3));
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarResultSet(rs);
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		return pos;
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
			stmt.setString(2, postulante.getApPaterno());
			stmt.setString(3, postulante.getEmail());
			stmt.setInt(3, postulante.getIdPostulante());

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
	public Collection<Postulante> listar() throws DAOExcepcion {
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
				postulante.setApPaterno(rs.getString("apPellidos"));
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
				postulante.setApPaterno(rs.getString("apPellidos"));
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
	public void eliminar(int idPostulante) throws DAOExcepcion {
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
