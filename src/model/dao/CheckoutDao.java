package model.dao;

import java.util.List;

import model.entities.Checkout;

public interface CheckoutDao {
	
	void inserirCheckout(Checkout obj);
	//buscar lista de pedidos
	List<Checkout> findPedidosByCentroID(Integer idCheckout); // lista os pedidos baseado no centro escolhido
	
	//atualizar tabela de checkout
	void updateStatus(Integer id, String status, String motivo); //atualizar tabela de checkout mudando para true ou false
	void updateAbrigo(Integer id, Integer id_centro, Integer quantidade); //atualizar tabela de estoque calculando qtdds de item no abrigo
	void updateCentro(Integer id, Integer id_centro, Integer quantidade); //atualizar tabela de estoque subtraindo qtdds de item do centro
	void clearEstoque();
	
}