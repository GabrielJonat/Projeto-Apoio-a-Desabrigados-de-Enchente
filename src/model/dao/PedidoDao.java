package model.dao;

import java.util.List;

import model.entities.Pedido;

public interface PedidoDao {

	Pedido insert(Pedido obj);
	void update(Integer id, String nome);
	void deleteById(Integer id);
	Pedido findById(Integer id);
	List<Pedido> findByCentro(Integer id);
	List<Pedido> findAll();
}