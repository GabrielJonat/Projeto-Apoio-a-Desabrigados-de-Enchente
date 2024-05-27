package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.DB;
import db.DbException;
import model.dao.CheckoutDao;
import model.entities.Checkout;
import model.execptions.InvalideIdException;

public class CheckoutDaoJDBC implements CheckoutDao{
	
	private Connection conn;
	
	public CheckoutDaoJDBC(Connection conn) {
		this.conn = conn;
	}		
	
	@Override
	public void inserirCheckout(Checkout checkout) {
		
		PreparedStatement st = null;
		
		ResultSet rs = null;
		
		try {
			
			st = conn.prepareStatement("INSERT INTO checkout (status_pedido, id_pedido, motivo)" +
										" VALUES  (?, ?, ?);",
										Statement.RETURN_GENERATED_KEYS);
			
			st.setString(1, checkout.getStatus());
			st.setInt(2, checkout.getIdpedido());
			st.setString(3, checkout.getMotivo());
			
			 int rowsAffected = st.executeUpdate();
			 
			 if(rowsAffected > 0) {
				 
				 System.out.println("checkout inserido!");
			 }
		}
		catch(SQLException e) {
			
			throw new DbException(e.getMessage());
		}
	}
	
	@Override
	public void updateCentro(Integer idCentro, Integer idItem , Integer quantidade) {
		
		PreparedStatement st = null;
		
		try {
			st = conn.prepareStatement("UPDATE estoqueCentro SET quantidade=quantidade-? WHERE idCentro=? AND idItem=?");
			
			st.setInt(1, quantidade);
			st.setInt(2, idCentro);
			st.setInt(3, idItem);

			int rowsAffected = st.executeUpdate();
			
		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
		}
	}
	
	//mostra pedidos daquele centro
	@Override
	public List<Checkout> findPedidosByCentroID(Integer idCentro) {
		
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			st = conn.prepareStatement("SELECT checkout.id as checkout, pedido.id as numPedido, centro.nome as centro, item.nome as item, item.tipo, item.genero, item.tamanho, itempedido.quantidade "
					+ "FROM checkout  "
					+ "INNER JOIN pedido ON checkout.id_pedido = pedido.id "
					+ "INNER JOIN itempedido ON pedido.id = itempedido.id_pedido "
					+ "INNER JOIN item ON itempedido.id_item = item.id "
					+ "INNER JOIN centro ON pedido.centro_id = centro.id "
					+ " WHERE pedido.centro_id = ? AND checkout.status_pedido IS NULL"); 
			
			st.setInt(1, idCentro);
			rs = st.executeQuery();
			
			List<Checkout> checkouts =new ArrayList();  
			
			while(rs.next()) {				
				Checkout linha = new Checkout();		
				linha.setId(rs.getInt("id")); 
				linha.setIdpedido(rs.getInt("id_pedido")); 
	            //linha.setCentro(rs.getString("centro")); 
	            //linha.setItem(rs.getString("item")); 
	            //linha.setTipo(rs.getString("tipo")); 
	            //linha.setGenero(rs.getString("genero"));
	            //linha.setTamanho(rs.getInt("tamanho")); 
	            //linha.setQuantidade(rs.getInt("quantidade")); 				
				linha.setMotivo(rs.getString("motivo"));
				
				checkouts.add(linha);				
			}			
			return checkouts;

		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		catch (IllegalArgumentException e) {
			throw new InvalideIdException("Id informado não foi encontrado");
		}
		
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}

	}
	
	
	@Override
	public void updateStatus(Integer id, String status, String motivo) {
		
		PreparedStatement st = null;
		
		try {
			
			if(status.equals("Aceito")) {
				
				st = conn.prepareStatement("UPDATE checkout SET status_pedido=? WHERE id_pedido=?");
				
				st.setString(1, status);
				
				st.setInt(2, id);
			
			}
			
			else {
				
				st = conn.prepareStatement("UPDATE checkout SET status_pedido=?, motivo=? WHERE id_pedido=?");
				
				st.setString(1, status);
				
				st.setString(2, motivo);
				
				st.setInt(3, id);
				
			}

			int rowsAffected = st.executeUpdate();
			
		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
		}
	}
	
		
	@Override
	public void updateAbrigo(Integer idAbrigo, Integer idItem , Integer quantidade) {
		
		PreparedStatement st = null;
		
		try {
			st = conn.prepareStatement("INSERT INTO estoqueAbrigo (id_abrigo, id_item, quantidade) VALUES (?,?,?)",
					Statement.RETURN_GENERATED_KEYS);
			
			st.setInt(1, idAbrigo);
			st.setInt(2, idItem);
			st.setInt(3, quantidade);
			

			int rowsAffected = st.executeUpdate();
			
		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
		}
	}
	
	@Override
	public void clearEstoque() {
		
		PreparedStatement st = null;
		
		try {
			st = conn.prepareStatement("DELETE FROM estoqueCentro WHERE quantidade = 0",
					Statement.RETURN_GENERATED_KEYS);
			int rowsAffected = st.executeUpdate();
			
		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
		}
	}
	
}