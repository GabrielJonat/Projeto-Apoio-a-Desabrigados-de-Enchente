package model.dao.impl;

import db.DB;
import model.dao.doacaoDao;

public class DaoFactory {

	public static doacaoDao createDoacaoDao() {
		return new doacaoDaoJDBC(DB.getConnection());
	}
}
