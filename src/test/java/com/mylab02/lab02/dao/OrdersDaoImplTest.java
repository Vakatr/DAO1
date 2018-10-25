package com.mylab02.lab02.dao;

import entity.Orders;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Vaka
 */
public class OrdersDaoImplTest {

    OrdersDaoImpl instance = new OrdersDaoImpl();
    private final Orders OrderI = new Orders(1, 1, "2000-1-1", 0);

    public OrdersDaoImplTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        connect("root");
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
     * Test of delete method, of class OrdersDaoImpl.
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
     * Test of findAll method, of class OrdersDaoImpl.
     */
    @Test
    public void testFindAll() {
        System.out.println("findAll");
        List<Orders> result = instance.findAll();
        Assert.assertNotNull(result);
    }

    /**
     * Test of findById method, of class OrdersDaoImpl.
     */
    @Test
    public void testFindById() {
        System.out.println("findById");
        int id = 0;
        Orders expResult = null;
        Orders result = instance.findById(id);
        Assert.assertEquals(expResult, result);
    }

    /**
     * Test of insert method, of class OrdersDaoImpl.
     */
    @Test
    public void testInsert() {
        System.out.println("insert");
        try {
            instance.insert(OrderI);
            PreparedStatement preparedStatement = connect("root").prepareStatement("SELECT id_Firm FROM orders WHERE cost='0'");
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                Assert.assertEquals(1, rs.getInt("id_Firm"));
            } else {
                fail();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Test of update method, of class OrdersDaoImpl.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        Orders orderUp = null;
        Orders order = null;
        System.out.println("update");
        orderUp = instance.findById(1);
        orderUp.setCost(123);
        instance.update(orderUp);
        order = instance.findById(1);
        Assert.assertEquals(123, order.getCost());

    }

    public static Connection connect(String password) {
        final String URL = "jdbc:mysql://localhost:3306/lab02";
        final String USERNAME = "root";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            //e.printStackTrace();
        }
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USERNAME, password);
            System.out.println("Successfully connected!");
        } catch (SQLException e) {
            System.out.println("Connection failed!");
            //e.printStackTrace();
        }
        return connection;
    }

}
