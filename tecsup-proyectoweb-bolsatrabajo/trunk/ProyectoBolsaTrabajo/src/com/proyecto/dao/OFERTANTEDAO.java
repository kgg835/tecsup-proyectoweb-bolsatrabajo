package com.proyecto.dao;


import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;






import com.proyecto.exception.DAOExcepcion;
import com.proyecto.modelo.Ofertante;
import com.proyecto.util.ConexionBD;

public class OFERTANTEDAO extends BaseDAO {
public Ofertante insertar(Ofertante vo) throws DAOExcepcion{
	String query="Insert into ofertante(ruc,razonSocial,correo,descEmpresa,usuarioOf,passwordOf) values(?,?,?,?,?,?)";
	Connection con=null;
	PreparedStatement stmt=null;

	ResultSet rs=null;
	try{
		con=ConexionBD.obtenerConexion();
		stmt=con.prepareStatement(query);
		stmt.setString(1, vo.getRuc());
		stmt.setString(2, vo.getRazonsocial());
		stmt.setString(3, vo.getCorreo());
		stmt.setString(4, vo.getDescempresa());
		stmt.setString(5, vo.getUsuario());
		stmt.setString(6, vo.getPassword());
		int i=stmt.executeUpdate();
		if(i!=1)
		{
			throw new SQLException("No se pudo insertar");
		}
		int id=0;
		query="select last_insert_id()";
		stmt=con.prepareStatement(query);
		rs=stmt.executeQuery();
		if(rs.next())
		{
			id=rs.getInt(1);
		}
		return vo;
		
		
	}
	catch(SQLException e){
		System.out.println(e.getMessage());
		throw new DAOExcepcion(e.getMessage());
}finally{this.cerrarResultSet(rs);
this.cerrarStatement(stmt);
this.cerrarConexion(con);
	
}
	
}

public Ofertante obtener(int idofertante) throws DAOExcepcion{


	Ofertante vo = new Ofertante();
	Connection con = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;
	try {
		String query = "select idOFERTANTE, ruc,razonsocial,correo,descEmpresa,usuarioOf,passwordOf from Ofertante where idOFERTANTE = ?";
		con = ConexionBD.obtenerConexion();
		stmt = con.prepareStatement(query);
		stmt.setInt(1, idofertante);
		rs = stmt.executeQuery();
		if (rs.next()) {
			vo.setidofertante(rs.getInt(1));
			vo.setRuc(rs.getString(2));
			vo.setRazonsocial(rs.getString(3));
			vo.setCorreo(rs.getString(4));
			vo.setDescempresa(rs.getString(5));
			vo.setUsuario(rs.getString(6));
			vo.setPassword(rs.getString(7));
		
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


public void eliminar(int idofertante) throws DAOExcepcion{
	String query = "delete from Ofertante WHERE idofertante=?";
	Connection con = null;
	PreparedStatement stmt = null;
	try {
		con = ConexionBD.obtenerConexion();
		stmt = con.prepareStatement(query);
		stmt.setInt(1, idofertante);
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


public Collection<Ofertante> listar() throws DAOExcepcion{
	Collection<Ofertante> c = new ArrayList<Ofertante>();
	Connection con = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;
	try {
		con = ConexionBD.obtenerConexion();
		String query = "select idofertante,ruc,razonSocial,correo,descEmpresa,usuarioOf,passwordOf from Ofertante order by razonSocial";
		stmt = con.prepareStatement(query);
		rs = stmt.executeQuery();
		while (rs.next()) {
			Ofertante vo = new Ofertante();
			vo.setidofertante(rs.getInt("idofertante"));
			vo.setRuc(rs.getString("ruc"));
			vo.setRazonsocial(rs.getString("razonsocial"));
			vo.setCorreo(rs.getString("correo"));
			vo.setDescempresa(rs.getString("descempresa"));
			vo.setUsuario(rs.getString("usuarioof"));
			vo.setPassword(rs.getString("passwordof"));
			c.add(vo);
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



}