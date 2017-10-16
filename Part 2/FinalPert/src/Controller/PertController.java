/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import base.Activity;
import graphbase.Graph;
import graphbase.GraphAlgorithms;
import graphbase.Vertex;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 *
 * @author Yahkiller
 */
public class PertController {

    Controller controller;
    List<Activity> lActiv;
    private Graph<String, Integer> pert;
    Activity sourceNode = new Activity("source");
    Activity finalNode = new Activity("final");

    public PertController(Controller c) {
        this.pert = new Graph(true);
        this.controller = c;
        this.lActiv = c.getlActiv();
    }

    public boolean addActivity(String a) {
        if(!a.isEmpty()){
            getPert().insertVertex(a);
            return true;
        }
        else{
            System.out.println("Activity doesn't exist");
            return false;
        }
            
    }

    public boolean insertAllActivities() {
        if (!lActiv.isEmpty() && sourceNode.getKey().equalsIgnoreCase("Source") && finalNode.getKey().equalsIgnoreCase("Final")) {
            addActivity(sourceNode.getKey());
            for (Activity a : lActiv) {
                addActivity(a.getKey());
            }
            addActivity(finalNode.getKey());
            return true;
        } else {
            return false;
        }

    }

    public boolean insertAllPrecedences() {
        if(!lActiv.isEmpty() && !sourceNode.getKey().isEmpty() && !finalNode.getKey().isEmpty() && getPert().numVertices()>0){
          for (Activity a : lActiv) {
            if (a.getListPrevActivityKey().isEmpty()) {
                addPrecedence(sourceNode.getKey(), a.getKey(), 0, 0);
            } else {
                List<String> lPrecs = a.getListPrevActivityKey();
                for (String p : lPrecs) {
                    addPrecedence(p, a.getKey(), a.getDuration(), 0); //VER NPASSENG
                }
            }
        }

        for (Activity a : lActiv) {
                if (!a.getKey().isEmpty()) {
                    Vertex<String, Integer> v = getPert().getVertex(a.getKey());
                    if (getPert().outDegree(v) == 0) {
                      
                        addPrecedence(a.getKey(), finalNode.getKey(), a.getDuration(), 0);
                    }
                }
        }
            return true;
        }
        else{
            return false;
        }
        
    }

    public boolean addPrecedence(String a1, String a2, double duration, Integer n) {
            if(!a1.isEmpty() && !a2.isEmpty() && duration>=0){
               getPert().insertEdge(a1, a2, n, duration);
               return true;
            }
            else{
                return false;
            }
    }

    public ArrayList<Deque<String>> getAllPaths() {
       return GraphAlgorithms.allPaths(getPert(), sourceNode.getKey(), finalNode.getKey());
    }
    
//    public double getShortestPath(String orig, String dest){
//        Deque<String> shortPath = new LinkedList();
//        return GraphAlgorithms.shortestPath(getPert(), orig, dest, shortPath);
//    }

    public double getLongestPath(String orig, String dest) {
        ArrayList<Deque<String>> paths = GraphAlgorithms.allPaths(getPert(), orig, dest);

        double maxDuration = 0;

        for (Deque<String> p : paths) {
            int current = 0;
            for (String a : p) {
                Activity activ = controller.getActivity(a);
                if (!a.equalsIgnoreCase("source")&&!a.equalsIgnoreCase("final")) {
                    current += activ.getDuration();
                }
            }
            Activity activ2 = controller.getActivity(dest);
            if (current > (maxDuration)) {
                maxDuration = current;
            }
        }

        return maxDuration;
    }

    /**
     * @return the pert
     */
    public Graph<String, Integer> getPert() {
        return pert;
    }

 
    
   
}
