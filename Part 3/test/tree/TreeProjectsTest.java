/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tree;

import base.Project;
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
public class TreeProjectsTest {
    
    public TreeProjectsTest() {
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
     * Test of createTree method, of class TreeProjects.
     */
    @Test
    public void testCreateTree() throws Exception {
        System.out.println("createTree");
        TreeProjects instance = new TreeProjects();
        int projectSize = 4;

        BufferedReader br = new BufferedReader(new FileReader("Part3TestFile.txt"));
        try {

            String line = br.readLine();

            while (line != null) {
                String[] parts = line.split(",");
                if (parts.length == projectSize) {
                    Project p = new Project(parts[0], parts[1], Integer.parseInt(parts[2]), Integer.parseInt(parts[3]));
                    instance.insert(p);
                }
                line = br.readLine();

            }
        } finally {
            br.close();
        }


    }

    /**
     * Test of insert method, of class TreeProjects.
     */
    @Test
    public void testInsert() {
        System.out.println("insert");
        Project element = new Project("p1","SW",10,10);
        TreeProjects instance = new TreeProjects();
        instance.insert(element);
    }

    /**
     * Test of projectsInOrder method, of class TreeProjects.
     */
    @Test
    public void testProjectsInOrder() throws IOException {
        System.out.println("projectsInOrder");
        TreeProjects instance = new TreeProjects();
        int projectSize = 4;

        BufferedReader br = new BufferedReader(new FileReader("Part3TestFile.txt"));
        try {

            String line = br.readLine();

            while (line != null) {
                String[] parts = line.split(",");
                if (parts.length == projectSize) {
                    Project p = new Project(parts[0], parts[1], Integer.parseInt(parts[2]), Integer.parseInt(parts[3]));
                    instance.insert(p);
                }
                line = br.readLine();

            }
        } finally {
            br.close();
        }

        instance.projectsInOrder();
    }
    
}
