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
public class fixedCostTest {
    
    public fixedCostTest() {
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
     * Test of getActivityCost method, of class fixedCost.
     */
    @Test
    public void testGetActivityCost() {

        System.out.println("getActivityCost");
        String key="007";
        String activityType="FCA";
        String description="Fixed activity";
        int duration=5;
        String timeUnit="week";
        List<String> listPrevActivityKeys = null;        
        fixedCost instance = new fixedCost(key,activityType,description,duration,timeUnit,1200,listPrevActivityKeys);
        int expResult = 1200;
        int result = instance.getActivityCost();
        assertEquals(expResult, result);
    }

    /**
     * Test of setActivityCost method, of class fixedCost.
     */
    @Test
    public void testSetActivityCost() {
        System.out.println("setActivityCost");
        String key="007";
        String activityType="FCA";
        String description="Fixed activity";
        int duration=5;
        String timeUnit="week";
        List<String> listPrevActivityKeys = null;        
        fixedCost instance = new fixedCost(key,activityType,description,duration,timeUnit,1200,listPrevActivityKeys);
        int activityCost = 1500;
        instance.setActivityCost(activityCost);
    }
    
}
