package model.dao;

import java.util.List;

import model.entities.Abrigo;

public interface AbrigoDao {

	void insert(Abrigo obj);
	void update(Abrigo obj);
	void deleteById(Integer id);
	Abrigo findById(Integer id);
	List<Abrigo> findAll();
}