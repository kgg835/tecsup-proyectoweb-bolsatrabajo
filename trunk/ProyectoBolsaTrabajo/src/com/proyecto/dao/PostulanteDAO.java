package com.proyecto.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

import com.proyecto.exception.DAOExcepcion;
import com.proyecto.modelo.Postulante;
import com.proyecto.util.ConexionBD;

public class PostulanteDAO extends BaseDAO {
	public Postulante insertar(Postulante postulante)throws DAOExcepcion {
		System.out.println("hola");
		String query = "insert into PERSONA(tipo_persona,nombrePersona," +
				"apPellidos,dni,codPersona,passwordPe,email,pais," +
				"provincia,ciudad,direccion,telefonoFijo,numeroCelular," +
				"fechaNacimiento,sexo,estadoCivil)"
				+ " values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		Connection con = null;
		PreparedStatement stmt = null;//sentencias preparadas
		ResultSet rs = null;
		try {
			System.out.println("hola try");
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1,"postulante");//se le asigna el valor para q se inserte
			stmt.setString(2, postulante.getNombre());
			stmt.setString(3,"roman reynoso");
			stmt.setString(4,postulante.getDni());
			
			stmt.setString(5,"0000");
			
			stmt.setString(6,"0111");
			stmt.setString(7,"aroman@hotmail.com");
			stmt.setString(8,"peru");
			stmt.setString(9,"Lima");
			stmt.setString(10,"Lima");
			
			stmt.setString(11,"los alamos");
			stmt.setInt(12,3273208);
			stmt.setInt(13,0);
			stmt.setString(14,"23/09/25");
			stmt.setString(15,"M");
			stmt.setString(16,"soltero");
			System.out.println("5555");
			int i = stmt.executeUpdate();//executeUpdate() devuelve un entero=# de filas afectadas
			System.out.println("i="+i);
			if (i != 1) {
				throw new SQLException("No se pudo insertar al Postulante");
			}
			// Obtener el ultimo id
			int id = 0;
			query = "select last_insert_id()";
			stmt = con.prepareStatement(query);
			rs = stmt.executeQuery();//devuelve un ResultSet= a una tabla
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
				//pos.setTipoPersona(rs.getString(3));
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
	
	public Postulante actualizar(Postulante postulante) throws DAOExcepcion{
		
		return null;
	}
	
	public Collection<Postulante> listar() throws DAOExcepcion{
		return null;
	}
	
	public Collection<Postulante> buscarPorNombre(String nombre){
		return null;
	}

	//Metodo para eliminar un Postulante 
	public void eliminar(int idPostulante) throws DAOExcepcion{
		String query = "delete from PERSONA WHERE idPERSONA=?";
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = ConexionBD.obtenerConexion();//para la conection
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
