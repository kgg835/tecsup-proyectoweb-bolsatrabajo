package com.proyecto.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;



import com.proyecto.exception.DAOExcepcion;
import com.proyecto.modelo.HistorialPostulaciones;

import com.proyecto.util.ConexionBD;


public class HistorialPostulacionesDAO extends BaseDAO {
	
		
	public Collection<HistorialPostulaciones> listarpostulaciones() throws DAOExcepcion {
		
			String query = "Select idPostulacion,TituloAviso,NombreEmpresa,FechaPostulacion,Estado from postulacion order by idPostulacion";
			Collection<HistorialPostulaciones> c = new ArrayList<HistorialPostulaciones>();
			Connection con = null;
			PreparedStatement stmt = null;
			ResultSet rs = null;
			try {
				con = ConexionBD.obtenerConexion();
				stmt = con.prepareStatement(query);
				rs = stmt.executeQuery();
				while (rs.next()) {
					HistorialPostulaciones vo = new HistorialPostulaciones();
					vo.setIdpostulacion(rs.getInt("idPostulacion"));				
					vo.setTituloAviso(rs.getString("TituloAviso"));
					vo.setNombreEmpresa(rs.getString("NombreEmpresa"));
					vo.setFechpostulacion(rs.getString("FechaPostulacion"));
					vo.setEstado(rs.getString("Estado"));
		
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


public HistorialPostulaciones insertar(HistorialPostulaciones vo) throws DAOExcepcion{
	String query="Insert into postulacion(TituloAviso,NombreEmpresa,FechaPostulacion,Estado) values(?,?,?,?)";
	Connection con=null;
	PreparedStatement stmt=null;

	ResultSet rs=null;
	try{
		con=ConexionBD.obtenerConexion();
		stmt=con.prepareStatement(query);
		stmt.setString(1, vo.getTituloAviso());
		stmt.setString(2, vo.getNombreEmpresa());
		stmt.setString(3, vo.getFechpostulacion());
		stmt.setString(4, vo.getEstado());
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