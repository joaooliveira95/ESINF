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
public class variableCostTest {
    
    public variableCostTest() {
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
     * Test of calculateTotalCost method, of class variableCost.
     */
    @Test
    public void testCalculateTotalCost() {
        System.out.println("calculateTotalCost");
        String key="007";
        String activityType="VCA";
        String description="Variable activity";
        int duration=5;
        String timeUnit="week";
        List<String> listPrevActivityKeys = null;        
        variableCost instance = new variableCost(key,activityType,description,duration,timeUnit,5,5,listPrevActivityKeys);
        int expResult = 25;
        int result = instance.calculateTotalCost();
    }

    /**
     * Test of getCostTime method, of class variableCost.
     */
    @Test
    public void testGetCostTime() {
        System.out.println("getCostTime");
        String key="007";
        String activityType="VCA";
        String description="Variable activity";
        int duration=5;
        String timeUnit="week";
        List<String> listPrevActivityKeys = null;        
        variableCost instance = new variableCost(key,activityType,description,duration,timeUnit,5,10,listPrevActivityKeys);
        int expResult = 5;
        int result = instance.getCostTime();
        assertEquals(expResult, result);
    }

    /**
     * Test of setCostTime method, of class variableCost.
     */
    @Test
    public void testSetCostTime() {
        System.out.println("setCostTime");
        int costTime = 10;
        String key="007";
        String activityType="VCA";
        String description="Variable activity";
        int duration=5;
        String timeUnit="week";
        List<String> listPrevActivityKeys = null;        
        variableCost instance = new variableCost(key,activityType,description,duration,timeUnit,5,10,listPrevActivityKeys);
        instance.setCostTime(costTime);

    }

    /**
     * Test of getTotalTime method, of class variableCost.
     */
    @Test
    public void testGetTotalTime() {
        System.out.println("getTotalTime");
        String key="007";
        String activityType="VCA";
        String description="Variable activity";
        int duration=5;
        String timeUnit="week";
        List<String> listPrevActivityKeys = null;        
        variableCost instance = new variableCost(key,activityType,description,duration,timeUnit,5,10,listPrevActivityKeys);
        int expResult = 10;
        int result = instance.getTotalTime();
        assertEquals(expResult, result);
    }

    /**
     * Test of setTotalTime method, of class variableCost.
     */
    @Test
    public void testSetTotalTime() {
        System.out.println("setTotalTime");
        int totalTime = 20;
        String key="007";
        String activityType="VCA";
        String description="Variable activity";
        int duration=5;
        String timeUnit="week";
        List<String> listPrevActivityKeys = null;        
        variableCost instance = new variableCost(key,activityType,description,duration,timeUnit,5,10,listPrevActivityKeys);
        instance.setTotalTime(totalTime);
    }
    
}
