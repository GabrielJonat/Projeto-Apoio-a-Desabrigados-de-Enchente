package model.dao;

import db.DB;
import model.dao.impl.AbrigoDaoJDBC;
import model.dao.impl.PedidoDaoJDBC;

public class DaoFactory {

	public static AbrigoDao createAbrigoDao() {
		
		return new AbrigoDaoJDBC(DB.getConnection());
	}
	
	public static PedidoDao createPedidoDao() {
			
			return new PedidoDaoJDBC(DB.getConnection());
		}
}