package application;

import java.util.List;
import java.util.Scanner;

import model.dao.doacaoDao;
import model.dao.impl.DaoFactory;
import model.entities.Doacao;

public class Programa2 {
	
	public static void main(String[] args) {
		
	Scanner sc = new Scanner(System.in);
		
		doacaoDao doacaoDao = DaoFactory.createDoacaoDao();
	
//		System.out.println("=== TEST 1: doacao findById =====");
//		Doacao doacao = doacaoDao.findById(29);
//		System.out.println(doacao);
		

//		System.out.println("\n=== TEST 3: doacao findAll =====");
//		List<Doacao> listDocao = doacaoDao.findAll();
//		for (Doacao obj : listDocao) {
//			System.out.println(obj);
//		}

//		System.out.println("\n=== TEST 4: doacao insert =====");
//		Doacao doacao = new Doacao(null, "Alimentos", "Feijão",null, null);
//		doacaoDao.insert(doacao);
//		System.out.println("Inserted! New id = " + doacao.getId());

		
//		System.out.println("\n=== TEST 5: doacao update =====");
////		doacao = doacaoDao.findById(28);
////		doacao.setNome();
//		doacaoDao.update(29, "Produtos de Higiene");
//		System.out.println("Update completed");
////
//		System.out.println("\n=== TEST 6: doacao delete =====");
//		System.out.println("Enter id for delete test: ");
//		int id = sc.nextInt();
//		doacaoDao.deleteById(id);
//		System.out.println("Delete completed");
		
		sc.close();
	}
}
