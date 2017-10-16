/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tree;

import base.Activity;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Yahkiller
 */
public class TreeActivitiesTest {
    
    public TreeActivitiesTest() {
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
     * Test of createTree method, of class TreeActivities.
     */
    @Test
    public void testCreateTree() throws Exception {
        System.out.println("createTree");
        TreeActivities instance = new TreeActivities();
        BufferedReader br = new BufferedReader(new FileReader("Part3TestFile.txt"));
        try {

            String line = br.readLine();

            while (line != null) {
                String[] parts = line.split(",");
                if (parts.length == 5) {
                    Activity a = new Activity(parts[0], parts[1], parts[2], Integer.parseInt(parts[3]), Integer.parseInt(parts[4]));
                    instance.insert(a);
                }
                line = br.readLine();

            }
        } finally {
            br.close();
        }
    }

    /**
     * Test of insert method, of class TreeActivities.
     */
    @Test
    public void testInsert() {
        System.out.println("insert");
        Activity element = new Activity("p1","a1p1","VCA",10,10);
        TreeActivities instance = new TreeActivities();
        instance.insert(element);
    }

    /**
     * Test of ActivitiesInOrder method, of class TreeActivities.
     */
    @Test
    public void testActivitiesInOrder() throws IOException {
        System.out.println("ActivitiesInOrder");
        TreeActivities instance = new TreeActivities();
        BufferedReader br = new BufferedReader(new FileReader("Part3TestFile.txt"));
        try {

            String line = br.readLine();

            while (line != null) {
                String[] parts = line.split(",");
                if (parts.length == 5) {
                    Activity a = new Activity(parts[0], parts[1], parts[2], Integer.parseInt(parts[3]), Integer.parseInt(parts[4]));
                    instance.insert(a);
                }
                line = br.readLine();

            }
        } finally {
            br.close();
        }
        instance.ActivitiesInOrder();
    }



}
