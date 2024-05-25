package model.dao;

import java.util.List;

import model.entities.Abrigo;
import model.entities.ItemPedido;

public interface ItemPedidoDao {

	void insert(ItemPedido obj);
	List<ItemPedido> findByPedido(Integer id_pedido);
	List<ItemPedido> findAll();
}