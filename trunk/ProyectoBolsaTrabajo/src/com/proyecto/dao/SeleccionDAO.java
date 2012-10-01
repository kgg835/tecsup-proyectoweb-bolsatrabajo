package com.proyecto.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import com.proyecto.exception.DAOExcepcion;
import com.proyecto.modelo.Ofertante;
import com.proyecto.modelo.Persona;
import com.proyecto.modelo.Seleccion;
import com.proyecto.util.ConexionBD;

public class SeleccionDAO extends BaseDAO {
	public Seleccion insertar(Seleccion vo) throws DAOExcepcion{
		String query="Insert into seleccion_postulante(AVISO_idAVISO,AVISO_OFERTANTE_idOFERTANTE,codPostulante) values(?,?,?)";
		Connection con=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try{
			con=ConexionBD.obtenerConexion();
			stmt=con.prepareStatement(query);
			stmt.setInt(1, vo.getCodaviso());
			stmt.setInt(2, vo.getCodofertante());
			stmt.setInt(3, vo.getCodpostulante());
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
	
	
//public Collection<Seleccion> obtener(int idaviso) throws DAOExcepcion{
//	Collection<Persona> c=new ArrayList<Persona>();
//	Persona vo = new Persona();
//	Connection con = null;
//	PreparedStatement stmt = null;
//	ResultSet rs = null;
//	try {
//		String query = "select seleccion_postulante.codPostulante, persona.nombrePersona from seleccion_postulante, persona where AVISO_idAVISO=? and seleccion_postulante.codPostulante=persona.idPersona";
//		con = ConexionBD.obtenerConexion();
//		stmt = con.prepareStatement(query);
//		stmt.setInt(1, idaviso);
//		rs = stmt.executeQuery();
//		if (rs.next()) {
//			vo.set(rs.getInt(1));
//			vo.set;
//		
//		}
//	} catch (SQLException e) {
//		System.err.println(e.getMessage());
//		throw new DAOExcepcion(e.getMessage());
//	} finally {
//		this.cerrarResultSet(rs);
//		this.cerrarStatement(stmt);
//		this.cerrarConexion(con);
//	}
//	return vo;
//}
}
