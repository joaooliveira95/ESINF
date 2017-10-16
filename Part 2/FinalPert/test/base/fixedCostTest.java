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
        fixedCost instance = new fixedCost("007","FCA","Fixed Cost Activity",20,"h",500);
        int expResult = 500;
        int result = instance.getActivityCost();
        assertEquals(expResult, result);
    }

    /**
     * Test of setActivityCost method, of class fixedCost.
     */
    @Test
    public void testSetActivityCost() {
        System.out.println("setActivityCost");
        int activityCost = 1050;
        fixedCost instance = new fixedCost("007","FCA","Fixed Cost Activity",20,"h",500);
        instance.setActivityCost(activityCost);
        int result = instance.getActivityCost();
        assertEquals(activityCost, result);
    }
    
}
