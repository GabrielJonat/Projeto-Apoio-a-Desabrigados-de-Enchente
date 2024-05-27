package model.dao;

import model.entities.Centro;

import java.util.List;

public interface CentroDao {
    List<Centro> findAll();
}