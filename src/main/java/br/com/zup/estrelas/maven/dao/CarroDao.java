package br.com.zup.estrelas.maven.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.zup.estrelas.maven.connection.factory.ConnectionFactory;
import br.com.zup.estrelas.maven.pojo.Carro;

public class CarroDao {
	private EntityManager manager;
	
	public CarroDao() {
		this.manager = Persistence.createEntityManagerFactory("carros").createEntityManager();
	}
	
	public void inserirCarroBD(Carro carro) {		
		manager.getTransaction().begin();
		manager.persist(carro);
		manager.getTransaction().commit();
	}
	
	public boolean excluirCarroBD(String placa) {
		Carro carro = manager.find(Carro.class, placa);
		if(carro != null) {
			manager.getTransaction().begin();
			manager.remove(carro);
			manager.getTransaction().commit();
			return true;
		}
		
		return false;
	}

	public List<Carro> buscarCarrosBD(){				
		return manager.createQuery("select c from Carro as c").getResultList();
	}
	
	public List<Carro> buscarCarroPorPlacaBD(String placa) {
		Query query = manager.createQuery("select c from Carro as c where c.placa = :placa");
		
		query.setParameter("placa", placa);
		
		List<Carro> listaCarros = query.getResultList();
		
		return listaCarros;
	}

	public List<Carro> buscarCarroPorFabricanteBD(String fabricante) {
		Query query = manager.createQuery("select c from Carro as c where c.fabricante = :fabricante");
		
		query.setParameter("fabricante", fabricante);
		
		List<Carro> listaCarros = query.getResultList();
		
		return listaCarros;
	}
	
}
