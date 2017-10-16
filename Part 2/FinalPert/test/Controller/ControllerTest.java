/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import base.Activity;
import base.inputFile;
import java.io.IOException;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Guilherme
 */
public class ControllerTest {
    
    public ControllerTest() {
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
     * Test of hasActivity method, of class Controller.
     */
    @Test
    public void testHasActivity1() {
        System.out.println("hasActivity");
        String key = "007";
        Controller instance = new Controller();
        Activity a=new Activity("007");
        instance.addActiv(a);
        boolean expResult = true;
        boolean result = instance.hasActivity(key);
        assertEquals(expResult, result);
    }

        /**
     * Test of hasActivity method, of class Controller.
     */
    @Test
    public void testHasActivity2() {
        System.out.println("hasActivity");
        String key = "007";
        Controller instance = new Controller();
        Activity a=new Activity("007");
        boolean expResult = false;
        boolean result = instance.hasActivity("007");
        assertEquals(expResult, result);
    }
    
    /**
     * Test of getActivity method, of class Controller.
     */
    @Test
    public void testGetActivity1() {
        System.out.println("getActivity");
        String key = "007";
        Activity a=new Activity(key);
        Controller instance = new Controller();
        instance.addActiv(a);
        Activity expResult = a;
        Activity result = instance.getActivity(key);
        assertEquals(expResult, result);
    }
    
        /**
     * Test of getActivity method, of class Controller.
     */
    @Test
    public void testGetActivity2() {
        System.out.println("getActivity");
        String key = "007";
        Activity a=new Activity(key);
        Controller instance = new Controller();
        Activity expResult =null;
        Activity result = instance.getActivity(key);
        assertEquals(expResult, result);
    }

    /**
     * Test of printActivs method, of class Controller.
     */
    @Test
    public void testPrintActivs() throws IOException {
        System.out.println("printActivs");
        String localizacao = "test.txt";
        Controller instance = new Controller();
        inputFile.getLista(instance, localizacao);
        instance.printActivs();
    }

    /**
     * Test of addActiv method, of class Controller.
     */
    @Test
    public void testAddActiv1() {
        System.out.println("addActiv");
        Activity a = new Activity("007");
        Controller instance = new Controller();
        boolean expResult = true;
        boolean result = instance.addActiv(a);
        assertEquals(expResult, result);
    }

        /**
     * Test of addActiv method, of class Controller.
     */
    @Test
    public void testAddActiv2() {
        System.out.println("addActiv");
        Activity a = new Activity("007");
        Controller instance = new Controller();
        instance.addActiv(a);
        boolean expResult = false;
        boolean result = instance.addActiv(a);
        assertEquals(expResult, result);
    }
    /**
     * Test of getlActiv method, of class Controller.
     */
    @Test
    public void testGetlActiv() {
        System.out.println("getlActiv");
        Controller instance = new Controller();
        ArrayList<Activity> expResult = new ArrayList();
        ArrayList<Activity> result = instance.getlActiv();
        assertEquals(expResult, result);
    }

    /**
     * Test of setlActiv method, of class Controller.
     */
    @Test
    public void testSetlActiv() {
        System.out.println("setlActiv");
        ArrayList<Activity> lActiv = new ArrayList();
        Controller instance = new Controller();
        instance.setlActiv(lActiv);
    }
    
}
