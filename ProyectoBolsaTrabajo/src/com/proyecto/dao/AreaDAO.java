package com.proyecto.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.proyecto.exception.DAOExcepcion;
import com.proyecto.modelo.Area;
import com.proyecto.util.ConexionBD;

public class AreaDAO extends BaseDAO {
	public Area insertar(Area vo) throws DAOExcepcion{
		String query="Insert into area(descripcionArea) values(?)";
		Connection con=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try{
			con=ConexionBD.obtenerConexion();
			stmt=con.prepareStatement(query);
			stmt.setString(1, vo.getDescripcion());
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
