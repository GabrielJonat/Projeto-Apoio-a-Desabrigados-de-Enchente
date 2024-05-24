package model.dao;

import java.util.List;

import model.entities.EstoqueAbrigo;
import model.entities.EstoqueCentro;

public interface EstoqueAbrigoDao {
	
	void insert(EstoqueAbrigo obj);
	void update(Integer id, Integer quantidade);
	void deleteById(Integer id);
	List<EstoqueAbrigo> findById(Integer id);
	List<EstoqueAbrigo> findAll();
	
}