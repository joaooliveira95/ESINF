/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package base;

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
     * Test of getProject_key method, of class Activity.
     */
    @Test
    public void testGetProject_key() {
        System.out.println("getProject_key");
        Activity instance = new Activity("p1","a1p1","VCA",10,10);
        String expResult = "p1";
        String result = instance.getProject_key();
        assertEquals(expResult, result);
    }

    /**
     * Test of setProject_key method, of class Activity.
     */
    @Test
    public void testSetProject_key() {
        System.out.println("setProject_key");
        String project_key = "p2";
        Activity instance = new Activity("p1","a1p1","VCA",10,10);
        instance.setProject_key(project_key);
    }

    /**
     * Test of getActivity_key method, of class Activity.
     */
    @Test
    public void testGetActivity_key() {
        System.out.println("getActivity_key");
        Activity instance = new Activity("p1","a1p1","VCA",10,10);
        String expResult = "a1p1";
        String result = instance.getActivity_key();
        assertEquals(expResult, result);
    }

    /**
     * Test of setActivity_key method, of class Activity.
     */
    @Test
    public void testSetActivity_key() {
        System.out.println("setActivity_key");
        String activity_key = "a2p1";
        Activity instance =new Activity("p1","a1p1","VCA",10,10);
        instance.setActivity_key(activity_key);
    }

    /**
     * Test of getActivity_type method, of class Activity.
     */
    @Test
    public void testGetActivity_type() {
        System.out.println("getActivity_type");
        Activity instance = new Activity("p1","a1p1","VCA",10,10);
        String expResult = "VCA";
        String result = instance.getActivity_type();
        assertEquals(expResult, result);
    }

    /**
     * Test of setActivity_type method, of class Activity.
     */
    @Test
    public void testSetActivity_type() {
        System.out.println("setActivity_type");
        String activity_type = "FCA";
        Activity instance = new Activity("p1","a1p1","VCA",10,10);
        instance.setActivity_type(activity_type);
    }

    /**
     * Test of getActivity_completion method, of class Activity.
     */
    @Test
    public void testGetActivity_completion() {
        System.out.println("getActivity_completion");
        Activity instance = new Activity("p1","a1p1","VCA",10,10);
        int expResult = 10;
        int result = instance.getActivity_completion();
        assertEquals(expResult, result);
    }

    /**
     * Test of setActivity_completion method, of class Activity.
     */
    @Test
    public void testSetActivity_completion() {
        System.out.println("setActivity_completion");
        int activity_completion = 30;
        Activity instance = new Activity("p1","a1p1","VCA",10,10);
        instance.setActivity_completion(activity_completion);
    }

    /**
     * Test of getActivity_delay method, of class Activity.
     */
    @Test
    public void testGetActivity_delay() {
        System.out.println("getActivity_delay");
        Activity instance = new Activity("p1","a1p1","VCA",10,10);
        int expResult = 10;
        int result = instance.getActivity_delay();
        assertEquals(expResult, result);
    }

    /**
     * Test of setActivity_delay method, of class Activity.
     */
    @Test
    public void testSetActivity_delay() {
        System.out.println("setActivity_delay");
        int activity_delay = 20;
        Activity instance = new Activity("p1","a1p1","VCA",10,10);
        instance.setActivity_delay(activity_delay);
    }

    /**
     * Test of compareTo method, of class Activity.
     */
    @Test
    public void testCompareTo() {
        System.out.println("compareTo");
        Activity o = new Activity("p1","a1p1","VCA",10,10);
        Activity instance = new Activity("p1","a1p1","FCA",10,10);
        int expResult = 0;
        int result = instance.compareTo(o);
        assertEquals(expResult, result);
    }
    
    
}
