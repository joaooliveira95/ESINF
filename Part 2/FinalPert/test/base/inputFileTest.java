/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package base;

import Controller.Controller;
import java.util.ArrayList;
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
public class inputFileTest {

    public inputFileTest() {
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
     * Test of getLista method, of class inputFile.
     */
    @Test
    public void testGetLista() throws Exception {
        System.out.println("getLista");
        Controller controller = new Controller();
        String localizacao = "test.txt";
        inputFile.getLista(controller, localizacao);
    }

    /**
     * Test of addActivFixed method, of class inputFile.
     */
    @Test
    public void testAddActivFixed() {
        System.out.println("addActivFixed");
        int paramFixed = 6;
        List<String> listPrevActKeys = new ArrayList();
        String line = "B,FCA,Order Hardware platform,4,week,2500";
        String[] parts = line.split(",");
        Controller controller = new Controller();
        inputFile.addActivFixed(paramFixed, parts, controller);
        fixedCost fixed = new fixedCost("B", "FCA", "Order Hardware platform", 4, "week", 2500);
        fixed.setListPrevActivityKey(listPrevActKeys);
        Activity result = controller.getActivity("B");
        Activity expResult = fixed;
        boolean flag = false;
        if(expResult.getKey().equalsIgnoreCase(result.getKey())&&expResult.getTypeActivity().equalsIgnoreCase(result.getTypeActivity())){
            flag=true;
        }
 
        assertEquals(true, flag);

    }

    /**
     * Test of addActivVar method, of class inputFile.
     */
    @Test
    public void testAddActivVar() {
        System.out.println("addActivVar");
        int paramVar = 7;
        List<String> listPrevActKeys = new ArrayList();
        String line = "A,VCA,High level analysis,1,week,30,112";
        String[] parts = line.split(",");
        Controller controller = new Controller();
        inputFile.addActivFixed(paramVar, parts, controller);
        
        variableCost fixed = new variableCost("A","VCA","High level analysis",1,"week",30,112);
        fixed.setListPrevActivityKey(listPrevActKeys);
        Activity result = controller.getActivity("A");
        Activity expResult = fixed;
        boolean flag = false;
        if(expResult.getKey().equalsIgnoreCase(result.getKey())&&expResult.getTypeActivity().equalsIgnoreCase(result.getTypeActivity())){
            flag=true;
        }
        assertEquals(true, flag);
    }

    /**
     * Test of validacaoUnid method, of class inputFile.
     */
    @Test
    public void testValidacaoUnid() {
        System.out.println("validacaoUnid");
        String str = "";
        boolean expResult = false;
        boolean result = inputFile.validacaoUnid(str);
        assertEquals(expResult, result);
    }

}
