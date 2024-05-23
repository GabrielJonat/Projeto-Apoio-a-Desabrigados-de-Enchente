package model.dao;

import db.DB;
import model.dao.impl.AbrigoDaoJDBC;
import model.dao.impl.EstoqueCentroJDBC;
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
	
}