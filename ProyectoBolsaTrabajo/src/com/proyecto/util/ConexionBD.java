package com.proyecto.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {

	public static Connection obtenerConexion() throws SQLException {

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
}
