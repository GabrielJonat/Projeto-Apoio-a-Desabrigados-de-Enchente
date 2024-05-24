package application;

import java.util.ArrayList;
import java.util.List;
//import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.EstoqueCentroDao;
import model.dao.itemDao;
import model.entities.EstoqueCentro;
import model.entities.Item;

public class Program2 {

		
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		EstoqueCentroDao estoqueCentroDao = DaoFactory.createEstoqueCentroDao();
		
		itemDao<?> itemDao = DaoFactory.createItemDao();
			
		List<Item> items = itemDao.findAll();
		
		System.out.println("Digite o id do centro para o qual deseja doar");
		
		Integer idCentro  = sc.nextInt();
		
		for (Item item : items)
			
			System.out.println(item);
		
		System.out.println();
		
		boolean acabou = true;
		
		while(!acabou) {
		
			System.out.println("Digite os id do item que deseja doar");
		
			Integer id = sc.nextInt();
			
			System.out.println("Digite a quantidade");
			
			Integer quant = sc.nextInt();
		
			estoqueCentroDao.insert(new EstoqueCentro(idCentro, id, quant));
			
			System.out.print("Continuar doando?(S/N): ");
			
			acabou = sc.next().toUpperCase().equals('S') ?  false : true;
	}
		
		System.out.println("Estoque Atualizado: \n");
		
		List<EstoqueCentro> estoque = estoqueCentroDao.findById(idCentro);
		
		for (EstoqueCentro produto : estoque)
			
			System.out.println(produto);
		
		
		sc.close();
		
	}
	
}