package fr.m2i.blog.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BlogConnection {

	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		Class.forName("org.hsqldb.jdbcDriver");

		String url = "jdbc:hsqldb:mem:blog";
		//String url = "jdbc:hsqldb:hsql://localhost/blog";
		String user = "sa";
		String password = "";

		Connection c = DriverManager.getConnection(url, user, password);
		return c;
	}

	public static void closeConnection(Connection c) throws SQLException {
		c.close();
	}
}
