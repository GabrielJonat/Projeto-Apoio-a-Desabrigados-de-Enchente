package model.dao.impl;

import db.DB;
import db.DbException;
import model.dao.CentroDao;
import model.entities.Centro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CentroDaoJDBC implements CentroDao {

    private Connection conn;
    public CentroDaoJDBC(Connection conn) {
        this.conn = conn;
    }
    public List<Centro> findAll() {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement(
                    "SELECT * FROM centro ORDER BY id");
            rs = st.executeQuery();

            List<Centro> list = new ArrayList<>();

            while (rs.next()) {
                Centro obj = new Centro();
                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setLogradouro(rs.getString("logradouro"));
                obj.setNumero(rs.getInt("numero"));
                obj.setCep(rs.getString("cep"));
                obj.setBairro(rs.getString("bairro"));
                obj.setCidade(rs.getString("cidade"));
                obj.setEstado(rs.getString("estado"));
                obj.setLimite(rs.getString("limite"));
                list.add(obj);
            }
            return list;
        }
        catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
        finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }
    }

}