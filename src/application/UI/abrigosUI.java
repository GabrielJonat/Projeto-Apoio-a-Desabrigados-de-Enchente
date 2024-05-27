package application.UI;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

import application.Programa;
import model.dao.AbrigoDao;
import model.dao.CheckoutDao;
import model.dao.DaoFactory;
import model.dao.EstoqueAbrigoDao;
import model.dao.EstoqueCentroDao;
import model.dao.ItemPedidoDao;
import model.dao.PedidoDao;
import model.dao.ItemDao;
import model.entities.Abrigo;
import model.entities.Checkout;
import model.entities.EstoqueAbrigo;
import model.entities.EstoqueCentro;
import model.entities.Item;
import model.entities.ItemPedido;
import model.entities.Pedido;

public class AbrigosUI {

    public static void a() {


        Scanner sc = new Scanner(System.in);

        AbrigoDao abrigoDao = DaoFactory.createAbrigoDao();

        PedidoDao pedidoDao = DaoFactory.createPedidoDao();

        ItemDao itemDao = DaoFactory.createItemDao();

        ItemPedidoDao itemPedidoDao = DaoFactory.createItemPedido();

        EstoqueCentroDao estoqueCentroDao = DaoFactory.createEstoqueCentroDao();

        CheckoutDao checkoutDao = DaoFactory.createCheckOutDao();

        EstoqueAbrigoDao estoqueAbrigoDao = DaoFactory.createEstoqueAbrigoDao();

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

                    fazerPedido(sc, abrigoDao, pedidoDao, itemDao, itemPedidoDao, estoqueCentroDao, checkoutDao);

                    System.out.println("Pedido cadastrado!");

                    break;

                case 7:

                    clear();

                    listarItemsRecebidos(sc, estoqueAbrigoDao);

                    break;

                case 8:

                    clear();
                    Programa.main(null);

                    for (int i = 0; i < 2; i++)

                        sc.nextLine();

                default:

                    clear();

                    System.out.println("Essa opção não existe, escolha uma entre 1 e 8.\n");
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
        System.out.println("|    6 - Fazer Pedido           |");
        System.out.println("|    7 - Listar Items           |");
        System.out.println("|    8 - Sair                   |");
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

        Integer numeroOcupacao = 0;

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

    public static void fazerPedido(Scanner sc, AbrigoDao abrigoDao, PedidoDao pedidoDao, ItemDao itemDao, ItemPedidoDao itemPedidoDao, EstoqueCentroDao estoqueCentroDao, CheckoutDao checkoutDao) {

        List<Item> items = itemDao.findAll();

        List<Item> listaPedido = new ArrayList<>();

        List<Abrigo> abrigos = abrigoDao.findAll();

        for(Abrigo abrigo : abrigos)

            System.out.println(abrigo);

        System.out.print("\nQual o id do abrigo que fará o pedido?");

        Integer id_abrigo = sc.nextInt();

        for (Item item : items)

            System.out.println(item);

        System.out.println();

        List<Integer> quantidades = new ArrayList<>();

        boolean acabou = false;

        while(!acabou) {

            System.out.println("Digite o id do item que deseja requisitar");

            Integer id = sc.nextInt();

            System.out.println("Digite a quantidade");

            Integer quant = sc.nextInt();

            quantidades.add(quant);

            listaPedido.add(itemDao.findById(id));

            System.out.print("Adicionar novo item?(S/N): ");

            String sair = sc.next();

            acabou = sair.toUpperCase().equals("S") ? false : true;

        }

        List<EstoqueCentro> estoqueEsperanca = estoqueCentroDao.findById(1);

        List<EstoqueCentro> estoqueProsperidade = estoqueCentroDao.findById(2);

        List<EstoqueCentro> estoqueReconstrucao = estoqueCentroDao.findById(3);

        Map<Integer,Integer> quantidadeEstoque = new HashMap<>();


        Integer quantidade = 0;

        for(EstoqueCentro estoqueCentro : estoqueEsperanca)

            quantidade += estoqueCentro.getQuantidade();

        quantidadeEstoque.put(1,quantidade);

        quantidade = 0;

        for(EstoqueCentro estoqueCentro : estoqueProsperidade)

            quantidade += estoqueCentro.getQuantidade();

        quantidadeEstoque.put(2,quantidade);

        quantidade = 0;

        for(EstoqueCentro estoqueCentro : estoqueReconstrucao)

            quantidade += estoqueCentro.getQuantidade();

        quantidadeEstoque.put(3,quantidade);

        Map<Integer, Integer> quantidadeOrdenada = quantidadeEstoque.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1, // Merge function (keep existing value)
                        LinkedHashMap::new // Preserve insertion order
                ));

        Integer firstKey = 1;


        Iterator<Map.Entry<Integer, Integer>> iterator = quantidadeOrdenada.entrySet().iterator();
        while(iterator.hasNext()) {
            Map.Entry<Integer, Integer> entry = iterator.next();
            firstKey = entry.getKey();}

        Pedido newPedido = new Pedido(null, id_abrigo, firstKey, listaPedido);

        Pedido pedidoRes = pedidoDao.insert(newPedido);

        for(int i = 0;  i < listaPedido.size() ; i ++) {

            itemPedidoDao.insert(new ItemPedido(null, pedidoRes.getId(), listaPedido.get(i).getId(), quantidades.get(i)));

        }

        checkoutDao.inserirCheckout(new Checkout(null, newPedido.getId(), "Pendente", null));

    }

    public static void listarItemsRecebidos(Scanner sc, EstoqueAbrigoDao estoqueAbrigoDao) {

        System.out.print("Informe o abrigo para listar os items recebidos: ");

        Integer id_abrigo = sc.nextInt();

        List<EstoqueAbrigo> estoque = estoqueAbrigoDao.findById(id_abrigo);

        if(estoque.isEmpty())

            System.out.println("\nNão há items recebidos neste abrigo\n");
        else {

            System.out.println("\nListando items: \n");


            for(EstoqueAbrigo lote : estoque) {

                System.out.println(lote);
            }

        }

        System.out.println();

        sc.nextLine();

        sc.nextLine();

    }

    public static void clear() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }
}