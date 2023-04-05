package dtr.web.management.bookshop.web.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import dtr.web.management.bookshop.web.common.DtrKey;
import dtr.web.management.bookshop.web.common.DTRExceptionDetail;

public class ConnectionDB {
	private static final String connectionUrl = "jdbc:sqlserver://DESKTOP-ARCLLSG\\SQLEXPRESS:1433;"
			+ "database=" + DtrKey.DATABASE_NAME + ";" 
			+ "user=sa;" 
			+ "password=" + DtrKey.DB_PASSWORD + ";" 
			+ "encrypt=false;"
			+ "trustServerCertificate=false;" 
			+ "loginTimeout=30;";

	public static Connection getConnectDatabase() throws Exception {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(connectionUrl);
		} catch (Exception e) {
			System.out.println(DTRExceptionDetail.DATABASE__CONNECT_NOT_SET);
			throw e;
		}
		return conn;
	}

	public static void closeConnectionDate(Connection conn) {
		try {
			if (conn != null) {
				conn.close();
			}
		} catch (final Exception e) {
			System.out.println(DTRExceptionDetail.DATABASE_EXCEPTION);
		}
	}
}
