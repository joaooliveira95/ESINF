/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esinf_project;

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
        String key="007";
        String activityType="FCA";
        String description="Fixed activity";
        int duration=5;
        String timeUnit="week";
        List<String> listPrevActivityKeys = null;
        Activity instance = new Activity(key,activityType,description,duration,timeUnit,listPrevActivityKeys);
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
        String key = "007";
        Activity instance = new Activity();
        instance.setKey(key);
    }

    /**
     * Test of getTypeActivity method, of class Activity.
     */
    @Test
    public void testGetTypeActivity() {
        System.out.println("getTypeActivity");
        String key="007";
        String activityType="FCA";
        String description="Fixed activity";
        int duration=5;
        String timeUnit="week";
        List<String> listPrevActivityKeys = null;
        Activity instance = new Activity(key,activityType,description,duration,timeUnit,listPrevActivityKeys);
        String expResult = "FCA";
        String result = instance.getTypeActivity();
        assertEquals(expResult, result);
    }

    /**
     * Test of setTypeActivity method, of class Activity.
     */
    @Test
    public void testSetTypeActivity() {
        System.out.println("setTypeActivity");
        String typeActivity = "FCA";
        Activity instance = new Activity();
        instance.setTypeActivity(typeActivity);
    }

    /**
     * Test of getDescription method, of class Activity.
     */
    @Test
    public void testGetDescription() {
        System.out.println("getDescription");
        String key="007";
        String activityType="FCA";
        String description="Fixed activity";
        int duration=5;
        String timeUnit="week";
        List<String> listPrevActivityKeys = null;
        Activity instance = new Activity(key,activityType,description,duration,timeUnit,listPrevActivityKeys);
        String expResult = "Fixed activity";
        String result = instance.getDescription();
        assertEquals(expResult, result);
    }

    /**
     * Test of setDescription method, of class Activity.
     */
    @Test
    public void testSetDescription() {
        System.out.println("setDescription");
        String description = "Fixed Activity";
        Activity instance = new Activity();
        instance.setDescription(description);
    }

    /**
     * Test of getDuation method, of class Activity.
     */
    @Test
    public void testGetDuration() {
        System.out.println("getDuration");
        String key="007";
        String activityType="FCA";
        String description="Fixed activity";
        int duration=5;
        String timeUnit="week";
        List<String> listPrevActivityKeys = null;
        Activity instance = new Activity(key,activityType,description,duration,timeUnit,listPrevActivityKeys);
        int expResult = 5;
        int result = instance.getDuration();
        assertEquals(expResult, result);
    }

    /**
     * Test of setDuation method, of class Activity.
     */
    @Test
    public void testSetDuration() {
        System.out.println("setDuration");
        int duation = 5;
        Activity instance = new Activity();
        instance.setDuration(duation);
    }

    /**
     * Test of getTimeUnit method, of class Activity.
     */
    @Test
    public void testGetTimeUnit() {
        System.out.println("getTimeUnit");
        String key="007";
        String activityType="FCA";
        String description="Fixed activity";
        int duration=5;
        String timeUnit="week";
        List<String> listPrevActivityKeys = null;
        Activity instance = new Activity(key,activityType,description,duration,timeUnit,listPrevActivityKeys);
        String expResult = "week";
        String result = instance.getTimeUnit();
        assertEquals(expResult, result);
    }

    /**
     * Test of setTimeUnit method, of class Activity.
     */
    @Test
    public void testSetTimeUnit() {
        System.out.println("setTimeUnit");
        String timeUnit = "week";
        Activity instance = new Activity();
        instance.setTimeUnit(timeUnit);
    }

    /**
     * Test of getListPrevActivityKey method, of class Activity.
     */
    @Test
    public void testGetListPrevActivityKey() {
        System.out.println("getListPrevActivityKey");
        String key="007";
        String activityType="FCA";
        String description="Fixed activity";
        int duration=5;
        String timeUnit="week";
        List<String> listPrevActivityKeys = null;
        Activity instance = new Activity(key,activityType,description,duration,timeUnit,listPrevActivityKeys);
        List<String> expResult = null;
        List<String> result = instance.getListPrevActivityKey();
        assertEquals(expResult, result);
    }

    /**
     * Test of setListPrevActivityKey method, of class Activity.
     */
    @Test
    public void testSetListPrevActivityKey() {
        System.out.println("setListPrevActivityKey");
        List<String> listPrevActivityKey = null;
        Activity instance = new Activity();
        instance.setListPrevActivityKey(listPrevActivityKey);
    }
    
}
