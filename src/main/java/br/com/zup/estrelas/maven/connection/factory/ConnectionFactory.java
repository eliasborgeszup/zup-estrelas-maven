package br.com.zup.estrelas.maven.connection.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	public Connection getConnection() {
		try {
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/banco_estrelas?user=root"
					+ "&password=root&useTimezone=true&serverTimezone=UTC");

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
