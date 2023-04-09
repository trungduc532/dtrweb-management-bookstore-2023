package dtr.web.management.bookshop.dao.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import dtr.web.management.bookshop.web.common.DtrKey;
import dtr.web.management.bookshop.web.common.DTRExceptionDetail;

public class ConnectiondDb {

	private static final String connectionUrl = "jdbc:sqlserver://DESKTOP-ARCLLSG\\SQLEXPRESS:1433;" + "database="
			+ DtrKey.DATABASE_NAME + ";" + "user=sa;" + "password=" + DtrKey.DB_PASSWORD + ";" + "encrypt=false;"
			+ "trustServerCertificate=false;" + "loginTimeout=50;";

	public static Connection getConnectDatabase() throws Exception {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(connectionUrl);
			return conn;
		} catch (Exception e) {
			System.out.println(DTRExceptionDetail.DATABASE_CONNECT_NOT_SET);
			throw e;
		}
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
