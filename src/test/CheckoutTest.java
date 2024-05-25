
public class CheckoutTest {
	
	public static void main(String[] args) {
		
	Scanner sc = new Scanner(System.in);

	CheckoutDao checkoutDao = DaoFactory.createCheckoutDao();		
	
	a(sc, checkoutDao);
	
	}
	public static void a(Scanner sc, ) {
		int escolha = 1;
		boolean sair = true;

		while (sair) {

			clear();

			menu();

			escolha = sc.nextInt();

			switch (escolha) {

			case 1:

				clear();

				findPedidosByCentroID(sc, checkoutDao);

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
	
	
	public static void listarPedidosPorCentro(Scanner sc, CheckoutDao checkoutDao) {

		System.out.println("\n=== Escolha o seu Centro de Distribuição pelo número dele =====\n");
		System.out.println("| 1 - Centro de Distribuição Esperança     |");
		System.out.println("| 2 - Centro de Distribuição Prosperidade  |");
		System.out.println("| 3 - Centro de Distribuição Reconstrução  |");

		System.out.print("Insira o número: ");

		int idCentro = sc.nextInt();
		
		List<Checkout> list = checkoutDao.findPedidosByCentroID(idCentro);

		for (int i = 0; i < list.size(); i++) {
	        Checkout obj = list.get(i);
	        System.out.println(obj + "\n");
	        
	        System.out.print("Deseja aceitar este pedido? (s/n): ");
	        String resposta = sc.next();

	        if ("s".equalsIgnoreCase(resposta)) {
	            System.out.println("Pedido aceito.");
	            Checkout.updateAbrigo(obj.getIdAbrigo(), obj.getIdItem(), obj.getQuantidade());
	            Checkout.updateCentro(obj.getIdCentro(), obj.getIdItem(), obj.getQuantidade());
	            Checkout.UpdateStatus(obj.getIdCheckout, true);
	            break; 
	            
	        } else if ("n".equalsIgnoreCase(resposta)) {
	            System.out.println("Pedido recusado. Verificando o próximo pedido...\n");
	            Checkout.UpdateStatus(obj.getIdCheckout(), false);
	            
	        } else {
	            System.out.println("Resposta inválida. Por favor, insira 's' para sim ou 'n' para não.");
	            i--;
	        }
	    }

	}

	}