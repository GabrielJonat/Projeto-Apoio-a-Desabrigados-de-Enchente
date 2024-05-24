package model.dao.impl;

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