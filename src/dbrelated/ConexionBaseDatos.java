package dbrelated;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexionBaseDatos {

	String Nombre = "jdbc:h2:~/baseDatosPractica4Wilmar";
	String Username = "";
	String Passwd = "";
	Connection conx = null;

	public ConexionBaseDatos() {

		try {
			Class.forName("org.h2.Driver");
			conx = DriverManager.getConnection(Nombre + Username + Passwd);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public Connection getConx() {
		return conx;
	}

	public void closeConx() {
		conx = null;
	}

}
