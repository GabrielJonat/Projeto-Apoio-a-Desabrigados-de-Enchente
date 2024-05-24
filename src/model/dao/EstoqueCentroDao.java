package model.dao;

import java.util.List;

import model.entities.EstoqueCentro;
import model.entities.Item;

public interface EstoqueCentroDao {
	
	void insert(EstoqueCentro obj);
	void update(Integer id, Integer quantidade);
	void deleteById(Integer id);
	List<EstoqueCentro> findById(Integer id);
	List<EstoqueCentro> findAll();
	
}