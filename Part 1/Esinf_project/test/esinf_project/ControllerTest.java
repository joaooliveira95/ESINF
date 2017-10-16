/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esinf_project;

import java.util.ArrayList;
import java.util.List;
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
    public void testHasActivity() {
        System.out.println("hasActivity");
        String key="007";
        String activityType="FCA";
        String description="Fixed activity";
        int duration=5;
        String timeUnit="week";
        List<String> listPrevActivityKeys = null;
        Controller instance = new Controller();
        Activity a=new Activity(key,activityType,description,duration,timeUnit,listPrevActivityKeys);
        instance.addActiv(a);
        boolean expResult = true;
        boolean result = instance.hasActivity(key);
        assertEquals(expResult, result);
    }

    /**
     * Test of printActivs method, of class Controller.
     */
    @Test
    public void testPrintActivs() {
        System.out.println("printActivs");
        Controller instance = new Controller();
        instance.printActivs();
    }

    /**
     * Test of addActiv method, of class Controller.
     */
    @Test
    public void testAddActiv() {
        System.out.println("addActiv");
        String key="007";
        String activityType="FCA";
        String description="Fixed activity";
        int duration=5;
        String timeUnit="week";
        List<String> listPrevActivityKeys = null;
        Controller instance = new Controller();
        Activity a=new Activity(key,activityType,description,duration,timeUnit,listPrevActivityKeys);
        boolean expResult = true;
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
        ArrayList<Activity> expResult = new ArrayList<Activity>();
        ArrayList<Activity> result = instance.getlActiv();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setlActiv method, of class Controller.
     */
    @Test
    public void testSetlActiv() {
        System.out.println("setlActiv");
        ArrayList<Activity> lActiv = null;
        Controller instance = new Controller();
        instance.setlActiv(lActiv);
    }
    
}
