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
import model.dao.CheckoutDao;
import model.dao.DaoFactory;
import model.dao.EstoqueCentroDao;
import model.dao.ItemPedidoDao;
import model.dao.PedidoDao;
import model.dao.ItemDao;
import model.entities.Checkout;
import model.entities.EstoqueCentro;
import model.entities.Item;
import model.entities.ItemPedido;
import model.entities.Pedido;

public class CheckoutUI {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        CheckoutDao checkoutDao = DaoFactory.createCheckOutDao();
        ItemPedidoDao itemPedidoDao = DaoFactory.createItemPedido();
        PedidoDao pedidoDao = DaoFactory.createPedidoDao();
        EstoqueCentroDao estoqueCentroDao = DaoFactory.createEstoqueCentroDao();
        ItemDao itemDao = DaoFactory.createItemDao();
        checkoutDao.clearEstoque();
        a(sc, checkoutDao, itemPedidoDao, pedidoDao, estoqueCentroDao, itemDao);
    }
    public static void a(Scanner sc, CheckoutDao checkoutDao, ItemPedidoDao itemPedidoDao, PedidoDao pedidoDao, EstoqueCentroDao estoqueCentroDao, ItemDao itemDao) {
        int escolha = 1;
        boolean sair = true;

        while (sair) {

            clear();

            menu();

            escolha = sc.nextInt();

            switch (escolha) {

                case 1:

                    clear();

                    listarPedidosPorCentro(sc, checkoutDao, itemPedidoDao, pedidoDao, estoqueCentroDao, itemDao);

                    for (int i = 0; i < 2; i++)
                        sc.nextLine();

                    break;
                case 2:
                    clear();
                    Programa.main(null);

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
        System.out.println("|2 - Sair                       |");
        System.out.println("|                               |");
        System.out.println("+-------------------------------+");
        System.out.print("\nDigite sua opção: ");
    }

    public static void listarPedidosPorCentro(Scanner sc, CheckoutDao checkoutDao, ItemPedidoDao itemPedidoDao, PedidoDao pedidoDao, EstoqueCentroDao estoqueCentroDao, ItemDao itemDao) {

        System.out.println("\n=== Escolha o seu Centro de Distribuição pelo número dele =====\n");
        System.out.println("| 1 - Centro de Distribuição Esperança     |");
        System.out.println("| 2 - Centro de Distribuição Prosperidade  |");
        System.out.println("| 3 - Centro de Distribuição Reconstrução  |");

        System.out.print("Insira o número: ");

        int idCentro = sc.nextInt();
        List<Pedido> pedidos = pedidoDao.findByCentro(idCentro);

        for (Pedido pedido : pedidos)
            System.out.println("\n" + pedido );
        if(pedidos.size() == 0) {
            System.out.println("Não há pedidos disponíveis para este Centro.");
            return;
        }
        System.out.print("\nQual pedido deseja administrar? ");
        Integer id_pedido = sc.nextInt();
        System.out.println("\nItens do pedido selecionado: \n");
        List<ItemPedido> itemsPedido = itemPedidoDao.findByPedido(id_pedido);
        for(ItemPedido item : itemsPedido)

            System.out.println("\n" + item + "\n");
        System.out.print("\nDeseja aceitar este pedido? (s/n): ");
        String answear = sc.next();
        if(answear.toUpperCase().equals("S")) {
            checkoutDao.updateStatus(id_pedido, "Aceito", null);
            List<ItemPedido> listaPedido = itemPedidoDao.findByPedido(id_pedido);
            List<EstoqueCentro> estoque = estoqueCentroDao.findById(idCentro);
            List<Integer> idsItems = new ArrayList<>();
            List<ItemPedido> restantes = new ArrayList<>();
            int cont = 0;
            for(EstoqueCentro item : estoque) {
                idsItems.add(item.getIdtem());
            }
            int qntde = listaPedido.size();
            for(int i = 0; i < qntde; i++) {
                if(!idsItems.contains(listaPedido.get(i).getId_item())) {
                    restantes.add(listaPedido.get(i));
                    listaPedido.remove(i);
                }
            }

            for(EstoqueCentro item : estoque) {
                try {
                    if(listaPedido.get(cont).getQuantidade() > item.getQuantidade())
                        listaPedido.get(cont).setQuantidade(item.getQuantidade());
                }
                catch(RuntimeException e) {
                    break;}
                cont ++;
            }
            for(int i = 0; i < listaPedido.size(); i++) {
                checkoutDao.updateCentro(idCentro, listaPedido.get(i).getId_item(), listaPedido.get(i).getQuantidade());
            }
            System.out.println("\nEstoque Atualizado com Sucesso");
            Pedido pedido = pedidoDao.findById(id_pedido);
            for(int i = 0; i < listaPedido.size(); i++) {
                checkoutDao.updateAbrigo(pedido.getId_abrigo(), listaPedido.get(i).getId_item(), listaPedido.get(i).getQuantidade());
            }
            System.out.println("\nPedido Aceito!\n");
            if(restantes.size() > 0) {
                System.out.println("\nAlguns items não foram entregues, um novo pedido será criado para contempla-los!\n");
                Pedido pedidoOrig = pedidoDao.findById(id_pedido);
                Integer id_abrigo = pedidoOrig.getId_abrigo();
                pedirRestante(id_abrigo, restantes, estoqueCentroDao, pedidoDao, itemPedidoDao, checkoutDao, itemDao);
            }
        }

        else {
            System.out.print("Informe o motivo da recusa: ");
            String motivo = sc.next();
            checkoutDao.updateStatus(id_pedido, "Negado", motivo);
            System.out.println("\nPedido negado!\n");
        }
    }
    public static void pedirRestante(Integer id_abrigo, List<ItemPedido> lista, EstoqueCentroDao estoqueCentroDao, PedidoDao pedidoDao, ItemPedidoDao itemPedidoDao, CheckoutDao checkoutDao, ItemDao itemDao) {
        List<EstoqueCentro> estoqueEsperanca = estoqueCentroDao.findById(1);
        List<EstoqueCentro> estoqueProsperidade = estoqueCentroDao.findById(2);
        List<EstoqueCentro> estoqueReconstrucao = estoqueCentroDao.findById(3);
        Map<Integer,Integer> quantidadeEstoque = new HashMap<>();
        List<Item> listaRestantes = new ArrayList<>();
        for(int i = 0; i < lista.size(); i++)
            listaRestantes.add(itemDao.findById(lista.get(i).getId_item()));

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
        Pedido newPedido = new Pedido(null, id_abrigo, firstKey, listaRestantes);
        Pedido pedidoRes = pedidoDao.insert(newPedido);
        for(int i = 0;  i < listaRestantes.size() ; i ++) {
            itemPedidoDao.insert(new ItemPedido(null, pedidoRes.getId(), listaRestantes.get(i).getId(), lista.get(i).getQuantidade()));
        }
        checkoutDao.inserirCheckout(new Checkout(null, newPedido.getId(), "Pendente", null));

    }
    public static void clear() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }

    }
}