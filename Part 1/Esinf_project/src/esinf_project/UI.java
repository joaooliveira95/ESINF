/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esinf_project;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Yahkiller
 */
public class UI {
    
   private Controller controller;  
    
    public UI() throws IOException{
        this.controller = new Controller();
        Run();
    }
    
    public void Run() throws IOException{
       
        System.out.println("Nome do ficheiro que deseja importar:");
        Scanner sc = new Scanner(System.in);
        String file = sc.next();
        //String file = "test.txt";
        inputFile.getLista(controller, file);
        controller.printActivs();
    }  
    
}
