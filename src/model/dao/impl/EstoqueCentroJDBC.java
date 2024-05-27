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
import model.dao.EstoqueCentroDao;
import model.entities.EstoqueCentro;
import model.entities.Item;
import model.execptions.InvalideIdException;

public class EstoqueCentroJDBC implements EstoqueCentroDao{

private Connection conn;
	
	// FORÇAR A INJEÇÃO DE DEPÊNDENCIAS DENTRO DA CONEXÃO
	public EstoqueCentroJDBC(Connection conn) {
		this.conn = conn;
	}

	// Inserção de dados
	@Override
	public void insert(EstoqueCentro lote) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(
					"INSERT INTO estoqueCentro"
					+ "( idCentro, idItem, quantidade) "
					+ "VALUES "
					+ "( ?, ?, ?)",
					Statement.RETURN_GENERATED_KEYS);
			
			//st.setInt(1, lote.getId());
			st.setInt(1, lote.getIdCentro());
			st.setInt(2, lote.getIdtem());
			st.setInt(3, lote.getQuantidade());
			
			
			int rowsAffected = st.executeUpdate();
			
			if (rowsAffected > 0) {
				ResultSet rs = st.getGeneratedKeys();
				if (rs.next()) {
					Integer id_inserido = rs.getInt(1);
					lote.setId(id_inserido);
				}
				DB.closeResultSet(rs);
			}
			else {
				throw new DbException("Erro inesperado! nenhuma linha foi alterada!");
			}
		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
		}
		
	}

	@Override
	public void update(Integer id, Integer quantidade) {
		
		PreparedStatement st = null;
		
		try {
			st = conn.prepareStatement(
					
					"UPDATE estoqueCentro "
					+ "SET quantidade = ? "
					+ "WHERE idLote = ? ");
			
			st.setInt(1, quantidade);
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

	// DELETE BY ID
	@Override
	public void deleteById(Integer id) {
	
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			st = conn.prepareStatement(
					"DELETE "
					+"FROM estoqueCentro"
					+"WHERE idLote = ? ");
			
			st.setInt(1, id);
			st.executeUpdate();
			
			int rowsAffected = st.executeUpdate();
			
		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		catch (IllegalArgumentException e) {
			throw new InvalideIdException("Id informado não foi encontrado");
		}
		finally {
			DB.closeStatement(st);
		}
	}
	

	// Encontrar por ID
	@Override
	public List<EstoqueCentro> findById(Integer id) {

		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			st = conn.prepareStatement(
					"SELECT * "
					+"FROM estoqueCentro "
					+"WHERE idCentro = ? ");
			
			st.setInt(1, id);
			rs = st.executeQuery();
			
			List<EstoqueCentro> estoque = new ArrayList<>();
			
			while(rs.next()) {
				
				EstoqueCentro produto = new EstoqueCentro(rs.getInt("idCentro"), rs.getInt("idItem"), rs.getInt("quantidade"));
				
				produto.setId(rs.getInt("idLote"));
				
				estoque.add(produto);
			
				
			}
			
			return estoque;
			
		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		catch (IllegalArgumentException e) {
			throw new InvalideIdException("Id informado não foi encontrado");
		}
		finally {
			
			DB.closeStatement(st);
		}
	}

	@Override
	public List<EstoqueCentro> findAll() {
		
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			st = conn.prepareStatement(
					"SELECT * "
					+"FROM estoqueCentro ");
		
			rs = st.executeQuery();
			
			List<EstoqueCentro> estoque =new ArrayList();  
			
			while(rs.next()) {
				
				EstoqueCentro lote = new EstoqueCentro();
				
				lote.setId(rs.getInt("idLote"));
				lote.setIdCentro(rs.getInt("idCentro"));
				lote.setIdItem(rs.getInt("idItem"));
				lote.setQuantidade(rs.getInt("quantidade"));
							
				estoque.add(lote);
				
			}
			
			return estoque;

		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		
		finally {
			DB.closeStatement(st);
		}

	}

	
}
