/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mylab02.lab02;

import com.mylab02.lab02.dao.FirmsDao;
import com.mylab02.lab02.dao.FirmsDaoImpl;
import com.mylab02.lab02.dao.OrdersDao;
import com.mylab02.lab02.dao.OrdersDaoImpl;
import com.mylab02.lab02.dao.UsersDao;
import com.mylab02.lab02.dao.UsersDaoImpl;
import entity.Firms;
import entity.Orders;
import entity.Users;
import java.sql.*;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

// модели таблиц
public class App {

    static TableModel setUpTableUsers() throws SQLException {
        UsersDao dao = new UsersDaoImpl();
        List<Users> list = dao.findAll();
        String col[] = {"IdUser", "FIO", "Phone", "DataReg"};
DefaultTableModel tableModel = new DefaultTableModel(col, 0);
        for (Users list1 : list) {
            int iduser = list1.getIdUser();
            String FIO = list1.getFio();
            String phone = list1.getPhone();
            java.util.Date datareg = list1.getDatereg();
            Object[] data = {iduser, FIO, phone, datareg};
            tableModel.addRow(data);
        }
        return tableModel;
    }

    static TableModel setUpTableFirms() throws SQLException {
        FirmsDao dao = new FirmsDaoImpl();
        List<Firms> list = dao.findAll();
        String col[] = {"IdFirm", "Title", "Phone", "Information"};
DefaultTableModel tableModel = new DefaultTableModel(col, 0);
        for (Firms list1 : list) {
            int idfirm = list1.getIdFirm();
            String Title = list1.getTitle();
            String phone = list1.getPhone();
            String Information = list1.getInformation();
            Object[] data = {idfirm, Title, phone, Information};
            tableModel.addRow(data);
        }
        return tableModel;
    }

    static TableModel setUpTableOrders() throws SQLException {
        OrdersDao dao = new OrdersDaoImpl();
        List<Orders> list = dao.findAll();
        String col[] = {"IdOrder", "NameUser", "NameFirm", "Datatime","Cost"};
DefaultTableModel tableModel = new DefaultTableModel(col, 0);
        for (Orders list1 : list) {
                int idorder = list1.getIdOreder();
                String iduser = list1.GetUserdata().getFio();
                String idfirm = list1.GetFirmdata().getTitle();
                String dt = list1.getDatatime();
                int cost = list1.getCost();
                Object[] data = {idorder,iduser,idfirm, dt, cost};
                tableModel.addRow(data);
        }
        return tableModel;
    }
}
