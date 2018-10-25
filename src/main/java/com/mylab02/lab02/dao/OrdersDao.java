package com.mylab02.lab02.dao;

import entity.Orders;
import java.util.List;

public interface OrdersDao {

    public List<Orders> findAll();

    public Orders findById(int id);

    public int insert(Orders order);

    public int update(Orders order);

    public int delete(int id);

}
