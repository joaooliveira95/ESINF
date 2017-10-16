/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package base;

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
public class ActivityTest {
    
    public ActivityTest() {
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
     * Test of getKey method, of class Activity.
     */
    @Test
    public void testGetKey() {
        System.out.println("getKey");
        Activity instance = new Activity("007");
        String expResult = "007";
        String result = instance.getKey();
        assertEquals(expResult, result);
    }

    /**
     * Test of setKey method, of class Activity.
     */
    @Test
    public void testSetKey() {
        System.out.println("setKey");
        String key = "12";
        Activity instance = new Activity("0001");
        instance.setKey(key);
        String result = instance.getKey();
        assertEquals(key, result);
    }

    /**
     * Test of getTypeActivity method, of class Activity.
     */
    @Test
    public void testGetTypeActivity() {
        System.out.println("getTypeActivity");
        Activity instance = new Activity("007","vca","Actividade Custo Fixo",40,"h");
        String expResult = "vca";
        String result = instance.getTypeActivity();
        assertEquals(expResult, result);
    }

    /**
     * Test of setTypeActivity method, of class Activity.
     */
    @Test
    public void testSetTypeActivity() {
        System.out.println("setTypeActivity");
        String expResult = "fca";
        Activity instance = new Activity("007","vca","Actividade Custo Fixo",40,"h");
        instance.setTypeActivity(expResult);
        String result = instance.getTypeActivity();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDescription method, of class Activity.
     */
    @Test
    public void testGetDescription() {
        System.out.println("getDescription");
        Activity instance = new Activity("007","vca","Actividade Custo Fixo",40,"h");
        String expResult = "Actividade Custo Fixo";
        String result = instance.getDescription();
        assertEquals(expResult, result);
    }

    /**
     * Test of setDescription method, of class Activity.
     */
    @Test
    public void testSetDescription() {
        System.out.println("setDescription");
        String expResult = "Fixed Cost Activity";
        Activity instance = new Activity("007","vca","Actividade Custo Fixo",40,"h");
        instance.setDescription(expResult);
        String result = instance.getDescription();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDuration method, of class Activity.
     */
    @Test
    public void testGetDuration() {
        System.out.println("getDuration");
        Activity instance = new Activity("007","vca","Actividade Custo Fixo",40,"h");
        int expResult = 40;
        int result = instance.getDuration();
        assertEquals(expResult, result);
    }

    /**
     * Test of setDuation method, of class Activity.
     */
    @Test
    public void testSetDuration() {
        System.out.println("setDuration");
        int expResult = 300;
        Activity instance = new Activity("007","vca","Actividade Custo Fixo",40,"h");
        instance.setDuration(expResult);
        int result = instance.getDuration();
        assertEquals(expResult, result);  
    }

    /**
     * Test of getTimeUnit method, of class Activity.
     */
    @Test
    public void testGetTimeUnit() {
        System.out.println("getTimeUnit");
        Activity instance = new Activity("007","vca","Actividade Custo Fixo",40,"h");
        String expResult = "h";
        String result = instance.getTimeUnit();
        assertEquals(expResult, result);
    }

    /**
     * Test of setTimeUnit method, of class Activity.
     */
    @Test
    public void testSetTimeUnit() {
        System.out.println("setTimeUnit");
        String timeUnit = "w";
        Activity instance = new Activity("007","vca","Actividade Custo Fixo",40,"h");
        List<String> lPrev = new ArrayList();
        lPrev.add("X");
        instance.setListPrevActivityKey(lPrev);
        List<String> expResult = lPrev;
        List<String> result = instance.getListPrevActivityKey();
        assertEquals(expResult, result);
    }

    /**
     * Test of getListPrevActivityKey method, of class Activity.
     */
    @Test
    public void testGetListPrevActivityKey() {
        System.out.println("getListPrevActivityKey");
        Activity instance = new Activity("007","vca","Actividade Custo Fixo",40,"h");
        List<String> lPrev = new ArrayList();
        lPrev.add("X");
        instance.setListPrevActivityKey(lPrev);
        List<String> expResult = lPrev;
        List<String> result = instance.getListPrevActivityKey();
        assertEquals(expResult, result);
    }
    
    

    /**
     * Test of setListPrevActivityKey method, of class Activity.
     */
    @Test
    public void testSetListPrevActivityKey() {
        System.out.println("setListPrevActivityKey");
        List<String> listPrevActivityKey = new ArrayList();
        Activity instance = new Activity("007","vca","Actividade Custo Fixo",40,"h");
        instance.setListPrevActivityKey(listPrevActivityKey);
    }
    
}
