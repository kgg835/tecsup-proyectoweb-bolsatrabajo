package com.proyecto.persistencia.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.proyecto.exception.DAOExcepcion;
import com.proyecto.modelo.Aviso;


@Repository
public class avisoDAOImpl implements avisoDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public Aviso insertar(Aviso vo) throws DAOExcepcion {
		System.out.println("insertar");
		String query = "insert into aviso(AVI_idOFERTANTE,AVI_idPUESTO_LABORAL,codArea,tituloAviso" +
				",fechaPublicacion,fechacaducidad,desc_aviso) values(?,?,?,?,?,?,?)";
		Object[] params = new Object[] { vo.getIdOfertante(), vo.getId_puesto(),vo.getId_area(),vo.getTitulo(), vo.getFec_publicacion(), vo.getFec_caduc(),vo.getDescripcion()};
		try {
			jdbcTemplate.update(query, params);
		} catch (Exception e) {
			throw new DAOExcepcion(e.getMessage());
		}
		return vo;
	}
}
