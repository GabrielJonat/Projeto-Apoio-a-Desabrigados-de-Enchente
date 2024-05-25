package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.dao.CheckoutDao;
import model.dao.DaoFactory;
import model.dao.EstoqueCentroDao;
import model.dao.ItemPedidoDao;
import model.dao.PedidoDao;
import model.entities.EstoqueCentro;
import model.entities.ItemPedido;
import model.entities.Pedido;

public class Test {
	
	public static void main(String[] args) {
		
	Scanner sc = new Scanner(System.in);

	CheckoutDao checkoutDao = DaoFactory.createCheckOutDao();		
	
	ItemPedidoDao itemPedidoDao = DaoFactory.createItemPedido();
	
	PedidoDao pedidoDao = DaoFactory.createPedidoDao();
	
	EstoqueCentroDao estoqueCentroDao = DaoFactory.createEstoqueCentroDao();
	
	a(sc, checkoutDao, itemPedidoDao, pedidoDao, estoqueCentroDao);
	
	}
	public static void a(Scanner sc, CheckoutDao checkoutDao, ItemPedidoDao itemPedidoDao, PedidoDao pedidoDao, EstoqueCentroDao estoqueCentroDao) {
	
		int escolha = 1;
		
		boolean sair = true;

		while (sair) {

			clear();

			menu();

			escolha = sc.nextInt();

			switch (escolha) {

			case 1:

				clear();

				listarPedidosPorCentro(sc, checkoutDao, itemPedidoDao, pedidoDao, estoqueCentroDao);

				for (int i = 0; i < 2; i++)
					sc.nextLine();

				break;
			
			default:
				
				clear();
				
				System.out.println("Essa opção não existe, escolha uma entre 1 e 7.\n");					
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
		System.out.println("|1 - Lista de pedidos pendentes |");
		System.out.print("\nDigite sua opção: ");
	}
	
	
	public static void listarPedidosPorCentro(Scanner sc, CheckoutDao checkoutDao, ItemPedidoDao itemPedidoDao, PedidoDao pedidoDao, EstoqueCentroDao estoqueCentroDao) {

		System.out.println("\n=== Escolha o seu Centro de Distribuição pelo número dele =====\n");
		System.out.println("| 1 - Centro de Distribuição Esperança     |");
		System.out.println("| 2 - Centro de Distribuição Prosperidade  |");
		System.out.println("| 3 - Centro de Distribuição Reconstrução  |");

		System.out.print("Insira o número: ");

		int idCentro = sc.nextInt();
		
		List<Pedido> pedidos = pedidoDao.findByCentro(idCentro);

		for (Pedido pedido : pedidos)
	   
	        System.out.println(pedido+ "\n");
	        
	        System.out.print("Qual pedido deseja aceitar? (s/n): ");
	        
	        Integer id_pedido = sc.nextInt();
	        
	        checkoutDao.updateStatus(id_pedido, "Aceito");

	        List<EstoqueCentro> estoqueCentro = estoqueCentroDao.findById(idCentro);
	        
	        List<ItemPedido> listaPedido = itemPedidoDao.findByPedido(id_pedido);
	        
	        	        
	        for(int i = 0; i < listaPedido.size(); i++) {
	        	
	        	checkoutDao.updateCentro(idCentro, listaPedido.get(i).getId_item(), listaPedido.get(i).getQuantidade());
	        	
	        }
	        
	        System.out.println("Estoque Atualizado com Sucesso");
	      
	        /*
	        if ("s".equalsIgnoreCase(resposta)) {
	            System.out.println("Pedido aceito.");
	            
	            checkoutDao.updateAbrigo(obj.getId_abrigo(), obj.getId_item(), obj.getQuantidade());
	            checkoutDao.updateCentro(obj.getId_centro(), obj.getId_item(), obj.getQuantidade());
	            checkoutDao.updateStatus(obj.getId(), true);
	            break; 
	            
	        } else if ("n".equalsIgnoreCase(resposta)) {
	            System.out.println("Pedido recusado. Verificando o próximo pedido...\n");
	            checkoutDao.updateStatus(obj.getId(), false);
	            
	        } else {
	            System.out.println("Resposta inválida. Por favor, insira 's' para sim ou 'n' para não.");
	            i--;
	        }
	    }
*/
	        System.out.println("Pedido Aceito!");
	        
	        
	}
	
	public static void clear() {
	    for (int i = 0; i < 50; i++) {
	        System.out.println();
	    }

	}
}