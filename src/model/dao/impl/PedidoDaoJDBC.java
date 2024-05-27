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
import model.dao.PedidoDao;
import model.entities.Pedido;
import model.execptions.InvalideIdException;

public class PedidoDaoJDBC implements PedidoDao{

	private Connection conn;
	
	// FORÇAR A INJEÇÃO DE DEPÊNDENCIAS DENTRO DA CONEXÃO
		
		
		public PedidoDaoJDBC(Connection conn) {
		this.conn = conn;
	    }


		@Override
		public Pedido insert(Pedido obj) {
		    PreparedStatement st = null;
		    try {
		        st = conn.prepareStatement(
		            "INSERT INTO pedido "
		            + "(abrigo_id, centro_id) "
		            + "VALUES "
		            + "(?, ?)",
		            Statement.RETURN_GENERATED_KEYS);

		        st.setInt(1, obj.getId_abrigo());
		        st.setInt(2, obj.getId_centro());

		        int rowsAffected = st.executeUpdate();

		        if (rowsAffected > 0) {
		            ResultSet rs = st.getGeneratedKeys();
		            if (rs.next()) {
		                int id = rs.getInt(1);
		                obj.setId(id);
		                return obj;
		            }
		            DB.closeResultSet(rs);
		            
		            return obj;
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
		public void update(Integer id, String nome) {
		    PreparedStatement st = null;
		    try {
		        st = conn.prepareStatement(
		            "UPDATE pedido "
		            + "SET nome = ? "
		            + "WHERE id = ?");

		        st.setString(1, nome);
		        st.setInt(2, id);

		        int rowsAffected = st.executeUpdate();

		        if (rowsAffected == 0) {
		            throw new DbException("Erro inesperado! Nenhuma linha foi alterada!");
		        }
		    } catch (SQLException e) {
		        throw new DbException(e.getMessage());
		    } finally {
		        DB.closeStatement(st);
		    }
		}


		@Override
		public void deleteById(Integer id) {
		    PreparedStatement st = null;
		    try {
		        st = conn.prepareStatement(
		            "DELETE FROM pedido WHERE id = ?");

		        st.setInt(1, id);

		        int rowsAffected = st.executeUpdate();

		        if (rowsAffected == 0) {
		            throw new DbException("Erro inesperado! Nenhuma linha foi deletada!");
		        }
		    } catch (SQLException e) {
		        throw new DbException(e.getMessage());
		    }
			catch (IllegalArgumentException e) {
				throw new InvalideIdException("Id informado não foi encontrado");
			}finally {
		        DB.closeStatement(st);
		    }
		}


		@Override
		public Pedido findById(Integer id) {
		    PreparedStatement st = null;
		    ResultSet rs = null;
		    try {
		        st = conn.prepareStatement(
		            "SELECT * FROM pedido WHERE id = ?");

		        st.setInt(1, id);
		        rs = st.executeQuery();

		        if (rs.next()) {
		            Pedido obj = new Pedido();
		            obj.setId(rs.getInt("id"));
		            obj.setId_abrigo(rs.getInt("abrigo_id"));
		            obj.setId_centro(rs.getInt("centro_id"));
		      
		            return obj;
		        }
		        return null; 
		    } catch (SQLException e) {
		        throw new DbException(e.getMessage());
		    }
			catch (IllegalArgumentException e) {
				throw new InvalideIdException("Id informado não foi encontrado");
			}finally {
		        DB.closeResultSet(rs);
		        DB.closeStatement(st);
		    }
		}

		public List<Pedido> findByCentro(Integer id) {
		    
			PreparedStatement st = null;
		    ResultSet rs = null;
		    try {
		        st = conn.prepareStatement(
		            "SELECT * FROM pedido p INNER JOIN checkout c ON p.id = c.id_pedido WHERE p.centro_id = ? AND c.status_pedido = 'Pendente'");

		        st.setInt(1, id);
		        rs = st.executeQuery();

		        List<Pedido> pedidos = new ArrayList<>();
		        
		        while(rs.next()) {
		            
		        	Pedido obj = new Pedido();
		            obj.setId(rs.getInt("id"));
		            obj.setId_abrigo(rs.getInt("abrigo_id"));
		            obj.setId_centro(rs.getInt("centro_id"));
		      
		            pedidos.add(obj);
		        }
		        return pedidos;
		        
		    } catch (SQLException e) {
		        throw new DbException(e.getMessage());
		    } finally {
		        DB.closeResultSet(rs);
		        DB.closeStatement(st);
		    }
		}

		@Override
		public List<Pedido> findAll() {
		    PreparedStatement st = null;
		    ResultSet rs = null;
		    try {
		        st = conn.prepareStatement("SELECT * FROM pedido WHERE idCentro =?");
		        rs = st.executeQuery();

		        List<Pedido> list = new ArrayList<>();

		        while (rs.next()) {
		            Pedido obj = new Pedido();
		            obj.setId(rs.getInt("id"));
		            obj.setId_abrigo(rs.getInt("id_abrigo"));
		            obj.setId_centro(rs.getInt("id_centro"));
		            obj.setDataPedido(rs.getDate("dataPedido").toLocalDate());
		            obj.setDataEntrega(rs.getDate("dataEntrega").toLocalDate());
		    
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