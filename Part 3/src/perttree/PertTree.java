/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perttree;

import java.io.IOException;
import java.util.Scanner;
import tree.ProjectActivities;
import tree.TreeActivities;
import tree.TreeProjects;

/**
 *
 * @author Yahkiller
 */
public class PertTree {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_BLUE = "\u001B[34m";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here

        TreeActivities tA = new TreeActivities();
        tA.createTree();
        TreeProjects tP = new TreeProjects();
        tP.createTree();
        ProjectActivities PA = new ProjectActivities(tA, tP);

        String option = Output();
        while (!option.equalsIgnoreCase("X")) {
            if (option.equalsIgnoreCase("A")) {
                tP.projectsInOrder();
            } else if (option.equalsIgnoreCase("B")) {
                tA.ActivitiesInOrder();
            } else if (option.equalsIgnoreCase("C")) {
                lateActivities(PA);

            } else if (option.equalsIgnoreCase("D")) {
                PA.printProjectsAndTheirActivities();
            } else if (option.equalsIgnoreCase("X")) {
                System.out.println("Exiting...\n");
            } else {
                System.out.println(ANSI_RED + "Unknown Comand\n" + ANSI_RESET);
            }
            option = Output();
        }

    }

    public static void lateActivities(ProjectActivities PA) {
        Scanner in = new Scanner(System.in);
        System.out.println("Digite a chave do projecto 1:");
        String key1 = in.nextLine();
        while (!PA.projectHasDelay(key1)) {
            System.out.println(ANSI_RED + "O projecto escolhido não tem delay!" + ANSI_RESET);
            System.out.println("Digite a chave do projecto 1:");
            key1 = in.nextLine();
        }
        System.out.println("Digite a chave do projecto 2:");
        String key2 = in.nextLine();
        while (!PA.projectHasDelay(key2)) {
            System.out.println(ANSI_RED + "O projecto escolhido não tem delay!" + ANSI_RESET);
            System.out.println("Digite a chave do projecto 2:");
            key2 = in.nextLine();
        }

        System.out.println("Digite o tipo de actividade pretendido:");
        String type = in.nextLine();
        PA.getLateActivities(key1, type);
        System.out.println();
        PA.getLateActivities(key2, type);
        System.out.println();
    }

    public static String Output() {
        Scanner in = new Scanner(System.in);
        System.out.println(ANSI_BLUE + "Choose the desired Option:" + ANSI_RESET);
        System.out.println(ANSI_BLUE + "  A)" + ANSI_RESET + " Print Ordered Projects");
        System.out.println(ANSI_BLUE + "  B)" + ANSI_RESET + " Print Ordered Activities");
        System.out.println(ANSI_BLUE + "  C)" + ANSI_RESET + " Print Late Activities");
        System.out.println(ANSI_BLUE + "  D)" + ANSI_RESET + " Print Projects and their activities");
        System.out.println(ANSI_RED + "  X)" + ANSI_RESET + " To exit");
        String option = in.nextLine();
        return option;
    }
}
