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
import db.DbIntegrityException;
import model.dao.AbrigoDao;
import model.entities.Abrigo;
import model.execptions.InvalideIdException;

public class AbrigoDaoJDBC implements AbrigoDao {

	private Connection conn;
	
	public AbrigoDaoJDBC(Connection conn) {
		this.conn = conn;
	}
	
	@Override
	public Abrigo findById(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
				"SELECT * FROM abrigo WHERE id = ?");
			st.setInt(1, id);
			rs = st.executeQuery();
			if (rs.next()) {
				Abrigo obj = new Abrigo();
				obj.setId(rs.getInt("id"));
				obj.setResponsavel(rs.getString("responsavel"));
				obj.setLogradouro(rs.getString("logradouro"));
				obj.setNumero(rs.getInt("numero"));
				obj.setTelefone(rs.getString("telefone"));
				obj.setEmail(rs.getString("email"));
				obj.setNome(rs.getString("nome"));
				
				return obj;
			
			}
			
			return null;
		}
		catch (SQLException e) {
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
	
	public List<Abrigo> findAll() {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
				"SELECT * FROM abrigo ORDER BY nome");
			rs = st.executeQuery();

			List<Abrigo> list = new ArrayList<>();

			while (rs.next()) {
				Abrigo obj = new Abrigo();
				obj.setId(rs.getInt("id"));
				obj.setResponsavel(rs.getString("responsavel"));
				obj.setLogradouro(rs.getString("logradouro"));
				obj.setNumero(rs.getInt("numero"));
				obj.setTelefone(rs.getString("telefone"));
				obj.setEmail(rs.getString("email"));
				obj.setNome(rs.getString("nome"));
				obj.setOcupacao(rs.getDouble("ocupacao"));
				
				list.add(obj);
			}
			return list;
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}

	public void insert(Abrigo obj) {
		PreparedStatement st = null;
		System.out.println(obj);
		try {
			st = conn.prepareStatement(
				"INSERT INTO abrigo " +
				"( responsavel, logradouro, numero, telefone, email, capacidade, numOcupacao, nome) " + 
				"VALUES " +
				"(?,?,?,?,?,?,?,?)" 
				, Statement.RETURN_GENERATED_KEYS);

			st.setString(1, obj.getResponsavel());
			
			st.setString(2, obj.getLogradouro());
			
			st.setInt(3, obj.getNumero());
			
			st.setString(4, obj.getTelefone());
			
			st.setString(5, obj.getEmail());
			
			st.setDouble(6, obj.getCapacidade());
			
			st.setDouble(7, obj.getNumOcupacao());
			
			st.setString(8, obj.getNome());

			int rowsAffected = st.executeUpdate();
			
			if (rowsAffected > 0) {
				ResultSet rs = st.getGeneratedKeys();
				if (rs.next()) {
					
				}
			}
			else {
				throw new DbException("Unexpected error! No rows affected!");
			}
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		} 
		finally {
			DB.closeStatement(st);
		}
	}

	public void update(Abrigo obj) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(
				"UPDATE abrigo " +
				"SET responsavel = ?" + 
				", logradouro = ?" + 
				", numero = ?" +
				", telefone = ?" + 
				", email = ?" + 
				", capacidade = ? " + 
				", ocupacao = ?" + 
				", nome = ?" + 
				"WHERE id = ?");
			
			st.setString(1, obj.getResponsavel());
			
			st.setString(2, obj.getLogradouro());
			
			st.setInt(3, obj.getNumero());
			
			st.setString(4, obj.getTelefone());
			
			st.setString(5, obj.getEmail());
			
			st.setDouble(6, obj.getCapacidade());
			
			st.setDouble(7, obj.getOcupacao());
			
			st.setString(8, obj.getNome());
			
			st.setInt(9, obj.getId());
			
			st.executeUpdate();
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		} 
		finally {
			DB.closeStatement(st);
		}
	}
	
	public void deleteById(Integer id) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(
				"DELETE FROM abrigo WHERE id = ?");

			st.setInt(1, id);

			st.executeUpdate();
		}
		catch (SQLException e) {
			throw new DbIntegrityException(e.getMessage());
		}
		catch (IllegalArgumentException e) {
			throw new InvalideIdException("Id informado não foi encontrado");
		}
		finally {
			DB.closeStatement(st);
		}
	}

}