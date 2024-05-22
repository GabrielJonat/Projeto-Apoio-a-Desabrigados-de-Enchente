package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import db.DB;
import db.DbIntegrityException;
import model.entities.Doacao;

public class Programa {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		// ESTABELECENDO CONEXÃO COM O BANCO PARA INSERÇÃO DE DADOS DA TABELA ITEM
		Doacao doacao = new Doacao();
//		
//		System.out.println("Entre com o Id do item: ");
//		doacao.setId(sc.nextInt());
		
		System.out.print("Entre com o Nome do item: Roupas - Produtos de Higiene - Alimentos:\n");
		doacao.setNome(sc.nextLine());
		
		System.out.println("Entre com o tipo do item: ");
		doacao.setTipo(sc.nextLine());
		
		System.out.println("Entre com o Genero do item:");
		doacao.setGenero(sc.nextLine());
		
		System.out.println("Entre com o Nome do Tamanho: ");
		doacao.setTamanho(sc.nextLine());
		
		Connection conn = null;
		PreparedStatement st = null;
		try {
			conn = DB.getConnection();
			
			st = conn.prepareStatement(
					"INSERT INTO item"
					+ "(Nome,Tipo, Genero, Tamanho)"
					+ "VALUES"
					+ "(?,?,?,?)",
					Statement.RETURN_GENERATED_KEYS);
			
			st.setString(1,doacao.getNome());
			st.setString(2, doacao.getTipo());
			st.setString(3,doacao.getGenero());
			st.setString(4, doacao.getTamanho());
			
			int rowsAffected = st.executeUpdate();
			
			if(rowsAffected > 0) {
				
				ResultSet rs = st.getGeneratedKeys();
				while(rs.next()) {
					int id = rs.getInt(1);
					System.out.println("Done! Id = " + id);
				}
			}
			else {
				System.out.println("No rown affected!");
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			DB.closeStatement(st);
			DB.closeConnection();
		}
		
		// MÉTODO UPDATE DADOS DA TABELA ITEM
//		try {
//			
//			conn = DB.getConnection();
//			
//			st = conn.prepareStatement(
//					"UPDATE item "
//					+ "SET Tipo = ? "
//					+ "WHERE "
//					+ "id = ?");
//			
//			st.setString(1,doacao.getTipo());
//			st.setInt(2, 32);
//			int rowsAffected = st.executeUpdate();
//			
//			System.out.println("Done! Id = ");
//		}
//		catch(SQLException e) {
//			e.printStackTrace();
//		}
//		finally {
//			DB.closeStatement(st);
//			DB.closeConnection();
//		}
		
		
		// MÉTODO DELETE DADOS DA TABELA ITEM
//				try {
//					
//					conn = DB.getConnection();
//					
//					st = conn.prepareStatement(
//							"DELETE FROM item "
//							+ "WHERE "
//							+ "id = ?");
//					
//					st.setInt(1,doacao.getId());
//					
//					int rowsAffected = st.executeUpdate();
//					
//					System.out.println("Done! Rows affected = " + rowsAffected);
//				}
//				catch(SQLException e) {
//					throw new DbIntegrityException(e.getMessage());
//				}
//				finally {
//					DB.closeStatement(st);
//					DB.closeConnection();
//				}
		
	}
}
