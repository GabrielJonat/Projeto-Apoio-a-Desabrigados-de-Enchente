package application;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import db.DB;

public class Programa {

	public static void main(String[] args) {
		
		Connection conn = DB.getConnection();
		
		ResultSet rs = null;
		
		
		try {
			
			Statement st = conn.createStatement();
		
			rs = st.executeQuery("select * from centro");
			
			while(rs.next()) {
				
				System.out.println(rs.getInt("id") + ", " + rs.getString("nome") + ", " + rs.getString("logradouro") + ", " + rs.getInt("numero") + ", " + rs.getString("cep") + ", " + rs.getString("bairro") + ", " + rs.getString("estado") + ", " + rs.getString("cidade") + ", " +  rs.getInt("limite"));
							
			}
			
		}
		catch(SQLException e) {
			
			System.out.println(e.getMessage());
		}
	}
}
