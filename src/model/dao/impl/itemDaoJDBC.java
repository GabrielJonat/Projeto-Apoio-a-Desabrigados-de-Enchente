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
import model.dao.ItemDao;
import model.entities.Item;
import model.execptions.InvalideIdException;

public class itemDaoJDBC implements ItemDao {
	private Connection conn;
	// FORÇAR A INJEÇÃO DE DEPÊNDENCIAS DENTRO DA CONEXÃO
	public itemDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	// Inserção de dados
	@Override
	public void insert(Item obj) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(
					"INSERT INTO item "
							+ "(nome, tipo, genero, tamanho) "
							+ "VALUES "
							+ "(?, ?, ?, ?)",
					Statement.RETURN_GENERATED_KEYS);
			st.setString(1, obj.getNome());
			st.setString(2, obj.getTipo());
			st.setString(3, obj.getGenero());
			st.setString(4, obj.getTamanho());
			int rowsAffected = st.executeUpdate();
			if (rowsAffected > 0) {
				ResultSet rs = st.getGeneratedKeys();
				if (rs.next()) {
					int id = rs.getInt(1);
					obj.setId(id);
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

	//ATUALIZAÇÃO DE DADOS
	@Override
	public void update(Integer id, String nome) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(
					"UPDATE item "
							+ "SET nome = ? "
							+ "WHERE id = ? ");
			st.setString(1, nome);
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
							+"FROM item "
							+"WHERE id = ? ");
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
	public Item findById(Integer id ) {

		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
					"SELECT * "
							+"FROM item "
							+"WHERE id = ? ");
			st.setInt(1, id);
			rs = st.executeQuery();
			if(rs.next()) {
				Item doacao = new Item();
				doacao.setId(rs.getInt("id"));
				doacao.setNome(rs.getString("nome"));
				doacao.setTipo(rs.getString("tipo"));
				doacao.setGenero(rs.getString("genero"));
				doacao.setTamanho(rs.getString("tamanho"));
				return doacao;
			}
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
		return null;
	}
	// Encontrar por nome
	@Override
	public List<Item> findByName(String nome) {

		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
					"SELECT * "
							+"FROM item "
							+"WHERE nome = ? ");
			st.setString(1, nome);
			rs = st.executeQuery();
			List<Item> doacoes = new ArrayList();
			while(rs.next()) {
				Item doacao = new Item();
				doacao.setId(rs.getInt("id"));
				doacao.setNome(rs.getString("nome"));
				doacao.setTipo(rs.getString("tipo"));
				doacao.setGenero(rs.getString("genero"));
				doacao.setTamanho(rs.getString("tamanho"));
				doacoes.add(doacao);
			}


			return doacoes;
		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
		}
	}
	// Encontrar por nome
	@Override
	public List<Item> findByType(String tipo) {

		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
					"SELECT * "
							+"FROM item "
							+"WHERE tipo = ? ");
			st.setString(1, tipo);
			rs = st.executeQuery();
			List<Item> doacoes = new ArrayList();
			while(rs.next()) {
				Item doacao = new Item();
				doacao.setId(rs.getInt("id"));
				doacao.setNome(rs.getString("nome"));
				doacao.setTipo(rs.getString("tipo"));
				doacao.setGenero(rs.getString("genero"));
				doacao.setTamanho(rs.getString("tamanho"));
				doacoes.add(doacao);
			}


			return doacoes;
		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
		}
	}


	@SuppressWarnings("rawtypes")
	@Override
	public List<Item> findAll() {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
					"SELECT * "
							+"FROM item "
							+"ORDER BY ID");
			rs = st.executeQuery();
			List<Item> doacoes =new ArrayList();
			while(rs.next()) {
				Item doacao = new Item();
				doacao.setId(rs.getInt("id"));
				doacao.setNome(rs.getString("nome"));
				doacao.setTipo(rs.getString("tipo"));
				doacao.setGenero(rs.getString("genero"));
				doacao.setTamanho(rs.getString("tamanho"));
				doacoes.add(doacao);
			}
			return doacoes;

		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
		}

	}
}