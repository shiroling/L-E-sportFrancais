package SAE_Esporter.src;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnexionBase {
	private final static String login = Login.getLogin();
	private final static String mdp = Login.getMdp();
	private final static String connectString = Login.getConnectString();
	
	public static Connection getConnection() {
		try {
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			Connection connx = DriverManager.getConnection(connectString, login, mdp);
			return connx;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
