package br.com.zup.estrelas.maven;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.zup.estrelas.maven.connection.factory.ConnectionFactory;

public class ProgramaPrincipal {

	public static void main(String[] args) {
		try {
			Connection conexao = new ConnectionFactory().getConnection();

			System.out.println("Conectado com sucesso");
			conexao.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}

}
