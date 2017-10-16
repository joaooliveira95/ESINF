/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Controller.Controller;
import base.inputFile;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Yahkiller
 */
public class mainUI {
    private Controller controller;

    public mainUI() throws IOException {
        this.controller = new Controller();
        Run();
    }

    public void Run() throws IOException {

        System.out.println("Nome do ficheiro que deseja importar:");
        Scanner sc = new Scanner(System.in);
        String file = sc.next();
        //String file = "test.txt";
        inputFile.getLista(controller, file);
 //       controller.printActivs();
        PertUI pert = new PertUI(controller);
        pert.importFile();
        
        System.out.println("\nAll Paths:");
        pert.printAllPaths();
        
        System.out.println("\nCritical Paths:");
        pert.printCriticalPaths();
                
    //    pert.printLongestPath("source", "L");
    //    pert.printShortestPath("source", "L"); //FEITO
        System.out.println("\nProject Activities by Order:");
        pert.orderedActivities();
        
        System.out.println();
        pert.printTable();
    }
    
   

    
}


