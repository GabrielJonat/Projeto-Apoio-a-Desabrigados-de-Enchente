package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.DB;
import db.DbException;
import model.dao.CheckoutDao;
import model.dao.estoqueCentro;
import model.entities.Abrigo;
import model.entities.Checkout;
import model.entities.Item;
import model.entities.Pedido;

public class CheckoutDaoJDBC implements CheckoutDao{
	
	private Connection conn;
	
	public CheckoutDaoJDBC(Connection conn) {
		this.conn = conn;
	}		
	
	//mostra pedidos daquele centro
	@Override
	public List<Pedido> findPedidosByCentroID(Integer idCentro) {
		
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			st = conn.prepareStatement("SELECT pedido.id as numPedido, centro.nome as centro, abrigo.nome as abrigo, item.nome as item, item.tipo, item.genero, item.tamanho, itempedido.quantidade"
					+ "FROM checkout "
					+ "INNER JOIN pedido ON checkout.id_pedido = pedido.id"
					+ "INNER JOIN itempedido ON pedido.id = itempedido.id_pedido"
					+ "INNER JOIN item ON itempedido.id_item = item.id"
					+ "INNER JOIN centro ON pedido.centro_id = centro.id"
					+ " WHERE pedido.centro_id = ? AND checkout.status_pedido IS NULL"); 
			
			st.setInt(1, idCentro);
			rs = st.executeQuery();
			
			List<Checkout> checkouts =new ArrayList();  
			
			while(rs.next()) {				
				Checkout linha = new EstoqueAbrigo();				
				linha.setId(rs.getInt("numPedido")); 
	            linha.setCentro(rs.getString("centro")); 
	            linha.setAbrigo(rs.getString("abrigo"));
	            linha.setItem(rs.getString("item")); 
	            linha.setTipo(rs.getString("tipo")); 
	            linha.setGenero(rs.getString("genero"));
	            linha.setTamanho(rs.getString("tamanho")); 
	            linha.setQuantidade(rs.getInt("quantidade")); 				
							
				checkouts.add(linha);				
			}			
			return checkouts;

		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		
		finally {
			DB.closeStatement(st);
		}

	}
	
	
	@Override
	public void UpdateStatus(Integer id, Boolean status) {
		
		PreparedStatement st = null;
		
		try {
			st = conn.prepareStatement("UPDATE checkout SET status_pedido=? WHERE id=?");
			
			st.setInt(1, status);
			st.setInt(2, id);

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
			st = conn.prepareStatement("UPDATE estoqueAbrigo SET quantidade=quantidade+? WHERE id_abrigo=? AND id_item=?");
			
			st.setInt(1, quantidade);
			st.setInt(2, idAbrigo);
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