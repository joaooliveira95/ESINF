/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tree;

import base.Activity;
import base.Project;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author Yahkiller
 */
public class ProjectActivities {

    private TreeActivities treeActiv;
    private TreeProjects treeProj;

    public ProjectActivities(TreeActivities tA, TreeProjects tP) {
        this.treeActiv = tA;
        this.treeProj = tP;
    }

    public boolean projectHasDelay(String key) {
        Iterable<Project> it = treeProj.inOrder();
        boolean flag = false;
        for (Project p : it) {
            if (p.getProject_key().equalsIgnoreCase(key)) {
                if (p.getProject_delay() > 0) {
                    flag = true;
                }
            }
        }
        return flag;
    }

    public void getLateActivities(String pKey, String activType) {
        Iterable<Activity> it = treeActiv.inOrder();
        System.out.println("Project " + pKey + " late activities:");
        for (Activity a : it) {
            if (a.getActivity_delay() > 0 && a.getActivity_type().equalsIgnoreCase(activType) && a.getProject_key().equalsIgnoreCase(pKey)) {
                System.out.println(a.getActivity_key());
            }
        }
    }

    public void printProjectsAndTheirActivities() {
        System.out.println("Projects by Order:");
        Iterable<Project> inOrder = treeProj.inOrder();
        ArrayList<Project> lProj = new ArrayList();

        for (Project p : inOrder) {
            lProj.add(p);
        }

        Collections.sort(lProj, new CustomComparator1());
        for (Project p1 : lProj) {
            System.out.println("Project: " + p1.getProject_key() + " delay time:"
                    + p1.getProject_delay());
            this.printProjectActivities(p1.getProject_key());
        }

        System.out.println("");
    }

    public void printProjectActivities(String pKey) {
        Iterable<Activity> inOrder = treeActiv.inOrder();
        ArrayList<Activity> lActiv = new ArrayList();

        for (Activity a : inOrder) {
            if (a.getProject_key().equalsIgnoreCase(pKey)) {
                lActiv.add(a);
            }
        }

        Collections.sort(lActiv, new CustomComparator2());
        for (Activity a : lActiv) {
            System.out.println("  Activity: " + a.getActivity_key() + " delay time:"
                    + a.getActivity_delay());
        }
        System.out.println("");
    }

    public class CustomComparator2 implements Comparator<Activity> {

        @Override
        public int compare(Activity o1, Activity o2) {
            return o1.getActivity_delay() - o2.getActivity_delay();
        }
    }

    public class CustomComparator1 implements Comparator<Project> {

        @Override
        public int compare(Project o1, Project o2) {
            return o1.getProject_delay() - o2.getProject_delay();
        }
    }

}
