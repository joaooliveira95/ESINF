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
        variableCost instance = new variableCost("007","VCA","Variable Cost Activity",20,"h",140,10);
        int expResult = 1400;
        int result = instance.calculateTotalCost();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCostTime method, of class variableCost.
     */
    @Test
    public void testGetCostTime() {
        System.out.println("getCostTime");
        variableCost instance = new variableCost("007","VCA","Variable Cost Activity",20,"h",140,10);
        int expResult = 140;
        int result = instance.getCostTime();
        assertEquals(expResult, result);
    }

    /**
     * Test of setCostTime method, of class variableCost.
     */
    @Test
    public void testSetCostTime() {
        System.out.println("setCostTime");
        int costTime = 0;
        variableCost instance = new variableCost("007","VCA","Variable Cost Activity",20,"h",140,10);
        instance.setCostTime(costTime);
        int result = instance.getCostTime();
        assertEquals(costTime, result);

    }

    /**
     * Test of getTotalTime method, of class variableCost.
     */
    @Test
    public void testGetTotalTime() {
        System.out.println("getTotalTime");
        variableCost instance = new variableCost("007","VCA","Variable Cost Activity",20,"h",140,10);
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
        int totalTime = 0;
        variableCost instance = new variableCost("007","VCA","Variable Cost Activity",20,"h",140,10);
        instance.setTotalTime(totalTime);
        int result = instance.getTotalTime();
        assertEquals(totalTime, result);

    }
    
}
