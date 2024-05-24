package model.dao;

import java.util.List;

import model.entities.Centro;

public interface CentroDao {
	List<Centro> findAll();
}
