package br.com.zup.estrelas.maven;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import br.com.zup.estrelas.maven.connection.factory.ConnectionFactory;
import br.com.zup.estrelas.maven.dao.CarroDao;
import br.com.zup.estrelas.maven.pojo.CarroPojo;

public class ProgramaPrincipal {

	private static final String MENU_PRINCIPAL = ("========== SISTEMA CONTROLE DE CARROS (SCC) ==========\n" +
			"[1] - Cadastrar carro \n[2] - Excluir carro \n[3] - Buscar todos os carros \n[4] - Buscar carro por placa \n[0] - Sair");
	
	public static void cadastrarCarro(Scanner teclado) {
		teclado.nextLine();
		
		System.out.print("Digite o nome: ");
		String nome = teclado.nextLine();
		
		System.out.print("Digite a placa: ");
		String placa = teclado.nextLine();
		
		System.out.print("Digite a marca: ");
		String marca = teclado.nextLine();
		
		System.out.print("Digite o ano de fabrica��o: ");
		int anoFabricacao = teclado.nextInt();
		
		CarroPojo carroPojo = new CarroPojo(nome, placa, marca, anoFabricacao);
		
		CarroDao carroDao = new CarroDao();
		
		if(carroDao.inserirCarroBD(carroPojo)) {
			System.out.println("Carro cadastrado com sucesso!");
		}
	}
	
	public static void excluirCarro(Scanner teclado) {
		teclado.nextLine();
		
		System.out.print("Digite o numero da placa: ");
		String placa = teclado.nextLine();
		
		CarroDao carroDao = new CarroDao();
		
		if (carroDao.excluirCarroBD(placa)) {
			System.out.println("Carro excluido com sucesso");
		}
	}
	
	public static void buscarCarros() {
		CarroDao carroDao = new CarroDao();
		
		List<CarroPojo> listaCarros = carroDao.buscarCarrosBD();
		
		for (CarroPojo carroPojo : listaCarros) {
			System.out.printf("Nome: %s | Placa: %s | Marca: %s | Ano Fabrica�ao: %d\n", 
					carroPojo.getNome(), carroPojo.getPlaca(), carroPojo.getMarca(), carroPojo.getAnoFabricacao());
		}
	}
	
	public static void buscarCarroPorPlaca(Scanner teclado) {
		teclado.nextLine();
		
		System.out.print("Digite o numero da placa: ");
		String placa = teclado.nextLine();
		
		CarroDao carroDao = new CarroDao();
		
		CarroPojo carroPojo = carroDao.buscarCarroPorPlacaBD(placa);
		
		System.out.printf("Nome: %s | Placa: %s | Marca: %s | Ano Fabrica�ao: %d\n", 
				carroPojo.getNome(), carroPojo.getPlaca(), carroPojo.getMarca(), carroPojo.getAnoFabricacao());
	}
	
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		int opcaoMenu = 0;
		
		do {
			System.out.println(MENU_PRINCIPAL);
			
			System.out.print("Escolha uma op��o: ");
			opcaoMenu = teclado.nextInt();
			
			switch (opcaoMenu) {
			case 1:
				cadastrarCarro(teclado);
				break;

			case 2:
				excluirCarro(teclado);
				break;
				
			case 3:
				buscarCarros();
				break;
				
			case 4:
				buscarCarroPorPlaca(teclado);
				break;
				
			case 0:
				System.out.println("Volte sempre :)");
				break;
			default:
				System.out.println("Op��o invalida");
				break;
			}
			
		} while (opcaoMenu != 0);

		teclado.close();
	}
}
