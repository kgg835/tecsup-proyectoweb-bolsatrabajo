package com.proyecto.dao;


import java.sql.*;


import com.proyecto.exception.DAOExcepcion;
import com.proyecto.modelo.Ofertante;
import com.proyecto.util.ConexionBD;

public class OFERTANTEDAO extends BaseDAO {
public Ofertante insertar(Ofertante vo) throws DAOExcepcion{
	String query="Insert into ofertante values(?,?,?,?,?,?,?)";
	Connection con=null;
	PreparedStatement stmt=null;
	ResultSet rs=null;
	try{
		con=ConexionBD.obtenerConexion();
		stmt=con.prepareStatement(query);
		stmt.setString(2, vo.getRuc());
		stmt.setString(3, vo.getRazonsocial());
		stmt.setString(4, vo.getCorreo());
		stmt.setString(5, vo.getDescempresa());
		stmt.setString(6, vo.getUsuario());
		stmt.setString(7, vo.getPassword());
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
}
