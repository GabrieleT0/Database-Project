package ecommerce;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class ConnectionPool {

	private static List<Connection> freeDbConnections;

	static {
		freeDbConnections = new LinkedList<Connection>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("DB driver not found \n");
			System.out.println(e);
		} 
	}

	private static Connection createDBConnection() throws SQLException {
		Connection newConnection = null;
		String ip = "localhost";
		String port = "3306";
		String db = "ecommerce";
		String username = "gabriele";
		String password = "123456";
		String params = "?serverTimezone=UTC&useLegacyDatetimeCode=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&zeroDateTimeBehavior=CONVERT_TO_NULL&autoReconnect=true";

		newConnection = DriverManager.getConnection("jdbc:mysql://"+ ip+":"+ port+"/"+db+params, username, password);

		newConnection.setAutoCommit(false);
		return newConnection;
	}

	public static synchronized Connection getConnection() throws SQLException {
		Connection connection;

		if (!freeDbConnections.isEmpty()) {
			connection = (Connection) freeDbConnections.get(0);
			ConnectionPool.freeDbConnections.remove(0);

			try {
				if (connection.isClosed())
					connection = ConnectionPool.getConnection();
			} catch (SQLException e) {
				connection = ConnectionPool.getConnection();
			}
		} else {
			connection = ConnectionPool.createDBConnection();
		}

		return connection;
	}

	public static synchronized void releaseConnection(Connection connection) {
		ConnectionPool.freeDbConnections.add(connection);
	}
}