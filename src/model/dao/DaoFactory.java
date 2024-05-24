package model.dao;

import db.DB;
import model.dao.impl.AbrigoDaoJDBC;
import model.dao.impl.EstoqueAbrigoJDBC;
import model.dao.impl.EstoqueCentroJDBC;
import model.dao.impl.ItemPedidoDaoJDBC;
import model.dao.impl.PedidoDaoJDBC;
import model.dao.impl.itemDaoJDBC;

public class DaoFactory {

	public static AbrigoDao createSellerDao() {
		
		return new AbrigoDaoJDBC(DB.getConnection());
	}
	
	public static EstoqueCentroDao createEstoqueCentroDao() {
		
		return new EstoqueCentroJDBC(DB.getConnection());
	}
	
	public static itemDao createItemDao() {
		
		return new itemDaoJDBC(DB.getConnection());
	}
	
	public static EstoqueAbrigoDao createAbrigoDao() {
		
		return new EstoqueAbrigoJDBC(DB.getConnection());
	}
	
	public static PedidoDao createPedidoDao() {
		
		return new PedidoDaoJDBC(DB.getConnection());
	}
	
	public static ItemPedidoDao createItemPedido() {
		
		return new ItemPedidoDaoJDBC(DB.getConnection());
	}
	
}