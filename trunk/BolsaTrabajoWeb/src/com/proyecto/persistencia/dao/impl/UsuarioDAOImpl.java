package com.proyecto.persistencia.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.proyecto.exception.DAOExcepcion;
import com.proyecto.modelo.Rol;
import com.proyecto.modelo.Usuario;
import com.proyecto.persistencia.dao.UsuarioDAO;

@Repository
public class UsuarioDAOImpl implements UsuarioDAO{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	@Override
	public Usuario insertarUsuario(Usuario usuario) throws DAOExcepcion {
		
        System.out.println("insertar");
        String query="insert into usuario(nombreUsuario,passwordUsuario,idROL) values (?,?,?)";
       // String query = "INSERT INTO usuario (id_usuario,clave,nombres,paterno,materno,correo,direccion, telefono,estado) "
                       // + "VALUES (?,?,?,?,?,?,?,?,?)";
//        Object[] params = new Object[] { vo.getIdUsuario(), vo.getClave(),
//                        vo.getNombres(), vo.getPaterno(), vo.getMaterno(),
//                        vo.getCorreo(), vo.getDireccion(), vo.getTelefono(),
//                        vo.getEstado() };
        Object[] params=new Object[]{ usuario.getNombreUsuario(),usuario.getPasswordUsuario(),usuario.getIdRol()};
        
        try {
                jdbcTemplate.update(query, params);
        } catch (Exception e) {
                throw new DAOExcepcion(e.getMessage());
        }
        return usuario;

	}
	
	@Override
	public int obteneridUsuario(Usuario user) throws DAOExcepcion {

        String sql = "SELECT idUsuario FROM usuario WHERE nombreUsuario=? AND passwordUsuario=?";

        RowMapper mapper = new RowMapper() {

                public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Usuario usuario = new Usuario();
                        usuario.setIdUsuario(rs.getInt("idUsuario"));
                        return usuario.getIdUsuario();
                }
        };
        Usuario usu=(Usuario)jdbcTemplate.queryForObject(sql, new Object[] {user.getNombreUsuario(),user.getPasswordUsuario() }, mapper);
        return usu.getIdUsuario(); 
	}
	
	//Obtiene el Rol del Usuario 
	public String obtenerRol(int idRol) throws DAOExcepcion {
		
		String sql = "Select r.tipoRol from rol r,usuario u where u.idUsuario =? AND r.idROL = u.idROL";
		RowMapper mapper=new RowMapper() {

			@Override
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				Rol rol=new Rol();
				rol.setTipoRol(rs.getString("tipoRol"));
				return rol.getTipoRol();
			}
		
		};	
		
		return (String)jdbcTemplate.queryForObject(sql, new Object[]{idRol,"1"},mapper);
	}

}
