package com.mylab02.lab02.dao;

import entity.Firms;
import java.util.List;

public interface FirmsDao {

    public List<Firms> findAll();

    public Firms findById(int id);

    public int insert(Firms firm);

    public int update(Firms firm);

    public int delete(int id);

}
