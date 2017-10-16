/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tree;

import base.Activity;
import java.io.IOException;
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
public class ProjectActivitiesTest {
    
    public ProjectActivitiesTest() {
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
     * Test of projectHasDelay method, of class ProjectActivities.
     */
    @Test
    public void testProjectHasDelay() throws IOException {
        TreeActivities tA=new TreeActivities();
        TreeProjects tP=new TreeProjects();
        tP.createTree();
        System.out.println("projectHasDelay");
        String key = "p2";
        ProjectActivities instance = new ProjectActivities(tA,tP);
        boolean expResult = true;
        boolean result = instance.projectHasDelay(key);
        assertEquals(expResult, result);
    }

    /**
     * Test of getLateActivities method, of class ProjectActivities.
     */
    @Test
    public void testGetLateActivities() throws IOException {
        System.out.println("getLateActivities");
        TreeActivities tA=new TreeActivities();
        tA.createTree();
        TreeProjects tP=new TreeProjects();
        tP.createTree();
        String pKey = "p2";
        String activType = "VCA";
        ProjectActivities instance =  new ProjectActivities(tA,tP);
        Iterable<Activity> it = tA.inOrder();
         System.out.println("Project "+pKey+" late activities:");
         for (Activity a : it) {
            if(a.getActivity_delay()>0 && a.getActivity_type().equalsIgnoreCase(activType) && a.getProject_key().equalsIgnoreCase(pKey)){
                System.out.println(a.getActivity_key());
        }
    }
    }
    
        /**
     * Test of getLateActivities method, of class ProjectActivities.
     */
    @Test
    public void testGetLateActivities2() throws IOException {
        System.out.println("getLateActivities");
        TreeActivities tA=new TreeActivities();
        tA.createTree();
        TreeProjects tP=new TreeProjects();
        tP.createTree();
        String pKey = "p1";
        String activType = "FCA";
        ProjectActivities instance =  new ProjectActivities(tA,tP);
        Iterable<Activity> it = tA.inOrder();
         System.out.println("Project "+pKey+" late activities:");
         for (Activity a : it) {
            if(a.getActivity_delay()>0 && a.getActivity_type().equalsIgnoreCase(activType) && a.getProject_key().equalsIgnoreCase(pKey)){
                System.out.println(a.getActivity_key());
        }
    }
    }
    
        /**
     * Test of getLateActivities method, of class ProjectActivities.
     */
    @Test
    public void testGetLateActivities3() throws IOException {
        System.out.println("getLateActivities");
        TreeActivities tA=new TreeActivities();
        tA.createTree();
        TreeProjects tP=new TreeProjects();
        tP.createTree();
        String pKey = "p3";
        String activType = "VCA";
        ProjectActivities instance =  new ProjectActivities(tA,tP);
        Iterable<Activity> it = tA.inOrder();
         System.out.println("Project "+pKey+" late activities:");
         for (Activity a : it) {
            if(a.getActivity_delay()>0 && a.getActivity_type().equalsIgnoreCase(activType) && a.getProject_key().equalsIgnoreCase(pKey)){
                System.out.println(a.getActivity_key());
        }
    }
    }

    /**
     * Test of printProjectsAndTheirActivities method, of class ProjectActivities.
     */
    @Test
    public void testPrintProjectsAndTheirActivities() throws IOException {
        System.out.println("printProjectsAndTheirActivities");
        TreeActivities tA=new TreeActivities();
        tA.createTree();
        TreeProjects tP=new TreeProjects();
        tP.createTree();
        ProjectActivities instance = new ProjectActivities(tA,tP);
        instance.printProjectsAndTheirActivities();
    }

    /**
     * Test of printProjectActivities method, of class ProjectActivities.
     */
    @Test
    public void testPrintProjectActivities() throws IOException {
        System.out.println("printProjectActivities");
        String pKey = "p1";
        TreeActivities tA=new TreeActivities();
        tA.createTree();
        TreeProjects tP=new TreeProjects();
        tP.createTree();
        ProjectActivities instance = new ProjectActivities(tA,tP);
        instance.printProjectActivities(pKey);
    }
    
}
