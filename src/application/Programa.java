package application;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import db.DB;
import java.util.Scanner;

import model.dao.AbrigoDao;
import model.dao.DaoFactory;
import model.dao.EstoqueCentroDao;
import application.UI.*;

public class Programa {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int escolha = 1;
		boolean sair = true;
		clear();
		while(sair) {
			menu();
			escolha = sc.nextInt();
			switch(escolha) {
				case 1:
					AbrigosUI.a();
					for(int i = 0; i < 2; i++)
						sc.nextLine();
					break;
				case 2:
					clear();
					ItemUI.a(sc);
					break;
				case 3:
					clear();
					ordemUI.a(sc);
					break;
				case 4:
					clear();
					CheckoutUI.main(null);
					break;
				case 5:
					clear();
					sair = false;
					break;
				default:
					clear();
					System.out.println("Essa opção não existe, escolha uma entre 1 e 6.\n");
					break;
			}
		}
		System.out.println("Tchau!");
		sc.close();
	}
	public static void menu() {

		System.out.println("+-----------------------------------+");
		System.out.println("|                                   |");
		System.out.println("|          CENTRO DE DOAÇÕES        |");
		System.out.println("|                                   |");
		System.out.println("|            COMPASS.UOL            |");
		System.out.println("|                                   |");
		System.out.println("|                                   |");
		System.out.println("|  Informe a opção desejada:        |");
		System.out.println("|                                   |");
		System.out.println("|     1 - Abrigos                   |");
		System.out.println("|     2 - Doações                   |");
		System.out.println("|     3 - Ordem de pedido           |");
		System.out.println("|     4 - Checkout de itens         |");
		System.out.println("|     5 - Sair do programa          |");
		System.out.println("|                                   |");
		System.out.println("+-----------------------------------+");
		System.out.print("\nDigite sua opção: ");
	}
	public static void clear() {
		for (int i = 0; i < 50; i++) {
			System.out.println();
		}
	}

}