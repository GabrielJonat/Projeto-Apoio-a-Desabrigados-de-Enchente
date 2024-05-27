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
import model.dao.ItemPedidoDao;
import model.entities.ItemPedido;
import model.entities.Pedido;

public class ItemPedidoDaoJDBC implements ItemPedidoDao{

	private Connection conn;
	
	// FORÇAR A INJEÇÃO DE DEPÊNDENCIAS DENTRO DA CONEXÃO
		
		
		public ItemPedidoDaoJDBC(Connection conn) {
		this.conn = conn;
	    }


		@Override
		public void insert(ItemPedido obj) {
		    PreparedStatement st = null;
		    try {
		        st = conn.prepareStatement(
		            "INSERT INTO itemPedido "
		            + "(id_pedido, id_item, quantidade) "
		            + "VALUES "
		            + "(?, ?, ?)",
		            Statement.RETURN_GENERATED_KEYS);

		        st.setInt(1, obj.getId_pedido());
		        st.setInt(2, obj.getId_item());
		        st.setInt(3, obj.getQuantidade());
		        
		        int rowsAffected = st.executeUpdate();

		        if (rowsAffected > 0) {
		            ResultSet rs = st.getGeneratedKeys();
		            if (rs.next()) {
		                int id = rs.getInt(1);
		                obj.setId(id);
		            }
		            DB.closeResultSet(rs);
		        } else {
		            throw new DbException("Erro inesperado! Nenhuma linha foi alterada!");
		        }
		    } catch (SQLException e) {
		        throw new DbException(e.getMessage());
		    } finally {
		        DB.closeStatement(st);
		    }
		}

		@Override
		public List<ItemPedido> findByPedido(Integer id_Pedido) {
		    PreparedStatement st = null;
		    ResultSet rs = null;
		    try {
		        st = conn.prepareStatement("SELECT * FROM itemPedido WHERE id_pedido =?");
		        
		        st.setInt(1, id_Pedido);
		        
		        rs = st.executeQuery();

		        List<ItemPedido> list = new ArrayList<>();

		        while (rs.next()) {
		            
		        	ItemPedido obj = new ItemPedido();
		            obj.setId_pedido(rs.getInt("id_pedido"));
		            obj.setId_item(rs.getInt("id_item"));
		            obj.setQuantidade(rs.getInt("quantidade"));
		    
		            list.add(obj);
		        }

		        return list;
		    } catch (SQLException e) {
		        throw new DbException(e.getMessage());
		    } finally {
		        DB.closeResultSet(rs);
		        DB.closeStatement(st);
		    }
		}
		

		
		
		public List<ItemPedido> findAll() {
		    PreparedStatement st = null;
		    ResultSet rs = null;
		    try {
		        st = conn.prepareStatement("SELECT * FROM itemPedido WHERE id_pedido =?");
		        rs = st.executeQuery();

		        List<ItemPedido> list = new ArrayList<>();

		        while (rs.next()) {
		            
		        	ItemPedido obj = new ItemPedido();
		            obj.setId_pedido(rs.getInt("id_pedido"));
		            obj.setId_item(rs.getInt("id_item"));
		            obj.setQuantidade(rs.getInt("quantidade"));
		    
		            list.add(obj);
		        }

		        return list;
		    } catch (SQLException e) {
		        throw new DbException(e.getMessage());
		    } finally {
		        DB.closeResultSet(rs);
		        DB.closeStatement(st);
		    }
		}
}