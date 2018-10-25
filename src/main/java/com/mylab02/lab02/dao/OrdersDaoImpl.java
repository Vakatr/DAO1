package com.mylab02.lab02.dao;

import entity.Firms;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.Orders;
import entity.Users;

public class OrdersDaoImpl implements OrdersDao {

    private static final String DELETE = "DELETE FROM orders WHERE id_oreder=?";
    private static final String FIND_ALL = "select id_oreder,fio,title,datatime,cost from orders LEFT JOIN users USING(id_user) LEFT JOIN firms USING(id_Firm)";
    private static final String FIND_BY_ID = "SELECT * FROM orders WHERE id_oreder=?";
    private static final String INSERT = "INSERT INTO orders(id_user, id_Firm, datatime, cost) VALUES(?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE orders SET id_user=?, id_Firm=?, datatime=?, cost=? WHERE id_oreder=?";

    @Override
    public int delete(int id) {
        Connection conn = Connect.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement(DELETE);
            stmt.setInt(1, id);

            return stmt.executeUpdate();
        } catch (SQLException e) {
            // e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            Connect.close(stmt);
            Connect.close(conn);
        }
    }

    @Override
    public List<Orders> findAll() {
        Connection conn = Connect.getConnection();
        PreparedStatement stmt = null;
        Users User;
        Firms Firm;
        List<Orders> list = new ArrayList<>();

        try {
            stmt = conn.prepareStatement(FIND_ALL);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Orders order = new Orders();
                User = new Users(rs.getString("fio"));
                Firm = new Firms(rs.getString("title"));
                order.setIdOreder(rs.getInt("id_oreder"));    
                order.setUserData(User);
                order.setFirm(Firm);
                order.setDatatime(rs.getString("datatime"));
                order.setCost(rs.getInt("cost"));

                list.add(order);
            }
        } catch (SQLException e) {
            // e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            Connect.close(stmt);
            Connect.close(conn);
        }

        return list;
    }

    @Override
    public Orders findById(int id) {
        Connection conn = Connect.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement(FIND_BY_ID);
            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Orders order = new Orders();
                order.setIdOreder(rs.getInt("id_oreder"));
                order.setIdUser(rs.getInt("id_user"));
                order.setIdFirm(rs.getInt("id_Firm"));
                order.setDatatime(rs.getString("datatime"));
                order.setCost(rs.getInt("cost"));

                return order;
            } else {
                return null;
            }
        } catch (SQLException e) {
            // e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            Connect.close(stmt);
            Connect.close(conn);
        }
    }

    @Override
    public int insert(Orders order) {
        Connection conn = Connect.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, order.getIdUser().toString());
            stmt.setString(2, order.getIdFirm().toString());
            stmt.setString(3, order.getDatatime());
            stmt.setInt(4, order.getCost());

            int result = stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();

            if (rs.next()) {
                order.setIdOreder(rs.getInt(1));
            }

            return result;
        } catch (SQLException e) {
            // e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            Connect.close(stmt);
            Connect.close(conn);
        }
    }

    @Override
    public int update(Orders order) {
        Connection conn = Connect.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement(UPDATE);
            stmt.setString(1, order.getIdUser().toString());
            stmt.setString(2, order.getIdFirm().toString());
            stmt.setString(3, order.getDatatime());
            stmt.setInt(4, order.getCost());
            stmt.setInt(5, order.getIdOreder());

            return stmt.executeUpdate();
        } catch (SQLException e) {
            // e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            Connect.close(stmt);
            Connect.close(conn);
        }
    }

}
