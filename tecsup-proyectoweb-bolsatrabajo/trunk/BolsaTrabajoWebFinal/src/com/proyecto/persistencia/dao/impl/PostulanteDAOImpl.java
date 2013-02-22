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
public class PostulanteDAOImpl implements PostulanteDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	// Metodo que inserta un postulante
	public Postulante insertarPostulante(Postulante postulante)
			throws DAOExcepcion {

		System.err.println("insertar");
		String query = "INSERT INTO persona(tipo_persona,nombrePersona,"
				+ "apellidosPersona,dni,email,"
				+ "pais,direccion,telefonoFijo,"
				+ "numeroCelular,fechaNacimiento,sexo,estadoCivil,"
				+ "idUsuario)" + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";// ?:por
																		// cada
		// columna
		Object[] params = new Object[] { postulante.getTipoPersona(),
				postulante.getNombrePersona(), postulante.getApellidosPersona(),
				postulante.getDni(), postulante.getEmail(),
				postulante.getPaisPostulante(), postulante.getDireccion(),
				postulante.getTelefonoFijo(), postulante.getTelefonoCel(),
				postulante.getFechaNacimiento(), postulante.getSexo(),
				postulante.getEstadoCivil(), postulante.getIdUsuario(), };
		try {
			jdbcTemplate.update(query, params);
			System.err.println("se Inserto correctamente...");
		} catch (Exception e) {
			throw new DAOExcepcion(e.getMessage());
		}
		return postulante;
	}

	// metodo que obtine un Postulante, por id
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Postulante obtenerPostulante(int idPostulante) throws DAOExcepcion {
		System.err.println("PostulanteDAO==obtenerPostulante");
		String sql = "SELECT idPERSONA,tipo_persona,"
				+ "nombrePersona,apellidosPersona,dni," + "email,pais,"
				+ "direccion,telefonoFijo,"
				+ "numeroCelular,fechaNacimiento,sexo,estadoCivil,"
				+ "idUsuario " + "FROM persona WHERE idUsuario=?";
		RowMapper mapper = new RowMapper() {

			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				Postulante postulante = new Postulante();

				postulante.setIdPostulante(rs.getInt("idPERSONA"));
				postulante.setTipoPersona(rs.getString("tipo_persona"));
				postulante.setNombrePersona(rs.getString("nombrePersona"));
				postulante.setApellidosPersona(rs.getString("apellidosPersona"));
				postulante.setDni(rs.getString("dni"));
				postulante.setEmail(rs.getString("email"));
				postulante.setPaisPostulante(rs.getString("pais"));
				postulante.setDireccion(rs.getString("direccion"));
				postulante.setTelefonoFijo(rs.getString("telefonoFijo"));
				postulante.setTelefonoCel(rs.getString("numeroCelular"));
				postulante.setFechaNacimiento(rs.getString("fechaNacimiento"));
				postulante.setSexo(rs.getString("sexo"));
				postulante.setEstadoCivil(rs.getString("estadoCivil"));
				postulante.setIdUsuario(rs.getInt("idUsuario"));
				return postulante;
			}
		};
		return (Postulante) jdbcTemplate.queryForObject(sql, new Object[] {
				idPostulante}, mapper);
	}

	// Metodo que Actualiza Datos Personales del Postulante
	public Postulante actualizarPostulante(Postulante postulante)
			throws DAOExcepcion {
		System.err.println("Metodo:actualizarPostulante");
		String query = "UPDATE persona SET nombrePersona=?,apellidosPersona=?,"
				+ "dni=?,email=?,pais=?,direccion=?,telefonoFijo=?,numeroCelular=?,"
				+ "fechaNacimiento=?,sexo=?,estadoCivil=? WHERE idPERSONA=?";
		Object[] params = new Object[] {

				postulante.getNombrePersona(),postulante.getApellidosPersona(), postulante.getDni(),
				postulante.getEmail(), postulante.getPaisPostulante(),
				postulante.getDireccion(), postulante.getTelefonoFijo(),
				postulante.getTelefonoCel(), postulante.getFechaNacimiento(),
				postulante.getSexo(), postulante.getEstadoCivil(),postulante.getIdPostulante()};

		try {
			jdbcTemplate.update(query, params);
			System.err.println("se Actualizo correctamente...");
			return postulante;
		} catch (Exception e) {
			throw new DAOExcepcion(e.getMessage());

		}

	}
}
