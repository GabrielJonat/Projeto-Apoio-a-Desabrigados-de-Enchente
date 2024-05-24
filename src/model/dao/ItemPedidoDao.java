package model.dao;

import java.util.List;

import model.entities.Abrigo;
import model.entities.ItemPedido;

public interface ItemPedidoDao {

	void insert(ItemPedido obj);
	List<ItemPedido> findAll();
}