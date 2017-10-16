/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esinf_project;

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
        String[] parts = new String[6];
        parts[0]="007";
        parts[1]="Actividade Fixa";
        parts[2]="Actividade de custo fixo";
        parts[3]=String.valueOf(5);
        parts[4]="week";
        parts[5]=String.valueOf(100);
        Controller controller = new Controller();
        inputFile.addActivFixed(paramFixed, parts, controller);
    }

    /**
     * Test of addActivVar method, of class inputFile.
     */
    @Test
    public void testAddActivVar() {
        System.out.println("addActivVar");
        int paramVar = 7;
        String[] parts = new String[7];
        List<String> listPrevActKeys = new ArrayList();
        parts[0]="007";
        parts[1]="Actividade Variável";
        parts[2]="Actividade de custo variável";
        parts[3]=String.valueOf(5);
        parts[4]="week";
        parts[5]=String.valueOf(100);
        parts[6]=String.valueOf(2);
        Controller controller = new Controller();
        inputFile.addActivVar(paramVar, parts, controller);
    }

    /**
     * Test of validacaoUnid method, of class inputFile.
     */
    @Test
    public void testValidacaoUnid() {
        System.out.println("validacaoUnid");
        String str = "week";
        boolean expResult = true;
        boolean result = inputFile.validacaoUnid(str);
        assertEquals(expResult, result);
    }
    
}
