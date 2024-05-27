package model.dao;

import java.util.List;

import model.entities.Item;

public interface ItemDao<CentroDistribuicao> {

	void insert(Item obj);
	void update(Integer id, String nome);
	void deleteById(Integer id);
	Item findById(Integer id);
	List<Item> findByName(String tipo);
	List<Item> findByType(String tipo);
	List<Item> findAll();
}