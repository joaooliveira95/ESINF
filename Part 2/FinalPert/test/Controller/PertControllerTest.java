/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import base.Activity;
import base.fixedCost;
import base.variableCost;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
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
public class PertControllerTest {

    public PertControllerTest() {
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

    public static ArrayList<Activity> retornarlActiv() {
        ArrayList<Activity> lActiv = new ArrayList();
        variableCost a = new variableCost("A", "VCA", "High Level analysis", 1, "week", 30, 112);
        fixedCost b = new fixedCost("B", "FCA", "Order Hardware plataform", 4, "week", 2500);
        List<String> prevC = new ArrayList();
        prevC.add("B");
        fixedCost c = new fixedCost("C", "FCA", "Installation and Commissioning of hardware", 2, "week", 1250, prevC);
        List<String> prevD = new ArrayList();
        prevD.add("A");
        variableCost d = new variableCost("D", "VCA", "Detailed analysis of core modules", 3, "week", 30, 162, prevD);
        List<String> prevE = new ArrayList();
        prevE.add("D");
        variableCost e = new variableCost("E", "VCA", "Detailed analysis of supporting modules", 2, "week", 30, 108, prevE);
        List<String> prevF = new ArrayList();
        prevF.add("C");
        prevF.add("D");
        variableCost f = new variableCost("F", "VCA", "Programming of core modules", 4, "week", 20, 108, prevF);
        List<String> prevG = new ArrayList();
        prevG.add("E");
        prevG.add("F");
        variableCost g = new variableCost("G", "VCA", "Programming of supporting modules", 3, "week", 20, 54, prevG);
        List<String> prevH = new ArrayList();
        prevH.add("F");
        variableCost h = new variableCost("H", "VCA", "Quality assurance of core modules", 2, "week", 30, 54, prevH);
        List<String> prevI = new ArrayList();
        prevI.add("G");
        variableCost i = new variableCost("I", "VCA", "Quality assurance of supporting modules", 1, "week", 30, 27, prevI);
        List<String> prevJ = new ArrayList();
        prevJ.add("G");
        fixedCost j = new fixedCost("J", "FCA", "Application Manual", 1, "week", 550, prevJ);
        List<String> prevK = new ArrayList();
        prevK.add("G");
        fixedCost k = new fixedCost("K", "FCA", "User Manual", 1, "week", 750, prevK);
        List<String> prevL = new ArrayList();
        prevL.add("H");
        prevL.add("I");
        prevL.add("K");
        fixedCost l = new fixedCost("L", "FCA", "Core and supporting module training", 2, "week", 1500, prevL);
        lActiv.add(a);
        lActiv.add(b);
        lActiv.add(c);
        lActiv.add(d);
        lActiv.add(e);
        lActiv.add(f);
        lActiv.add(g);
        lActiv.add(h);
        lActiv.add(i);
        lActiv.add(j);
        lActiv.add(k);
        lActiv.add(l);
        return lActiv;
    }

    public static ArrayList<Activity> retornarlActiv2() {
        ArrayList<Activity> lActiv = new ArrayList();
        variableCost a = new variableCost("A", "VCA", "High Level analysis", 1, "week", 30, 112);
        fixedCost b = new fixedCost("B", "FCA", "Order Hardware plataform", 4, "week", 2500);
        List<String> prevC = new ArrayList();
        prevC.add("B");
        fixedCost c = new fixedCost("C", "FCA", "Installation and Commissioning of hardware", 2, "week", 1250, prevC);
        List<String> prevD = new ArrayList();
        prevD.add("A");
        variableCost d = new variableCost("D", "VCA", "Detailed analysis of core modules", 3, "week", 30, 162, prevD);
        List<String> prevF = new ArrayList();
        prevF.add("C");
        prevF.add("D");
        variableCost f = new variableCost("F", "VCA", "Programming of core modules", 4, "week", 20, 108, prevF);
        List<String> prevG = new ArrayList();

        lActiv.add(a);
        lActiv.add(b);
        lActiv.add(c);
        lActiv.add(d);
        lActiv.add(f);
        return lActiv;
    }

    /**
     * Test of addActivity method, of class PertController.
     */
    @Test
    public void testAddActivity1() {
        System.out.println("addActivity");
        String a = "007";
        Controller c = new Controller();
        PertController instance = new PertController(c);
        boolean expResult = true;
        boolean result = instance.addActivity(a);
        assertEquals(expResult, result);
    }

    /**
     * Test of addActivity method, of class PertController.
     */
    @Test
    public void testAddActivity2() {
        System.out.println("addActivity");
        String a = "";
        Controller c = new Controller();
        PertController instance = new PertController(c);
        boolean expResult = false;
        boolean result = instance.addActivity(a);
        assertEquals(expResult, result);
    }

    /**
     * Test of insertAllActivities method, of class PertController.
     */
    @Test
    public void testInsertAllActivities() {
        System.out.println("insertAllActivities");
        Controller c = new Controller();
        ArrayList<Activity> lActiv = retornarlActiv();
        c.setlActiv(lActiv);
        PertController instance = new PertController(c);
        boolean result = instance.insertAllActivities();
        boolean expResult = true;
        assertEquals(expResult, result);
    }

    /**
     * Test of insertAllActivities method, of class PertController.
     */
    @Test
    public void testInsertAllActivities2() {
        System.out.println("insertAllActivities");
        Controller c = new Controller();
        ArrayList<Activity> lActiv = new ArrayList();
        c.setlActiv(lActiv);
        PertController instance = new PertController(c);
        boolean result = instance.insertAllActivities();
        boolean expResult = false;
        assertEquals(expResult, result);
    }

    /**
     * Test of insertAllPrecedences method, of class PertController.
     */
    @Test
    public void testInsertAllPrecedences1() {
        System.out.println("insertAllPrecedences");
        Controller c = new Controller();
        ArrayList<Activity> lActiv = retornarlActiv();
        c.setlActiv(lActiv);
        PertController instance = new PertController(c);
        instance.sourceNode.setKey("Source");
        instance.finalNode.setKey("Final");
        instance.insertAllActivities();
        boolean result = instance.insertAllPrecedences();
        boolean expResult = true;
        assertEquals(expResult, result);
    }

    @Test
    public void testInsertAllPrecedences2() { //EMPTY LIST
        System.out.println("insertAllPrecedences");
        Controller c = new Controller();
        ArrayList<Activity> lActiv = new ArrayList();
        c.setlActiv(lActiv);
        PertController instance = new PertController(c);
        instance.sourceNode.setKey("Source");
        instance.finalNode.setKey("Final");
        instance.insertAllActivities();
        boolean result = instance.insertAllPrecedences();
        boolean expResult = false;
        assertEquals(expResult, result);
    }

    @Test
    public void testInsertAllPrecedences3() { //NO ACTIVITIES INSERTED
        System.out.println("insertAllPrecedences");
        Controller c = new Controller();
        ArrayList<Activity> lActiv = new ArrayList();
        c.setlActiv(lActiv);
        PertController instance = new PertController(c);
        instance.sourceNode.setKey("Source");
        instance.finalNode.setKey("Final");
        // instance.insertAllActivities();
        boolean result = instance.insertAllPrecedences();
        boolean expResult = false;
        assertEquals(expResult, result);
    }

    /**
     * Test of addPrecedence method, of class PertController.
     */
    @Test
    public void testAddPrecedence() {
        System.out.println("addPrecedence");
        String a1 = "C";
        String a2 = "D";
        double duration = 5.0;
        Integer n = 0;
        Controller c = new Controller();
        PertController instance = new PertController(c);
        boolean result = instance.addPrecedence(a1, a2, duration, n);
        boolean expResult = true;
        assertEquals(expResult, result);
    }

    @Test
    public void testAddPrecedence2() {
        System.out.println("addPrecedence");
        String a1 = "C";
        String a2 = "D";
        double duration = -5.0;
        Integer n = 0;
        Controller c = new Controller();
        PertController instance = new PertController(c);
        boolean result = instance.addPrecedence(a1, a2, duration, n);
        boolean expResult = false;
        assertEquals(expResult, result);
    }

    /**
     * Test of addPrecedence method, of class PertController.
     */
    @Test
    public void testAddPrecedence3() {
        System.out.println("addPrecedence");
        String a1 = "";
        String a2 = "";
        double duration = 5.0;
        Integer n = 0;
        Controller c = new Controller();
        PertController instance = new PertController(c);
        boolean result = instance.addPrecedence(a1, a2, duration, n);
        boolean expResult = false;
        assertEquals(expResult, result);
    }

    /**
     * Test of getAllPaths method, of class PertController.
     */
    @Test
    public void testGetAllPaths() {
        System.out.println("getAllPaths");
        Controller c = new Controller();
        ArrayList<Activity> lActiv = retornarlActiv();
        c.setlActiv(lActiv);
        PertController instance = new PertController(c);
        instance.sourceNode.setKey("Source");
        instance.finalNode.setKey("Final");
        instance.insertAllActivities();
        instance.insertAllPrecedences();

        ArrayList<Deque<String>> expResult = new ArrayList();
        Deque<String> path1 = new LinkedList();
        Deque<String> path2 = new LinkedList();
        Deque<String> path3 = new LinkedList();
        Deque<String> path4 = new LinkedList();
        Deque<String> path5 = new LinkedList();
        Deque<String> path6 = new LinkedList();
        Deque<String> path7 = new LinkedList();
        Deque<String> path8 = new LinkedList();
        Deque<String> path9 = new LinkedList();
        Deque<String> path10 = new LinkedList();
        Deque<String> path11 = new LinkedList();

        path1.push("Final");
        path1.push("L");
        path1.push("H");
        path1.push("F");
        path1.push("C");
        path1.push("B");
        path1.push("Source");

        path2.push("Final");
        path2.push("L");
        path2.push("K");
        path2.push("G");
        path2.push("F");
        path2.push("C");
        path2.push("B");
        path2.push("Source");

        path3.push("Final");
        path3.push("L");
        path3.push("I");
        path3.push("G");
        path3.push("F");
        path3.push("C");
        path3.push("B");
        path3.push("Source");

        path4.push("Final");
        path4.push("J");
        path4.push("G");
        path4.push("F");
        path4.push("C");
        path4.push("B");
        path4.push("Source");

        path5.push("Final");
        path5.push("L");
        path5.push("H");
        path5.push("F");
        path5.push("D");
        path5.push("A");
        path5.push("Source");

        path6.push("Final");
        path6.push("L");
        path6.push("K");
        path6.push("G");
        path6.push("F");
        path6.push("D");
        path6.push("A");
        path6.push("Source");

        path7.push("Final");
        path7.push("L");
        path7.push("I");
        path7.push("G");
        path7.push("F");
        path7.push("D");
        path7.push("A");
        path7.push("Source");

        path8.push("Final");
        path8.push("J");
        path8.push("G");
        path8.push("F");
        path8.push("D");
        path8.push("A");
        path8.push("Source");

        path9.push("Final");
        path9.push("L");
        path9.push("K");
        path9.push("G");
        path9.push("E");
        path9.push("D");
        path9.push("A");
        path9.push("Source");

        path10.push("Final");
        path10.push("L");
        path10.push("I");
        path10.push("G");
        path10.push("E");
        path10.push("D");
        path10.push("A");
        path10.push("Source");

        path11.push("Final");
        path11.push("J");
        path11.push("G");
        path11.push("E");
        path11.push("D");
        path11.push("A");
        path11.push("Source");

        expResult.add(path1);
        expResult.add(path2);
        expResult.add(path3);
        expResult.add(path4);
        expResult.add(path5);
        expResult.add(path6);
        expResult.add(path7);
        expResult.add(path8);
        expResult.add(path9);
        expResult.add(path10);
        expResult.add(path11);

        ArrayList<Deque<String>> result = instance.getAllPaths();
        int cont = 0;
        for (Deque<String> i : expResult) {
            for (Deque<String> j : result) {
                if (i.equals(j)) {
                    cont++;
                }
            }
        }

        assertEquals(11, cont);
    }

    /**
     * Test of getAllPaths method, of class PertController.
     */
    @Test
    public void testGetAllPaths2() {
        System.out.println("getAllPaths");
        Controller c = new Controller();
        ArrayList<Activity> lActiv = retornarlActiv2();
        c.setlActiv(lActiv);
        PertController instance = new PertController(c);
        instance.sourceNode.setKey("Source");
        instance.finalNode.setKey("Final");
        instance.insertAllActivities();
        instance.insertAllPrecedences();

        ArrayList<Deque<String>> expResult = new ArrayList();
        Deque<String> path1 = new LinkedList();
        Deque<String> path2 = new LinkedList();
        path1.push("Final");
        path1.push("F");
        path1.push("D");
        path1.push("A");
        path1.push("Source");

        path2.push("Final");
        path2.push("F");
        path2.push("C");
        path2.push("B");
        path2.push("Source");
        expResult.add(path1);
        expResult.add(path2);

        ArrayList<Deque<String>> result = instance.getAllPaths();
        int cont = 0;
        for (Deque<String> i : expResult) {
            for (Deque<String> j : result) {
                if (i.equals(j)) {
                    cont++;
                }
            }
        }

        assertEquals(2, cont);
    }

   
    /**
     * Test of getLongestPath method, of class PertController.
     */
    @Test
    public void testGetLongestPath1() {
        String orig = "Source";
        String dest = "Final";
        Controller c = new Controller();
        ArrayList<Activity> lActiv = retornarlActiv();
        c.setlActiv(lActiv);
        PertController instance = new PertController(c);
        instance.sourceNode.setKey("Source");
        instance.finalNode.setKey("Final");
        instance.insertAllActivities();
        instance.insertAllPrecedences();
        double expResult = 16.0;
        double result = instance.getLongestPath(orig, dest);
        assertEquals(expResult, result, 0.0);
    }
    
    /**
     * Test of getLongestPath method, of class PertController.
     */
    @Test
    public void testGetLongestPath2() {
        String orig = "Source";
        String dest = "Final";
        Controller c = new Controller();
        ArrayList<Activity> lActiv = retornarlActiv2();
        c.setlActiv(lActiv);
        PertController instance = new PertController(c);
        instance.sourceNode.setKey("Source");
        instance.finalNode.setKey("Final");
        instance.insertAllActivities();
        instance.insertAllPrecedences();
        double expResult = 10.0;
        double result = instance.getLongestPath(orig, dest);
        assertEquals(expResult, result, 0.0);
    }

}
