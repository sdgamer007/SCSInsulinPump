package application.Helper;

import java.sql.Connection;
import java.sql.DriverManager;

public class SQLLiteConnection {
	public static Connection Connecter() {
		try {
			Class.forName("org.sqlite.JDBC");
			Connection conn = DriverManager.getConnection("jdbc:sqlite:D:\\College\\Safety-Critical-System-master\\IGP.sqlite");
					return conn;
		}catch(Exception e) {
			return null;
		}
	}
}
