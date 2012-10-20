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
	
		
	public Collection<HistorialPostulaciones> obtenerPostulaciones(String idPostulacion) throws DAOExcepcion {
		Collection<HistorialPostulaciones> l = new ArrayList<HistorialPostulaciones>();
		
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String query;
		try {
			 
				// System.out.println("En las otras " + tipo);
				query = "Select o.descempresa,a.tituloAviso,a.fechapublicacion,r.fechpostulacion,r.Estado " +
						" from ofertante o , aviso a , registropostulacion r " +
						" r.idPostulacion='" + idPostulacion + "' order by r.idpostulacion asc"; 
				
								
			 con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			// stmt.setString(1, codigo_persona);
			rs = stmt.executeQuery();
			while (rs.next()) {
				HistorialPostulaciones vo = new HistorialPostulaciones();
					
				vo.setDescempresa(rs.getString("descempresa"));
				vo.setTituloAviso(rs.getString("tituloAviso"));
				vo.setFechapublicacion(rs.getString("fechapublicacion"));
				vo.setFechpostulacion(rs.getString("fechapostulacion"));
				vo.setEstado(rs.getString("Estado"));
						 			    
			l.add(vo);
			    		   
			   
						} 
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarResultSet(rs);
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		return l;
	}
}
