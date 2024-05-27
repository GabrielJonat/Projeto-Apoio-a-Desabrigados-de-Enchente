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
import model.dao.EstoqueAbrigoDao;
import model.entities.EstoqueAbrigo;
import model.execptions.InvalideIdException;

public class EstoqueAbrigoJDBC implements EstoqueAbrigoDao{

private Connection conn;
	
	// FORÇAR A INJEÇÃO DE DEPÊNDENCIAS DENTRO DA CONEXÃO
	public EstoqueAbrigoJDBC(Connection conn) {
		this.conn = conn;
	}

	// Inserção de dados
	@Override
	public void insert(EstoqueAbrigo lote) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(
					"INSERT INTO estoqueAbrigo"
					+ "( idCentro, idItem, quantidade) "
					+ "VALUES "
					+ "( ?, ?, ?)",
					Statement.RETURN_GENERATED_KEYS);
			
			//st.setInt(1, lote.getId());
			st.setInt(1, lote.getIdAbrigo());
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
					
					"UPDATE estoqueAbrigo "
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
					+"FROM estoqueAbrigo"
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
	public List<EstoqueAbrigo> findById(Integer id) {

		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			st = conn.prepareStatement(
					"SELECT * "
					+"FROM estoqueAbrigo "
					+"WHERE id_abrigo = ? ");
			
			st.setInt(1, id);
			rs = st.executeQuery();
			
			List<EstoqueAbrigo> estoque = new ArrayList<>();
			
			while(rs.next()) {
				
				EstoqueAbrigo produto = new EstoqueAbrigo(id, rs.getInt("id_item"), rs.getInt("quantidade"));
				
				produto.setId(rs.getInt("id_lote"));
				
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
	public List<EstoqueAbrigo> findAll() {
		
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			st = conn.prepareStatement(
					"SELECT * "
					+"FROM estoqueAbrigo");
		
			rs = st.executeQuery();
			
			List<EstoqueAbrigo> estoque =new ArrayList();  
			
			while(rs.next()) {
				
				EstoqueAbrigo lote = new EstoqueAbrigo();
				
				lote.setId(rs.getInt("idLote"));
				lote.setIdAbrigo(rs.getInt("idAbrigo"));
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
