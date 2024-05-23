package model.dao;

import db.DB;
import model.dao.impl.AbrigoDaoJDBC;

public class DaoFactory {

	public static AbrigoDao createSellerDao() {
		
		return new AbrigoDaoJDBC(DB.getConnection());
	}
	
}