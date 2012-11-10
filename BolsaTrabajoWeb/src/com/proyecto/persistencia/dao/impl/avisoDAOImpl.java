package com.proyecto.persistencia.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.proyecto.exception.DAOExcepcion;
import com.proyecto.modelo.Aviso;
import com.proyecto.modelo.HistorialPostulaciones;
import com.proyecto.persistencia.dao.avisoDAO;


@Repository
public class avisoDAOImpl implements avisoDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public Aviso insertar(Aviso vo) throws DAOExcepcion {
		System.out.println("insertar");
		String query = "insert into aviso(tituloAviso,fechaPublicacion,fechacaducidad,idOFERTANTE,idArea" +
				",descripcion) values(?,?,?,?,?,?)";
		Object[] params = new Object[] {vo.getTitulo(), vo.getFec_publicacion(), vo.getFec_caduc(), vo.getIdOfertante(),vo.getId_area(),vo.getDescripcion()};
		try {
			jdbcTemplate.update(query, params);
		} catch (Exception e) {
			throw new DAOExcepcion(e.getMessage());
		}
		return vo;
	}
	
	public Aviso mostrar(Aviso vo) throws DAOExcepcion {
		System.out.println("insertar");
		String query = "insert into aviso(tituloAviso,fechaPublicacion,fechacaducidad,idOFERTANTE,idArea" +
				",descripcion) values(?,?,?,?,?,?)";
		Object[] params = new Object[] {vo.getTitulo(), vo.getFec_publicacion(), vo.getFec_caduc(), vo.getIdOfertante(),vo.getId_area(),vo.getDescripcion()};
		try {
			jdbcTemplate.update(query, params);
		} catch (Exception e) {
			throw new DAOExcepcion(e.getMessage());
		}
		return vo;
	}
	@SuppressWarnings(value = "unchecked")
	public Collection<Aviso> listarAvisos() throws DAOExcepcion {
	      System.out.println("avisoDAOIMPL:listar avisos");
	      
	      String sql = "Select idAVISO,tituloAviso,descripcion,fechaPublicacion,fechacaducidad,idOfertante,idArea from aviso";

	      RowMapper mapper = new RowMapper() {
	              public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
	                      Aviso vo = new Aviso();
	                      vo.setIdAviso(rs.getInt("idAviso"));
	                     vo.setTitulo(rs.getString("tituloAviso")); 
	                     		vo.setDescripcion(rs.getString("descripcion"));
	                     		vo.setFec_publicacion(rs.getDate("fechaPublicacion"));
	                     		vo.setFec_caduc(rs.getDate("fechacaducidad"));
	                     		vo.setIdOfertante(rs.getInt("idOfertante"));
	                     		vo.setId_area(rs.getInt("idArea")); 
	                     return vo;
	              }
	      };
	      
	      return jdbcTemplate.query(sql, mapper);
	}
}
