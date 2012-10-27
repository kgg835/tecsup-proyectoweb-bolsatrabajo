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

}
