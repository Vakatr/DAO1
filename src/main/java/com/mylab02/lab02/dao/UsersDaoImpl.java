package com.mylab02.lab02.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.Users;
import java.sql.Date;

public class UsersDaoImpl implements UsersDao {

    private static final String DELETE = "DELETE FROM users WHERE id_user=?";
    private static final String FIND_ALL = "SELECT * FROM users";
    private static final String FIND_BY_ID = "SELECT * FROM users WHERE id_user=?";
    private static final String INSERT = "INSERT INTO users(FIO, phone, Datereg) VALUES(?, ?, ?)";
    private static final String UPDATE = "UPDATE users SET FIO=?, phone=?, Datereg=? WHERE id_user=?";

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
    public List<Users> findAll() {
        Connection conn = Connect.getConnection();
        PreparedStatement stmt = null;
        List<Users> list = new ArrayList<>();

        try {
            stmt = conn.prepareStatement(FIND_ALL);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Users user = new Users();
                user.setIdUser(rs.getInt("id_user"));
                user.setFio(rs.getString("FIO"));
                user.setPhone(rs.getString("phone"));
                user.setDatereg(rs.getDate("Datereg"));

                list.add(user);
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
    public Users findById(int id) {
        Connection conn = Connect.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement(FIND_BY_ID);
            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Users user = new Users();
                user.setIdUser(rs.getInt("id_user"));
                user.setFio(rs.getString("FIO"));
                user.setPhone(rs.getString("phone"));
                user.setDatereg(rs.getDate("Datereg"));

                return user;
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
    public int insert(Users user) {
        Connection conn = Connect.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, user.getFio());
            stmt.setString(2, user.getPhone());
            stmt.setDate(3, (Date) user.getDatereg());

            int result = stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();

            if (rs.next()) {
                user.setIdUser(rs.getInt(1));
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
    public int update(Users user) {
        Connection conn = Connect.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement(UPDATE);
            stmt.setString(1, user.getFio());
            stmt.setString(2, user.getPhone());
            stmt.setDate(3, (Date) user.getDatereg());
            stmt.setInt(4, user.getIdUser());

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
