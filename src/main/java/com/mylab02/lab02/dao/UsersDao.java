package com.mylab02.lab02.dao;

import entity.Users;
import java.util.List;

public interface UsersDao {

    public List<Users> findAll();

    public Users findById(int id);

    public int insert(Users user);

    public int update(Users user);

    public int delete(int id);
}
