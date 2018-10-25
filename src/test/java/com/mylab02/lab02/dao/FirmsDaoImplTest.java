package com.mylab02.lab02.dao;

import entity.Firms;
import java.util.List;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FirmsDaoImplTest {

    FirmsDaoImpl instance = new FirmsDaoImpl();
    private final Firms Firm = new Firms("0", "0", "0");
    private final Firms Firm1 = new Firms("00", "00", "00");
    private final Firms Firm3 = new Firms("00", "00", "00");

    public FirmsDaoImplTest() {
    }

    @Before
    public void setUp() {
        instance.insert(Firm);
    }

    @After
    public void tearDown() {
        instance.delete(Firm.getIdFirm());
    }

    /**
     * Test of insert method, of class FirmsDaoImpl.
     */
    @Test
    public void testInsert() {
        System.out.println("insert");
        instance.insert(Firm3);
        Assert.assertEquals("00", Firm3.getInformation());
        Assert.assertEquals("00", Firm3.getPhone());
        instance.delete(Firm3.getIdFirm());
    }

    /**
     * Test of findAll method, of class FirmsDaoImpl.
     */
    @Test
    public void testFindAll() {
        System.out.println("findAll");
        List<Firms> FirmsList0 = instance.findAll();
        instance.insert(Firm1);
        List<Firms> FirmsList1 = instance.findAll();
        Assert.assertEquals(FirmsList0.size() + 1, FirmsList1.size());
        instance.delete(Firm1.getIdFirm());
    }

    /**
     * Test of findById method, of class FirmsDaoImpl.
     */
    @Test
    public void testFindById() {
        System.out.println("findById");
        instance.findById(Firm.getIdFirm());
        Assert.assertEquals("0", Firm.getInformation());
        Assert.assertEquals("0", Firm.getPhone());
    }

    /**
     * Test of update method, of class FirmsDaoImpl.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        Firm.setTitle("123");
        instance.update(Firm);
        Firms savedFirms = instance.findById(Firm.getIdFirm());
        Assert.assertEquals("123", savedFirms.getTitle());
    }

    /**
     * Test of delete method, of class FirmsDaoImpl.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        instance.delete(Firm.getIdFirm());
        Firms result = instance.findById(Firm.getIdFirm());
        Assert.assertTrue(result == null);
    }
}
