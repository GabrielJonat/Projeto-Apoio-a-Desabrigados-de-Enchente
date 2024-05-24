package application.UI;

import java.util.List;
import java.util.Scanner;

import application.Programa;
import model.dao.DaoFactory;
import model.dao.PedidoDao;
import model.entities.Item;
import model.entities.Pedido;

public class pedidoUI {

	Scanner sc = new Scanner(System.in);

	PedidoDao pedidoDao = DaoFactory.createPedidoDao();

	public static void a(Scanner sc, PedidoDao pedidoDao) {
		int escolha = 1;
		boolean sair = true;

		while (sair) {

			clear();

			menu();

			escolha = sc.nextInt();

			switch (escolha) {

			case 1:

				clear();

				listarPedidos(sc, pedidoDao);

				for (int i = 0; i < 2; i++)
					sc.nextLine();

				break;

			case 2:

				clear();

				pesquisarPedidoPorId(sc, pedidoDao);

				for (int i = 0; i < 2; i++)
					sc.nextLine();

				break;

			case 3:

				clear();

				adicionarPedido(sc, pedidoDao);

				for (int i = 0; i < 2; i++)
					sc.nextLine();

				break;

			case 4:

				clear();

				atualizarPedido(sc, pedidoDao, new Pedido());

				for (int i = 0; i < 2; i++)
					sc.nextLine();

				break;

			case 5:

				clear();

				deletarAbrigo(sc, pedidoDao);

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

	public static void adicionarPedido(Scanner sc, PedidoDao pedidoDao, List<Item> items, Integer idCentro, Integer idAbrigo) {
	    System.out.println("\n=== TEST 3: pedido insert =====\n");

	    Pedido newPedido = new Pedido(null, idCentro, idAbrigo, items);
 
	    pedidoDao.insert(newPedido);

	    System.out.println("\nNew pedido inserted!\n");
	}


	public static void pesquisarPedidoPorId(Scanner sc, PedidoDao pedidoDao) {

		System.out.println("\n=== TEST 2: abrigo findById =====\n");

		System.out.print("Digite o id do pedido procurado: ");

		int id = sc.nextInt();

		Pedido pedido = pedidoDao.findById(id);

		System.out.println("\nPedido encontrado:\n\n" + pedido);

	}

	
	public static void listarPedidos(Scanner sc, PedidoDao pedidoDao) {

		clear();

		System.out.println("\n=== TEST 1: pedido findAll =====\n");

		List<Pedido> list = pedidoDao.findAll();

		for (Pedido obj : list) {
			System.out.println(obj + "\n");
		}

	}


	public static void deletarAbrigo(Scanner sc, PedidoDao pedidoDao) {

		System.out.println("\n=== TEST 5: pedido delete =====\n");

		System.out.println("Enter id for pedido test: \n");

		int id = sc.nextInt();

		pedidoDao.deleteById(id);

		System.out.println("\nDelete completed");

	}

	public static void clear() {
	    for (int i = 0; i < 50; i++) {
	        System.out.println();
	    }
	}
}
