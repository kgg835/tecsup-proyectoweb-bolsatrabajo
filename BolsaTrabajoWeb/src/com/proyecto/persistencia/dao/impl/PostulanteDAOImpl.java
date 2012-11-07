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

		System.out.println("insertar");
		String query = "INSERT INTO persona(tipo_persona,nombrePersona,"
				+ "apellidosPersona,dni,email,"
				+ "pais,direccion,telefonoFijo,"
				+ "numeroCelular,fechaNacimiento,sexo,estadoCivil,"
				+ "idUsuario)" + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";// ?:por
																		// cada
		// columna
		Object[] params = new Object[] { postulante.getTipoPersona(),
				postulante.getNombre(), postulante.getApellidos(),
				postulante.getDni(), postulante.getEmail(),
				postulante.getPaisPostulante(), postulante.getDireccion(),
				postulante.getTelefonoFijo(), postulante.getTelefonoCel(),
				postulante.getFechaNacimiento(), postulante.getSexo(),
				postulante.getEstadoCivil(), postulante.getIdUsuario(), };
		try {
			jdbcTemplate.update(query, params);
			System.out.println("se Inserto correctamente...");
		} catch (Exception e) {
			throw new DAOExcepcion(e.getMessage());
		}
		return postulante;
	}

	// metodo que obtine un Postulante, por id
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Postulante obtenerPostulante(int idPostulante) throws DAOExcepcion {

		String sql = "SELECT idPERSONA,tipo_persona,"
				+ "nombrePersona,apellidosPersona,dni," + "email,pais,"
				+ "direccion,telefonoFijo,"
				+ "numeroCelular,fechaNacimiento,sexo,estadoCivil,"
				+ "idUsuario" + "FROM persona WHERE idUsuario=?";
		RowMapper mapper = new RowMapper() {

			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				Postulante postulante = new Postulante();

				postulante.setIdPostulante(rs.getInt(1));
				postulante.setTipoPersona(rs.getString(2));
				postulante.setNombre(rs.getString(3));
				postulante.setApellidos(rs.getString(4));
				postulante.setDni(rs.getString(5));
				postulante.setEmail(rs.getString(6));
				postulante.setPaisPostulante(rs.getString(7));
				postulante.setDireccion(rs.getString(8));
				postulante.setTelefonoFijo(rs.getString(9));
				postulante.setTelefonoCel(rs.getString(10));
				postulante.setFechaNacimiento(rs.getString(11));
				postulante.setSexo(rs.getString(12));
				postulante.setEstadoCivil(rs.getString(13));
				postulante.setIdUsuario(rs.getInt(14));
				return postulante;
			}
		};
		return (Postulante) jdbcTemplate.queryForObject(sql, new Object[] {
				idPostulante, "1" }, mapper);
	}

	// Metodo que Actualiza Datos Personales del Postulante
	public Postulante actualizarPostulante(Postulante postulante)
			throws DAOExcepcion {
		System.out.println("Actualizar datos del usuario");
		String query = "UPDATE persona SET nombrePersona=?,apellidosPersona=?,"
				+ "dni=?,email=?,pais=?,direccion=?,telefonoFijo=?,numeroCelular=?,"
				+ "fechaNacimiento=?,sexo=?,estadoCivil=? WHERE idPERSONA=?";
		Object[] params = new Object[] {

		postulante.getNombre(), postulante.getApellidos(), postulante.getDni(),
				postulante.getEmail(), postulante.getPaisPostulante(),
				postulante.getDireccion(), postulante.getTelefonoFijo(),
				postulante.getTelefonoCel(), postulante.getFechaNacimiento(),
				postulante.getSexo(), postulante.getEstadoCivil(),
				postulante.getIdPostulante(), };

		try {
			jdbcTemplate.update(query, params);
			System.out.println("se Actualizo correctamente...");
			return postulante;
		} catch (Exception e) {
			throw new DAOExcepcion(e.getMessage());

		}

	}
}
