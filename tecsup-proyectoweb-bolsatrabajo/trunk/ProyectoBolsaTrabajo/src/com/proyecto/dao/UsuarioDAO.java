package com.proyecto.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import com.proyecto.exception.DAOExcepcion;
import com.proyecto.modelo.Postulante;
import com.proyecto.modelo.Rol;
import com.proyecto.modelo.Usuario;
import com.proyecto.util.ConexionBD;

public class UsuarioDAO extends BaseDAO{
	//Metodo para Ingresar un Usuario 
	public Usuario insertarUsuario(Usuario usuario) throws DAOExcepcion {
		String query = "insert into usuario(nombreUsuario,passwordUsuario,idROL) values (?,?,?)";
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, usuario.getNombreUsuario());
			stmt.setString(2, usuario.getPasswordUsuario());
			stmt.setInt(3,usuario.getIdRol());
//			stmt.setString(1, vo.getNombre());
//			stmt.setString(2, vo.getDescripcion());
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
			usuario.setIdUsuario(id);

		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarResultSet(rs);
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		return usuario;
	}
	
	//Obtiene el Usuario deacuerdo al ID
	public Usuario obtenerUsuario(int idUsuario) throws DAOExcepcion {
		Usuario usuario = new Usuario();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			String query = "SELECT idUsuario,nombreUsuario,passwordUsuario,idROL FROM usuario WHERE idUsuario=?";
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setInt(1,idUsuario);
			rs = stmt.executeQuery();
			if (rs.next()) {
				usuario.setIdUsuario(rs.getInt(1));
				usuario.setNombreUsuario(rs.getString(2));
				usuario.setPasswordUsuario(rs.getString(3));
				usuario.setIdRol(rs.getInt(4));
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarResultSet(rs);
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		return usuario;
	}
	
	//Obtiene el idUsuario 
	public int obteneridUsuario(Usuario user) throws DAOExcepcion {
		Usuario usuario=new Usuario();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			String query = "SELECT idUsuario FROM usuario WHERE nombreUsuario=? AND passwordUsuario=?";
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
		//	stmt.setInt(1,idUsuario);
			stmt.setString(1,user.getNombreUsuario());
			stmt.setString(2,user.getPasswordUsuario());
			rs = stmt.executeQuery();
			if (rs.next()) {
				usuario.setIdUsuario(rs.getInt(1));
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarResultSet(rs);
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		return usuario.getIdUsuario();
	}
	
	//Obtiene el Rol del Usuario 
	public String obtenerRol(int idRol) throws DAOExcepcion {
		Rol rol=new Rol();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			String query = "Select r.tipoRol from rol r,usuario u where u.idUsuario =? AND r.idROL = u.idROL";
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
		//	stmt.setInt(1,idUsuario);
			stmt.setInt(1,idRol);
			rs = stmt.executeQuery();
			if (rs.next()) {
				rol.setTipoRol(rs.getString(1));
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarResultSet(rs);
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		return rol.getTipoRol();
	}
//	//obtener Rol de Usuario
//	public Collection<Usuario> listarUsuario() throws DAOExcepcion {
//		Collection<Usuario> c = new ArrayList<Usuario>();
//		Connection con = null;
//		PreparedStatement stmt = null;
//		ResultSet rs = null;
//		try {
//			con = ConexionBD.obtenerConexion();
//			String query = "select idPERSONA,tipo_persona,nombrePersona,"
//					+ "apPellidos,dni,codPersona,passwordPe,email,pais,provincia,"
//					+ "ciudad,direccion,telefonoFijo,numeroCelular,fechaNacimiento,"
//					+ "sexo,estadoCivil " + "from PERSONA "
//					+ "order by nombrePersona";
//			stmt = con.prepareStatement(query);
//			rs = stmt.executeQuery();// me extrae los datos de tabla Persona x
//										// Columna
//			while (rs.next()) {// Aqui se llena los datos en el objeto
//								// Postulante
//				Postulante postulante = new Postulante();
//				postulante.setIdPostulante(rs.getInt("idPERSONA"));
//				postulante.setTipoPersona(rs.getString("tipo_persona"));
//				postulante.setNombre(rs.getString("nombrePersona"));
//				postulante.setApellidos(rs.getString("apPellidos"));
//				postulante.setDni(rs.getString("dni"));
//				postulante.setCodseleccion(rs.getString("codPersona"));
//				postulante.setPasswordPE(rs.getString("passwordPe"));
//				postulante.setEmail(rs.getString("email"));
//				// postulante.setPais();
//				// postulante.setprovincia();
//				// postulante.setCiudad();
//				postulante.setDireccion(rs.getString("direccion"));
//				postulante.setTelefonoFijo(rs.getString("telefonoFijo"));
//				postulante.setTelefonoCel(rs.getString("numeroCelular"));
//				postulante.setFechaNacimiento(rs.getString("fechaNacimiento"));
//				postulante.setSexo(rs.getString("sexo"));
//				postulante.setEstadoCivil(rs.getString("estadoCivil"));
//
//				// vo.setIdCategoria(rs.getInt("id_categoria"));
//				// vo.setNombre(rs.getString("nombre"));
//				// vo.setDescripcion(rs.getString("descripcion"));
//				c.add(postulante);
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
}
