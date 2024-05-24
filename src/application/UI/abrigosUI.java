package application.UI;

import java.util.List;
import java.util.Scanner;

import model.dao.AbrigoDao;
import model.dao.DaoFactory;
import model.entities.Abrigo;
import application.*;

public class abrigosUI {
	Scanner sc = new Scanner(System.in);

	AbrigoDao abrigoDao = DaoFactory.createAbrigoDao();

	public static void a(Scanner sc, AbrigoDao abrigoDao) {
		int escolha = 1;
		boolean sair = true;

		while (sair) {

			clear();

			menu();

			escolha = sc.nextInt();

			switch (escolha) {

			case 1:

				clear();

				listarAbrigos(sc, abrigoDao);

				for (int i = 0; i < 2; i++)
					sc.nextLine();

				break;

			case 2:

				clear();

				pesquisarAbrigoPorId(sc, abrigoDao);

				for (int i = 0; i < 2; i++)
					sc.nextLine();

				break;

			case 3:

				clear();

				adicionarAbrigo(sc, abrigoDao);

				for (int i = 0; i < 2; i++)
					sc.nextLine();

				break;

			case 4:

				clear();

				atualizarAbrigo(sc, abrigoDao, new Abrigo());

				for (int i = 0; i < 2; i++)
					sc.nextLine();

				break;

			case 5:

				clear();

				deletarAbrigo(sc, abrigoDao);

				for (int i = 0; i < 2; i++)
					sc.nextLine();

				break;

			case 6:

				clear();

				Programa.main(null);

				for (int i = 0; i < 2; i++)
					sc.nextLine();

				break;

			default:
				
				clear();
				System.out.println("Essa opção não existe, escolha uma entre 1 e 6.\n");					
				break;

			}
		}
	}

	public static void menu() {

		System.out.println("+-------------------------------+");
		System.out.println("|                               |");
		System.out.println("|            ABRIGOS	        |");
		System.out.println("|                               |");
		System.out.println("|           COMPASS.UOL         |");
		System.out.println("|                               |");
		System.out.println("|                               |");
		System.out.println("| Informe a opção desejada:     |");
		System.out.println("|                               |");
		System.out.println("|    1 - Listar Abrigos         |");
		System.out.println("|    2 - Pesquisar Abrigo       |");
		System.out.println("|    3 - Adicionar Abrigo       |");
		System.out.println("|    4 - Atualizar Abrigo       |");
		System.out.println("|    5 - Deletar Abrigo         |");
		System.out.println("|    6-  Voltar                 |");
		System.out.println("|                               |");
		System.out.println("+-------------------------------+");
		System.out.print("\nDigite sua opção: ");
	}

	public static void adicionarAbrigo(Scanner sc, AbrigoDao abrigoDao) {

		System.out.println("\n=== TEST 3: abrigo insert =====\n");

		System.out.print("Insira o nome do abrigo: ");

		String nome = sc.next();

		System.out.print("Insira o nome do responsável pelo abrigo: ");

		sc.nextLine();

		String responsavel = sc.nextLine();

		System.out.print("Insira o email do abrigo: ");

		String email = sc.next();

		System.out.print("Insira o telefone do abrigo: ");

		String telefone = sc.next();

		System.out.print("Insira o logradouro do abrigo: ");

		String logradouro = sc.next();

		System.out.print("Insira o numero do logradouro: ");

		sc.nextLine();

		Integer numero = sc.nextInt();

		System.out.print("Insira o numero da ocupação: ");

		Integer numeroOcupacao = sc.nextInt();

		Abrigo newAbrigo = new Abrigo(null, nome, responsavel, logradouro, numero, telefone, email, numeroOcupacao);

		System.out.println();

		abrigoDao.insert(newAbrigo);

		System.out.println("\nNew Abrigo inserted!\n");

	}

	public static void pesquisarAbrigoPorId(Scanner sc, AbrigoDao abrigoDao) {

		System.out.println("\n=== TEST 2: abrigo findById =====\n");

		System.out.print("Digite o id do abrigo procurado: ");

		int id = sc.nextInt();

		Abrigo abrigo = abrigoDao.findById(id);

		System.out.println("\nAbrigo encontrado:\n\n" + abrigo);

	}

	public static void listarAbrigos(Scanner sc, AbrigoDao abrigoDao) {

		clear();

		System.out.println("\n=== TEST 1: abrigo findAll =====\n");

		List<Abrigo> list = abrigoDao.findAll();

		for (Abrigo obj : list) {
			System.out.println(obj + "\n");
		}

	}

	public static void atualizarAbrigo(Scanner sc, AbrigoDao abrigoDao, Abrigo abrigo) {

		System.out.println("\n=== TEST 4: abrigo update =====");

		System.out.print("\nDigite o id do abrigo que deseja atualizar: \n\n");

		int id = sc.nextInt();

		abrigo = abrigoDao.findById(id);

		System.out.println(
				"\nDigite os dados atualizados do novo abrigo separando os por ponto e virgula nesta ordem: nome, responsável email, telefone logradouro, numero e ocupação\n");

		sc.nextLine();

		String[] args = sc.nextLine().split(";");

		abrigo.setNome(args[0]);

		abrigo.setResponsavel(args[1]);

		abrigo.setEmail(args[2]);

		abrigo.setTelefone(args[3]);

		abrigo.setLogradouro(args[4]);

		abrigo.setNumero(Integer.parseInt(args[5]));

		abrigo.setNumOcupacao(Integer.parseInt(args[6]));

		abrigoDao.update(abrigo);

		System.out.println("\nUpdate completed");
	}

	public static void deletarAbrigo(Scanner sc, AbrigoDao abrigoDao) {

		System.out.println("\n=== TEST 5: abrigo delete =====\n");

		System.out.println("Enter id for delete test: \n");

		int id = sc.nextInt();

		abrigoDao.deleteById(id);

		System.out.println("\nDelete completed");

	}

	public static void clear() {
	    for (int i = 0; i < 50; i++) {
	        System.out.println();
	    }
	}

}
