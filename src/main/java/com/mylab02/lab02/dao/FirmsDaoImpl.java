package com.mylab02.lab02.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.Firms;

public class FirmsDaoImpl implements FirmsDao {

    private static final String DELETE = "DELETE FROM firms WHERE id_Firm=?";
    private static final String FIND_ALL = "SELECT * FROM firms";
    private static final String FIND_BY_ID = "SELECT * FROM firms WHERE id_Firm=?";
    private static final String INSERT = "INSERT INTO firms(title, phone, Information) VALUES(?, ?, ?)";
    private static final String UPDATE = "UPDATE firms SET title=?, phone=?, Information=? WHERE id_Firm=?";

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
    public List<Firms> findAll() {
        Connection conn = Connect.getConnection();
        PreparedStatement stmt = null;
        List<Firms> list = new ArrayList<>();

        try {
            stmt = conn.prepareStatement(FIND_ALL);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Firms firm = new Firms();
                firm.setIdFirm(rs.getInt("id_Firm"));
                firm.setTitle(rs.getString("title"));
                firm.setPhone(rs.getString("phone"));
                firm.setInformation(rs.getString("Information"));

                list.add(firm);
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
    public Firms findById(int id) {
        Connection conn = Connect.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement(FIND_BY_ID);
            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Firms firm = new Firms();
                firm.setIdFirm(rs.getInt("id_Firm"));
                firm.setTitle(rs.getString("title"));
                firm.setPhone(rs.getString("phone"));
                firm.setInformation(rs.getString("Information"));

                return firm;
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
    public int insert(Firms firm) {
        Connection conn = Connect.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, firm.getTitle());
            stmt.setString(2, firm.getPhone());
            stmt.setString(3, firm.getInformation());

            int result = stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();

            if (rs.next()) {
                firm.setIdFirm(rs.getInt(1));
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
    public int update(Firms firm) {
        Connection conn = Connect.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement(UPDATE);
            stmt.setString(1, firm.getTitle());
            stmt.setString(2, firm.getPhone());
            stmt.setString(3, firm.getInformation());
            stmt.setInt(4, firm.getIdFirm());

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
