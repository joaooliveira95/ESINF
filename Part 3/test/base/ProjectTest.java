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
public class ProjectTest {
    
    public ProjectTest() {
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
     * Test of getProject_key method, of class Project.
     */
    @Test
    public void testGetProject_key() {
        System.out.println("getProject_key");
        Project instance = new Project("p1","SW",10,10);
        String expResult = "p1";
        String result = instance.getProject_key();
        assertEquals(expResult, result);
    }

    /**
     * Test of setProject_key method, of class Project.
     */
    @Test
    public void testSetProject_key() {
        System.out.println("setProject_key");
        String project_key = "p2";
        Project instance = new Project("p1","SW",10,10);
        instance.setProject_key(project_key);
    }

    /**
     * Test of getProject_type method, of class Project.
     */
    @Test
    public void testGetProject_type() {
        System.out.println("getProject_type");
        Project instance = new Project("p1","SW",10,10);
        String expResult = "SW";
        String result = instance.getProject_type();
        assertEquals(expResult, result);
    }

    /**
     * Test of setProject_type method, of class Project.
     */
    @Test
    public void testSetProject_type() {
        System.out.println("setProject_type");
        String project_type = "SO";
        Project instance = new Project("p1","SW",10,10);
        instance.setProject_type(project_type);
    }

    /**
     * Test of getProject_completion method, of class Project.
     */
    @Test
    public void testGetProject_completion() {
        System.out.println("getProject_completion");
        Project instance = new Project("p1","SW",10,10);
        int expResult = 10;
        int result = instance.getProject_completion();
        assertEquals(expResult, result);
    }

    /**
     * Test of setProject_completion method, of class Project.
     */
    @Test
    public void testSetProject_completion() {
        System.out.println("setProject_completion");
        int project_completion = 20;
        Project instance = new Project("p1","SW",10,10);
        instance.setProject_completion(project_completion);
    }

    /**
     * Test of getProject_delay method, of class Project.
     */
    @Test
    public void testGetProject_delay() {
        System.out.println("getProject_delay");
        Project instance = new Project("p1","SW",10,10);
        int expResult = 10;
        int result = instance.getProject_delay();
        assertEquals(expResult, result);
    }

    /**
     * Test of setProject_delay method, of class Project.
     */
    @Test
    public void testSetProject_delay() {
        System.out.println("setProject_delay");
        int project_delay = 20;
        Project instance = new Project("p1","SW",10,10);
        instance.setProject_delay(project_delay);
    }

    /**
     * Test of compareTo method, of class Project.
     */
    @Test
    public void testCompareTo() {
        System.out.println("compareTo");
        Project o = new Project("p1","SW",10,10);
        Project instance = new Project("p1","SW",150,10);
        int expResult = 0;
        int result = instance.compareTo(o);
        assertEquals(expResult, result);
    }
}
