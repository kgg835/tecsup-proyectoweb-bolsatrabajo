package com.proyecto.persistencia.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.proyecto.exception.DAOExcepcion;
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

}
