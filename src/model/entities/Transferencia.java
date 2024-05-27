package model.entities;

import db.DB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Transferencia {

    Scanner sc = new Scanner(System.in);
    Connection conn = null;
    Statement st = null;
    ResultSet rs = null;

    public void checkout(){

        int n = 0;
        for (int i = 0; i<n; i++){

            try {
                conn = DB.getConnection();
                st = conn.createStatement();
                rs = st.executeQuery("select * from department");

                while (rs.next()) {
                    System.out.println(rs.getInt("Id"));
                    System.out.println("Deseja aceitar ou recusar a requisição acima? Escreva S para aceitar e N para negar requisição");
                    sc.nextLine();
                }
            }
            catch (SQLException e) {
                e.printStackTrace();
            }

            finally {
                DB.closeResultSet(rs);
                DB.closeStatement(st);
                DB.closeConnection();
            }
        }
        sc.close();
    }
}
