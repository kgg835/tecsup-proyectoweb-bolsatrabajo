package com.proyecto.persistencia.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.proyecto.exception.DAOExcepcion;
import com.proyecto.modelo.Postulante;
import com.proyecto.persistencia.dao.PostulanteDAO;
@Repository
public class PostulanteDAOImpl implements PostulanteDAO{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	@Override
	public Postulante obtenerPostulante(int idPostulante) throws DAOExcepcion {
		// TODO Auto-generated method stub
		String sql= "SELECT idPERSONA,tipo_persona,"
			+ "nombrePersona,apellidosPersona,dni,"
			+ "codPersona,passwordPe,email,pais,"
			+ "provincia,ciudad,direccion,telefonoFijo,"
			+ "numeroCelular,fechaNacimiento,sexo,estadoCivil,"
			+ "idUsuario,PER_idPRESENTACION,PER_idPREFERENCIAS_SALARIALES "
			+ "FROM persona WHERE idUsuario=?";
		RowMapper mapper = new RowMapper() {
			
	        public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
	            Postulante postulante=new Postulante();
	            
				postulante.setIdPostulante(rs.getInt(1));
				postulante.setTipoPersona(rs.getString(2));
				postulante.setNombre(rs.getString(3));
				postulante.setApellidos(rs.getString(4));
				postulante.setDni(rs.getString(5));
				postulante.setCodPostulante(rs.getString(6));
				postulante.setPasswordPE(rs.getString(7));
				postulante.setEmail(rs.getString(8));
				postulante.setPaisPostulante(rs.getString(9));
				postulante.setProvinciaPostulante(rs.getString(10));
				postulante.setCiudadPostulante(rs.getString(11));
				postulante.setDireccion(rs.getString(12));
				postulante.setTelefonoFijo(rs.getString(13));
				postulante.setTelefonoCel(rs.getString(14));
				postulante.setFechaNacimiento(rs.getString(15));
				postulante.setSexo(rs.getString(16));
				postulante.setEstadoCivil(rs.getString(17));
				postulante.setIdPostulante(rs.getInt(18));
				postulante.setIdPresentacion(rs.getInt(19));
				postulante.setIdPreferencia_Salarial(rs.getInt(20));
	            return postulante;
	        }
		};
		return (Postulante)jdbcTemplate.queryForObject(sql, new Object[] {idPostulante, "1" }, mapper);
	}	

}
