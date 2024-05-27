package application.UI;

import java.util.List;
import java.util.Scanner;

import application.Programa;
import model.dao.CentroDao;
import model.dao.DaoFactory;
import model.dao.EstoqueCentroDao;
import model.dao.ItemDao;
import model.dao.ItemDao;
import model.entities.Centro;
import model.entities.EstoqueCentro;
import model.entities.Item;

public class ordemUI {
    Scanner sc = new Scanner(System.in);

    public static void a(Scanner sc) {
        int escolha = 1;
        boolean sair = true;

        while (sair) {

            clear();

            menu();

            escolha = sc.nextInt();

            switch (escolha) {

                case 1:

                    clear();

                    doar();

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
                    System.out.println("Essa opção não existe, escolha uma entre 1 e 6.\n");
                    break;

            }
        }

    }

    public static void doar() {
        Scanner sc = new Scanner(System.in);

        EstoqueCentroDao estoqueCentroDao = DaoFactory.createEstoqueCentroDao();
        CentroDao centroDao = DaoFactory.createCentroDao();
        ItemDao<?> itemDao = DaoFactory.createItemDao();


        List<Centro> list = centroDao.findAll();
        for (Centro obj : list) {
            System.out.println(obj + "\n");
        }

        System.out.println("Digite o número do centro para o qual deseja doar (1, 2 ou 3)");
        Integer idCentro = sc.nextInt();
        while(idCentro != 1 && idCentro != 2 && idCentro != 3) {
            System.out.println("Numero inválido! escolha entre 1 e 3.");
            System.out.println("Digite o número novamente:");
            idCentro = sc.nextInt();
        }
        clear();

        boolean acabou = false;
        while (!acabou) {

            System.out.println("Informe o tipo do item que deseja doar");
            System.out.println("1 - Roupas\n2- Produtos de higiene\n3- Alimentos");
            Integer escolhaTipo = sc.nextInt();
            while(escolhaTipo != 1 && escolhaTipo != 2 && escolhaTipo != 3) {
                System.out.println("Numero inválido! escolha entre 1 e 3.");
                System.out.println("Digite o número novamente:");
                escolhaTipo = sc.nextInt();
            }
            clear();

            Integer id = null;

            switch(escolhaTipo) {

                case 1:
                    System.out.println("Informe o tipo de roupa que deseja doar");
                    System.out.println("1 - Agasalhos\n2- Camisas");
                    Integer escolhaNome = sc.nextInt();
                    while(escolhaNome != 1 && escolhaNome != 2) {
                        System.out.println("Numero inválido! escolha entre 1 e 3.");
                        System.out.println("Digite o número novamente:");
                        escolhaTipo = sc.nextInt();
                    }
                    clear();

                    switch(escolhaNome) {
                        case 1:
                            List<Item> itens = itemDao.findByType("AGASALHOS");
                            for (Item obj : itens) {
                                System.out.println(obj + "\n");
                            }
                            System.out.println("Digite o id do item que deseja doar");
                            id = sc.nextInt();
                            while(id < 3 || id > 14) {
                                System.out.println("Numero inválido! escolha entre os Ids disponiveis");
                                System.out.println("Digite o número novamente:");
                                id = sc.nextInt();
                            }
                            break;

                        case 2:
                            List<Item> itens2 = itemDao.findByType("CAMISAS");
                            for (Item obj : itens2) {
                                System.out.println(obj + "\n");
                            }
                            System.out.println("Digite o id do item que deseja doar");
                            id = sc.nextInt();
                            while(id < 15 || id > 26) {
                                System.out.println("Numero inválido! escolha entre os Ids disponiveis");
                                System.out.println("Digite o número novamente:");
                                id = sc.nextInt();
                            }
                            break;
                    }

                    break;

                case 2:
                    List<Item> itens2 = itemDao.findByName("PRODUTOS DE HIGIENE");
                    for (Item obj : itens2) {
                        System.out.println(obj + "\n");
                    }
                    System.out.println("Digite o id do item que deseja doar");
                    id = sc.nextInt();
                    while(id < 27 || id > 30) {
                        System.out.println("Numero inválido! escolha entre os Ids disponiveis");
                        System.out.println("Digite o número novamente:");
                        id = sc.nextInt();
                    }
                    break;

                case 3:
                    List<Item> itens3 = itemDao.findByName("ALIMENTOS");
                    for (Item obj : itens3) {
                        System.out.println(obj + "\n");
                    }
                    System.out.println("Digite o id do item que deseja doar");
                    id = sc.nextInt();
                    while(id < 31 || id > 35) {
                        System.out.println("Numero inválido! escolha entre os Ids disponiveis");
                        System.out.println("Digite o número novamente:");
                        id = sc.nextInt();
                    }
                    break;
            }

            System.out.println("Digite a quantidade");
            Integer quant = sc.nextInt();

            estoqueCentroDao.insert(new EstoqueCentro(idCentro, id, quant));

            System.out.print("Continuar doando?(S/N): ");
            acabou = !sc.next().toUpperCase().equals("S");
        }

        System.out.println("Estoque Atualizado: \n");
        List<EstoqueCentro> estoque = estoqueCentroDao.findById(idCentro);

        for (EstoqueCentro produto : estoque) {
            System.out.println(produto);
        }

        a(sc);
        sc.close();

    }




    public static void menu() {

        System.out.println("+-------------------------------+");
        System.out.println("|                               |");
        System.out.println("|          FAZER PEDIDO         |");
        System.out.println("|                               |");
        System.out.println("|           COMPASS.UOL         |");
        System.out.println("|                               |");
        System.out.println("|                               |");
        System.out.println("| Informe a opção desejada:     |");
        System.out.println("|                               |");
        System.out.println("|    1 - Fazer doação           |");
        System.out.println("|    2 - Voltar                 |");
        System.out.println("|                               |");
        System.out.println("+-------------------------------+");
        System.out.print("\nDigite sua opção: ");
    }

    public static void clear() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }

}
