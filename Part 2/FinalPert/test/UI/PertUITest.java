/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Controller.Controller;
import Controller.PertController;
import static UI.PertUI.sortByValue;
import base.Activity;
import base.fixedCost;
import base.variableCost;
import java.util.*;
import java.util.Map.Entry;
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
public class PertUITest {

    public PertUITest() {
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

    /**
     * Test of importFile method, of class PertUI.
     */
    @Test
    public void testImportFile() {
        System.out.println("importFile");
        Controller controller = new Controller();
        PertUI instance = new PertUI(controller);
        instance.importFile();
    }

    /**
     * Test of printAllPaths method, of class PertUI.
     */
    @Test
    public void testPrintAllPaths() {
        System.out.println("printAllPaths");
        Controller controller = new Controller();
        ArrayList<Activity> lActiv = retornarlActiv();
        controller.setlActiv(lActiv);
        PertController controller2 = new PertController(controller);
        controller2.insertAllActivities();
        controller2.insertAllPrecedences();
        
        ArrayList<Deque<String>> paths = controller2.getAllPaths();
        for (Deque<String> p : paths) {
            int duration = 0;
            for (String a : p) {

                if (((!a.equalsIgnoreCase("source")) && (!a.equalsIgnoreCase("final")))) {
                    System.out.print(a + " ");
                    duration += controller.getActivity(a).getDuration();
                }
            }
            System.out.print("Length: " + duration + "\n");
        }
        PertUI instance = new PertUI(controller);
        instance.printAllPaths();
    }

    /**
     * Test of printActivByOrder method, of class PertUI.
     */
    @Test
    public void testPrintActivByOrder() {
        System.out.println("printActivByOrder");
        Controller controller = new Controller();
        PertUI instance = new PertUI(controller);
        instance.printActivByOrder();
    }


    /**
     * Test of printLongestPath method, of class PertUI.
     */
    @Test
    public void testPrintLongestPath() {
        System.out.println("printLongestPath");
        ArrayList<Activity> lActiv = retornarlActiv();
        Controller controller = new Controller();
        controller.setlActiv(lActiv);
        PertController pert = new PertController(controller);
        pert.insertAllActivities();
        pert.insertAllPrecedences();
        String Orig = "A";
        String Dest = "F";
        double path = pert.getLongestPath(Orig, Dest);
        System.out.println(path);
    }

    public void printPath(Deque<String> path) {
        for (String a : path) {
            System.out.print(a + " ");
        }
        System.out.println();
    }

    /**
     * Test of printCriticalPaths method, of class PertUI.
     */
    @Test
    public void testPrintCriticalPaths() {
        System.out.println("printCriticalPaths");
        ArrayList<Activity> lActiv = retornarlActiv();
        Controller controller = new Controller();
        controller.setlActiv(lActiv);
        PertController pert = new PertController(controller);
        pert.insertAllActivities();
        pert.insertAllPrecedences();
        double longestPath = pert.getLongestPath("source", "final");
        ArrayList<Deque<String>> paths = pert.getAllPaths();

        for (Deque<String> p : paths) {
            int current = 0;
            for (String a : p) {

                if (!a.equalsIgnoreCase("source") && !a.equalsIgnoreCase("final")) {
                    Activity activ = controller.getActivity(a);
                    current += activ.getDuration();
                }
            }
            if (current == longestPath) {
                printPath(p);
            }
        }
        PertUI instance = new PertUI(controller);
        instance.printCriticalPaths();
    }

    /**
     * Test of printPath method, of class PertUI.
     */
    @Test
    public void testPrintPath() {
        System.out.println("printPath");
        Deque<String> path = new LinkedList();
        Controller controller = new Controller();
        PertUI instance = new PertUI(controller);
        instance.printPath(path);
    }

    /**
     * Test of ES method, of class PertUI.
     */
    @Test
    public void testES() {
        System.out.println("ES");
        String activ = "D";
        ArrayList<Activity> lActiv = retornarlActiv();
        Controller controller = new Controller();
        controller.setlActiv(lActiv);
        PertController pert = new PertController(controller);
        pert.insertAllActivities();
        pert.insertAllPrecedences();
        Activity a = controller.getActivity(activ);
        controller.addActiv(a);
        System.out.println(pert.getLongestPath("source", activ) - a.getDuration());
        PertUI instance = new PertUI(controller);
        instance.importFile();
        double expResult = 1.0;
        double result = instance.ES(activ);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of EF method, of class PertUI.
     */
    @Test
    public void testEF() {
        System.out.println("EF");
        String activ = "D";
        ArrayList<Activity> lActiv = retornarlActiv();
        Controller controller = new Controller();
        controller.setlActiv(lActiv);
        PertController pert = new PertController(controller);
        pert.insertAllActivities();
        pert.insertAllPrecedences();
        Activity a = new Activity(activ);
        controller.addActiv(a);
        PertUI instance = new PertUI(controller);
        instance.importFile();
        Activity b = controller.getActivity(activ);
        double es = pert.getLongestPath("source", activ) - b.getDuration();
        double ef = es + controller.getActivity(activ).getDuration();
        System.out.println(ef);
        double expResult = 4.0;
        double result = instance.EF(activ);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of LS method, of class PertUI.
     */
    @Test
    public void testLS() {
        System.out.println("LS");
        String activ = "D";
        ArrayList<Activity> lActiv = retornarlActiv();
        Controller controller = new Controller();
        controller.setlActiv(lActiv);
        PertController pert = new PertController(controller);
        pert.insertAllActivities();
        pert.insertAllPrecedences();
        PertUI instance = new PertUI(controller);
        instance.importFile();
        Activity a = new Activity(activ);
        controller.addActiv(a);
        double expResult = 3.0;
        double result = instance.LS(activ);
        double maxPath = pert.getLongestPath("source", "final");
        double path = pert.getLongestPath(activ, "final");
        double LS = maxPath - path;
        System.out.println(LS);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of LF method, of class PertUI.
     */
    @Test
    public void testLF() {
        System.out.println("LF");
        String activ = "D";
        ArrayList<Activity> lActiv = retornarlActiv();
        Controller controller = new Controller();
        controller.setlActiv(lActiv);
        PertController pert = new PertController(controller);
        pert.insertAllActivities();
        pert.insertAllPrecedences();
        Activity a = new Activity(activ);
        controller.addActiv(a);
        Activity b = controller.getActivity(activ);
        PertUI instance = new PertUI(controller);
        instance.importFile();
        double expResult = 6.0;
        double result = instance.LF(activ);
        double maxPath = pert.getLongestPath("source", "final");
        double path = pert.getLongestPath(activ, "final");
        double LS = maxPath - path;
        System.out.println(LS + b.getDuration());
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of Slack method, of class PertUI.
     */
    @Test
    public void testSlack() {
        System.out.println("Slack");
        String activ = "D";
        ArrayList<Activity> lActiv = retornarlActiv();
        Controller controller = new Controller();
        controller.setlActiv(lActiv);
        PertController pert = new PertController(controller);
        pert.insertAllActivities();
        pert.insertAllPrecedences();
        Activity a = new Activity(activ);
        controller.addActiv(a);
        PertUI instance = new PertUI(controller);
        instance.importFile();
        double expResult = 2.0;
        double result = instance.Slack(activ);
        double lf = instance.LF(activ);
        double ef = instance.EF(activ);
        System.out.println(lf - ef);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of printTable method, of class PertUI.
     */
    @Test
    public void testPrintTable() {
        System.out.println("printTable");
        ArrayList<Activity> lActiv = retornarlActiv();
        Controller controller = new Controller();
        controller.setlActiv(lActiv);
        PertUI instance = new PertUI(controller);
        instance.importFile();
        List<Activity> la = controller.getlActiv();
        int cost = 0;
        System.out.println("Activity |    Cost    | Duration | Predecessors |  ES  |  LS  |  EF  |  LF  | Slack |");
        for (Activity a : la) {
            String key = a.getKey();
            if (a.getTypeActivity().equalsIgnoreCase("fca")) {
                fixedCost fca = (fixedCost) a;
                cost = fca.getActivityCost();
            } else if (a.getTypeActivity().equalsIgnoreCase("vca")) {
                variableCost vca = (variableCost) a;
                cost = vca.calculateTotalCost();
            }
            System.out.format(" %-8s| %-5s %-5s| %-9s| ", key, a.getTypeActivity(), cost, a.getDuration());
            List<String> lp = a.getListPrevActivityKey();
            int cont = 0;
            for (String p : lp) {
                System.out.print(p);
                cont++;
            }
            for (int i = 0; i < (13 - cont); i++) {
                System.out.print(" ");
            }
            System.out.format("| %-4s | %-4s | %-4s | %-4s | %-6s|", instance.ES(key), instance.LS(key), instance.EF(key), instance.LF(key), instance.Slack(key));
            System.out.println();
        }
    }

    /**
     * Test of orderedActivities method, of class PertUI.
     */
    @Test
    public void testOrderedActivities() {
        System.out.println("orderedActivities");
        ArrayList<Activity> lActiv = retornarlActiv();
        Controller controller = new Controller();
        controller.setlActiv(lActiv);
        PertUI instance = new PertUI(controller);
        instance.importFile();
        List<Activity> la = controller.getlActiv();
        HashMap<String, Double> map = new HashMap<String, Double>();

        for (Activity a : la) {
            double completion = instance.EF(a.getKey());
            map.put(a.getKey(), completion);
        }
        map = sortByValue(map);
        System.out.println("Teste:");
        for (Entry<String, Double> entry : map.entrySet()) {
            System.out.println("Activity: " + entry.getKey() + " completion time:"
                    + entry.getValue());

        }
        System.out.println("A testar");
        instance.orderedActivities();
    }

    /**
     * Test of sortByValue method, of class PertUI.
     */
    @Test
    public void testSortByValue() {
        System.out.println("sortByValue");
        HashMap<String, Double> map = new LinkedHashMap();
        map.put("a", 5.0);
        map.put("b", 3.0);
        map.put("c", 7.0);
        HashMap<String, Double> expResult = new LinkedHashMap();
        expResult.put("b", 3.0);
        expResult.put("a", 5.0);
        expResult.put("c", 7.0);
        HashMap<String, Double> result = PertUI.sortByValue(map);
        assertEquals(expResult, result);
    }

}
