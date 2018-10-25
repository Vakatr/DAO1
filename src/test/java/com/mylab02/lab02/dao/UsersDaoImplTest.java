package com.mylab02.lab02.dao;

import entity.Users;
import java.sql.Date;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Vaka
 */
public class UsersDaoImplTest {

    UsersDaoImpl instance = new UsersDaoImpl();
    String f = "2011-1-1";
    private final Users UserT = new Users("00", "00", Date.valueOf(f));

    public UsersDaoImplTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of delete method, of class UsersDaoImpl.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        int id = 0;
        int expResult = 0;
        int result = instance.delete(id);
        Assert.assertEquals(expResult, result);
    }

    /**
     * Test of findAll method, of class UsersDaoImpl.
     */
    @Test
    public void testFindAll() {
        System.out.println("findAll");
        List<Users> result = instance.findAll();
        Assert.assertNotNull(result);
    }

    /**
     * Test of findById method, of class UsersDaoImpl.
     */
    @Test
    public void testFindById() {
        System.out.println("findById");
        int id = 0;
        Users expResult = null;
        Users result = instance.findById(id);
        Assert.assertEquals(expResult, result);
    }

    /**
     * Test of insert method, of class UsersDaoImpl.
     */
    @Test
    public void testInsert() {
        System.out.println("insert");
        String f = "1-1-2019";
        instance.insert(UserT);
        Assert.assertEquals("00", UserT.getFio());
        instance.delete(UserT.getIdUser());
    }

    /**
     * Test of update method, of class UsersDaoImpl.
     */
    @Test
    public void testUpdate() {
        Users UserUp = null;
        Users User = null;
        System.out.println("update");
        UserUp = instance.findById(1);
        UserUp.setFio("123");
        instance.update(UserUp);
        User = instance.findById(1);
        Assert.assertEquals("123", User.getFio());
    }

}
