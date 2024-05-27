package model.dao;

import db.DB;
import model.dao.impl.*;
import model.dao.impl.itemDaoJDBC;

public class DaoFactory {

	public static AbrigoDao createAbrigoDao() {
		
		return new AbrigoDaoJDBC(DB.getConnection());
	}
	
	public static EstoqueCentroDao createEstoqueCentroDao() {
		
		return new EstoqueCentroJDBC(DB.getConnection());
	}
	
	public static EstoqueAbrigoDao createEstoqueAbrigoDao() {
		
		return new EstoqueAbrigoJDBC(DB.getConnection());
	}
	
	public static ItemDao createItemDao() {
		
		return new itemDaoJDBC(DB.getConnection());
	}
	
	public static PedidoDao createPedidoDao() {
		
		return new PedidoDaoJDBC(DB.getConnection());
	}
	
	public static ItemPedidoDao createItemPedido() {
		
		return new ItemPedidoDaoJDBC(DB.getConnection());
	}
	
	public static CheckoutDaoJDBC createCheckOutDao() {
		
		return new CheckoutDaoJDBC(DB.getConnection());
	}

	public static CentroDao createCentroDao() {

		return new CentroDaoJDBC(DB.getConnection());
	}

}