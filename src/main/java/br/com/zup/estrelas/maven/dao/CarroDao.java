package br.com.zup.estrelas.maven.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.com.zup.estrelas.maven.connection.factory.ConnectionFactory;
import br.com.zup.estrelas.maven.pojo.CarroPojo;

public class CarroDao {
	private Connection conexao;
	
	public CarroDao() {
		this.conexao = new ConnectionFactory().getConnection();
	}
	
	public boolean inserirCarro(CarroPojo carroPojo) {	
		String inserirCarroSql = "INSERT INTO carro VALUES (?, ?, ?, ?)";
		
		try {
			PreparedStatement stmt = conexao.prepareStatement(inserirCarroSql);
			
			stmt.setString(1, carroPojo.getNome());
			stmt.setString(2, carroPojo.getPlaca());
			stmt.setString(3, carroPojo.getMarca());
			stmt.setInt(5, carroPojo.getAnoFabricacao());
			
			stmt.execute();
			stmt.close();	
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
		
		return true;
	}
	
	public boolean excluirCarro(String placa) {
		String deletarCarroSql = "DELETE FROM carro WHERE placa = ?";
		
		try {
			PreparedStatement stmt = conexao.prepareStatement(deletarCarroSql);
			
			stmt.setString(1, placa);
			stmt.execute();
			stmt.close();
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
		
		return true;
	}

	public CarroPojo buscarCarroPorPlaca(String placa) {
		CarroPojo carroPojo = new CarroPojo();
		
		String buscarCarroPorPlacaSql = "SELECT * FROM carro WHERE placa = ?";
		
		try {
			PreparedStatement stmt = conexao.prepareStatement(buscarCarroPorPlacaSql);
			
			stmt.setString(1, placa);
			
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				carroPojo.setNome(rs.getString("nome"));
				carroPojo.setPlaca(rs.getString("placa"));
				carroPojo.setMarca(rs.getString("placa"));
				carroPojo.setAnoFabricacao(rs.getInt("ano_fabricacao"));
			}
			
			stmt.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return carroPojo;
	}

	public List<CarroPojo> buscarCarros(){
		List<CarroPojo> listaCarros = new ArrayList<>();
		
		String listarTodosCarrosSql = "SELECT * FROM carro";
		
		try {
			PreparedStatement stmt = conexao.prepareStatement(listarTodosCarrosSql);
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				CarroPojo carroPojo = new CarroPojo();
				
				carroPojo.setNome(rs.getString("nome"));
				carroPojo.setPlaca(rs.getString("placa"));
				carroPojo.setMarca(rs.getString("placa"));
				carroPojo.setAnoFabricacao(rs.getInt("ano_fabricacao"));
				
				listaCarros.add(carroPojo);
			}
			
			stmt.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return listaCarros;
	}
}
