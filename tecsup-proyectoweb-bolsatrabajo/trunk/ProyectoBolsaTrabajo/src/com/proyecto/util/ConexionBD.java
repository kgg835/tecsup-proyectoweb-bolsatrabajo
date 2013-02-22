package com.proyecto.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ConexionBD {

	public static Connection obtenerConexionDirecta() throws SQLException {//cambiamos el nombre x Directa para los test

		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");//el driver de conection
			con = DriverManager.getConnection("jdbc:mysql://localhost/bd_bolsatrabajo",//cadena de coneccion
					"root", "");//"usuario","")password vacio
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	
	//copiamos este metodo para el pulp
	public static Connection obtenerConexion() throws SQLException {

		Connection con = null;
		try {
			Context initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:/comp/env");
			DataSource datasource = (DataSource) envContext
					.lookup("jdbc/bolsatrabajo");//esta pare debe de sr igualita al context
			con = datasource.getConnection();

		} catch (NamingException ex) {
			System.out.println(ex.getMessage());
			throw new SQLException("No se pudo encontrar el DataSource.");
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			throw new SQLException("No se pudo obtener una conexión.");
		}
		return con;
	}

}
