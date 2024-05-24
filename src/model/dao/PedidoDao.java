package model.dao;

import java.util.List;

import model.entities.Item;
import model.entities.Pedido;

public interface PedidoDao {

	void insert(Pedido obj);
	void update(Integer id, String nome);
	void deleteById(Integer id);
	Pedido findById(Integer id);
	List<Pedido> findAll();
	List<Item> listItem(Item item);
}
