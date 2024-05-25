package model.dao;

public class CheckoutDao {
	
	//buscar lista de pedidos
	List<Pedido> findPedidosByCentroID(Integer idCheckout); // lista os pedidos baseado no centro escolhido
	
	//atualizar tabela de checkout
	void updateStatus(Integer id, Boolean status); //atualizar tabela de checkout mudando para true ou false
	void updateAbrigo(Integer id, Integer quantidade); //atualizar tabela de estoque calculando qtdds de item no abrigo
	void updateCentro(Integer id, Integer quantidade); //atualizar tabela de estoque subtraindo qtdds de item do centro
}
