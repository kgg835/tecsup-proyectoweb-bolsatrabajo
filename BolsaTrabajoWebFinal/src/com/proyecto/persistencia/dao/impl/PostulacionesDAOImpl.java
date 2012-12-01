package com.proyecto.persistencia.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;


import com.proyecto.exception.DAOExcepcion;
import com.proyecto.modelo.HistorialPostulaciones;
import com.proyecto.persistencia.dao.PostulacionesDAO;

@Repository
public class PostulacionesDAOImpl implements PostulacionesDAO{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	@Override
	public HistorialPostulaciones insertarPostulacion(HistorialPostulaciones vo) throws DAOExcepcion {
	      System.out.println("insertar");
	      String query = "Insert into postulacion(TituloAviso,NombreEmpresa,FechaPostulacion,Estado) values(?,?,?,?)";
	      Object[] params = new Object[] { vo.getTituloAviso(),vo.getNombreEmpresa(),vo.getFechpostulacion(),vo.getEstado() };
	      try {
	              jdbcTemplate.update(query, params);
	      } catch (Exception e) {
	              throw new DAOExcepcion(e.getMessage());
	      }
	      return vo;
	}



@SuppressWarnings(value = "unchecked")
public Collection<HistorialPostulaciones> listarPostulaciones() throws DAOExcepcion {
      System.out.println("PostulacionDaoImpl: listarTodos()");
      
      String sql = "Select idPostulacion,TituloAviso,NombreEmpresa,FechaPostulacion,Estado from postulacion order by idPostulacion ";

      RowMapper mapper = new RowMapper() {
              public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                      HistorialPostulaciones vo = new HistorialPostulaciones();
                      vo.setIdpostulacion(rs.getInt("idPostulacion"));
                     vo.setTituloAviso(rs.getString("TituloAviso")); 
                     		vo.setNombreEmpresa(rs.getString("NombreEmpresa"));
                     		vo.setFechpostulacion(rs.getString("FechaPostulacion"));
                     		vo.setEstado(rs.getString("Estado"));
                     
                     return vo;
              }
      };
      return jdbcTemplate.query(sql, mapper);
}
}