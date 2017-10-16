/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Controller.PertController;
import Controller.Controller;
import base.Activity;
import base.fixedCost;
import base.variableCost;
import java.util.*;
import java.util.Map.Entry;
/**
 *
 * @author Yahkiller
 */
public class PertUI {

    PertController pertController;
    Controller controller;

    public PertUI(Controller c) {
        pertController = new PertController(c);
        this.controller = c;
    }

    public void importFile() {
        
        boolean flag1=pertController.insertAllActivities();
        if(flag1==false){
            System.out.println("Erro, não foram introduzidas atividades");
        }
        boolean flag2=pertController.insertAllPrecedences();
        if(flag2==false){
            System.out.println("Não foram introduzidas edges");
        }
       
    }

    public void printAllPaths() {
        ArrayList<Deque<String>> paths = pertController.getAllPaths();
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
    }

    public void printActivByOrder() {
        ArrayList<Deque<String>> paths = pertController.getAllPaths();

    }

//    public void printShortestPath(String Orig, String Dest) {
//        double path = pertController.getShortestPath(Orig, Dest);
//        System.out.println(path);
//    }

    public void printLongestPath(String Orig, String Dest) {
        double path = pertController.getLongestPath(Orig, Dest);
        System.out.println(path);
    }

    public void printCriticalPaths() {
        double longestPath = pertController.getLongestPath("source", "final");
        ArrayList<Deque<String>> paths = pertController.getAllPaths();

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
    }

    public void printPath(Deque<String> path) {
        for (String a : path) {
            System.out.print(a + " ");
        }
        System.out.println();
    }

    public double ES(String activ) {
        Activity a = controller.getActivity(activ);
        return (pertController.getLongestPath("source", activ) - a.getDuration());
    }

    public double EF(String activ) {
        double es = ES(activ);
        double ef = es + controller.getActivity(activ).getDuration();
        return ef;
    }

    public double LS(String activ) {
        double maxPath = pertController.getLongestPath("source", "final");
        double path = pertController.getLongestPath(activ, "final");
        return (maxPath - path);
    }

    public double LF(String activ) {
        Activity a = controller.getActivity(activ);

        return (LS(activ) + a.getDuration());
    }

    public double Slack(String activ) {
        double lf = LF(activ);
        double ef = EF(activ);
        return (lf - ef);
    }

public void printTable() {
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
            for (int i = 0; i < (13-cont); i++) {
                System.out.print(" ");            
            }
            System.out.format("| %-4s | %-4s | %-4s | %-4s | %-6s|", ES(key), LS(key), EF(key), LF(key), Slack(key));
            System.out.println();
        }
    }
    
    public void orderedActivities() {
        List<Activity> la = controller.getlActiv();
        HashMap<String, Double> map = new HashMap<String, Double>();

        for (Activity a : la) {
            double completion = EF(a.getKey());
            map.put(a.getKey(), completion);
        }
        map = sortByValue(map);

        for (Entry<String, Double> entry : map.entrySet()) {
            System.out.println("Activity: " + entry.getKey() + " completion time:"
                    + entry.getValue());
        }
    }

    public static HashMap<String, Double> sortByValue(HashMap<String, Double> map) {
        List list = new LinkedList(map.entrySet());
        Collections.sort(list, new Comparator() {

            @Override
            public int compare(Object o2, Object o1) {
                return ((Comparable) ((Map.Entry) (o2)).getValue()).compareTo(((Map.Entry) (o1)).getValue());
            }
        });

        HashMap result = new LinkedHashMap();
        for (Iterator it = list.iterator(); it.hasNext();) {
            Map.Entry entry = (Map.Entry) it.next();
            result.put(entry.getKey(), entry.getValue());
            
        }
        return result;
    }

}
