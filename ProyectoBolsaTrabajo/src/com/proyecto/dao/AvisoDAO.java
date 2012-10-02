package com.proyecto.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import com.proyecto.exception.DAOExcepcion;
import com.proyecto.modelo.Aviso;
import com.proyecto.util.ConexionBD;

public class AvisoDAO extends BaseDAO {
	public Aviso insertar(Aviso vo) throws DAOExcepcion{
		String query="Insert into aviso(OFERTANTE_idOFERTANTE,PUESTO_LABORAL_idPUESTO_LABORAL,tituloAviso,fechaPublicacion,fechacaducidad) values(?,?,?,?,?)";
		Connection con=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
	
		
		try{
			con=ConexionBD.obtenerConexion();
			stmt=con.prepareStatement(query);
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			String f_publi=sdf.format(vo.getFec_publicacion());
			String f_caduc=sdf.format(vo.getFec_caduc());
			stmt.setInt(1, vo.getIdOfertante());
			stmt.setInt(2, vo.getId_puesto());
			stmt.setString(3, vo.getTitulo());
			stmt.setString(4,f_publi);
			stmt.setString(5, f_caduc);
		
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
