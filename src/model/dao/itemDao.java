package model.dao;

import java.util.List;

import model.entities.Item;

public interface itemDao<CentroDistribuicao> {
	
	void insert(Item obj);
	void update(Integer id, String nome);
	void deleteById(Integer id);
	Item findById(Integer id);
	List<Item> findAll();
	List<Item> findBycentroDistribuicao(CentroDistribuicao centroDistribuicao);

}