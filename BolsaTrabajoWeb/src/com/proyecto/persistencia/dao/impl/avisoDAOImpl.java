package com.proyecto.persistencia.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.proyecto.exception.DAOExcepcion;
import com.proyecto.modelo.Aviso;
import com.proyecto.modelo.HistorialPostulaciones;
import com.proyecto.modelo.MostrarAviso;
import com.proyecto.modelo.Ofertante;
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
	
	public Collection<MostrarAviso> mostrar_aviso(int cod_aviso) throws DAOExcepcion {
		System.out.println("mostrar_aviso");
		String query = "select idAVISO,tituloAviso,fechaPublicacion,fechacaducidad,descripcion," +
				"ruc,razonSocial,correo,descEmpresa from ofertante,aviso " +
				"where aviso.idOFERTANTE=ofertante.idOFERTANTE and idAVISO="+cod_aviso;
		RowMapper mapper = new RowMapper() {
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                    MostrarAviso ma = new MostrarAviso();
                    Ofertante of=new Ofertante();
                    ma.setId_aviso(rs.getInt("idAviso"));
                    ma.setTitulo(rs.getString("tituloAviso")); 
              		ma.setFec_publicacion(rs.getDate("fechaPublicacion"));
               		ma.setFec_caduc(rs.getDate("fechacaducidad"));
                   	ma.setDescripcion(rs.getString("descripcion"));
                   	ma.setRuc(rs.getString("ruc"));
                 	ma.setRazonsocial(rs.getString("razonSocial"));
                   	ma.setCorreo(rs.getString("correo"));
                   	ma.setDescempresa(rs.getString("descEmpresa"));
                   		return ma;
            }
    };
    
    return jdbcTemplate.query(query, mapper);
}

	@SuppressWarnings(value = "unchecked")
	public Collection<Aviso> Buscar_aviso(String area,String palabra,int dias) throws DAOExcepcion {
	      System.out.println("avisoDAOIMPL:listar busqueda");
	      Calendar fecha = new GregorianCalendar();

	      int anio=fecha.getTime().getYear();
	      int mes=fecha.getTime().getMonth();
	      int dia=fecha.getTime().getDate();
	      
	      System.out.println(anio);
	      System.out.println(mes);
	      System.out.println(dia);
	      String sql = "select aviso.idAviso,aviso.tituloAviso,aviso.descripcion,aviso.fechaPublicacion," +
	      		"aviso.fechacaducidad,aviso.idOfertante,aviso.idArea from aviso,area where aviso.idarea=area.idAREA and" +
	      		" area.descripcionArea= '"+area+"' and "+dia+"-DAY(fechaPublicacion)<=+" +dias+" and (aviso.tituloAviso " +
	      		" like '%"+palabra+"%' or aviso.descripcion like '%"+palabra+"%') order by fechaPublicacion desc";
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


	
	@SuppressWarnings(value = "unchecked")
	public Collection<Aviso> listarAvisos() throws DAOExcepcion {
	      System.out.println("avisoDAOIMPL:listar avisos");
	      
	      String sql = "Select idAVISO,tituloAviso,descripcion,fechaPublicacion,fechacaducidad,idOfertante," +
	      		"idArea from aviso order by idAVISO desc";

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
