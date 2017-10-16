/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tree;

import base.Activity;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


/**
 *
 * @author Yahkiller
 */
public class TreeActivities extends BST<Activity> {

    private ArrayList listaActiv = new ArrayList<>();

    public void createTree() throws FileNotFoundException, IOException {
        int activSize = 0;

        BufferedReader br = new BufferedReader(new FileReader("Part3TestFile.txt"));
        try {

            String line = br.readLine();

            while (line != null) {
                String[] parts = line.split(",");
                if (parts.length == 5) {
                    Activity a = new Activity(parts[0], parts[1], parts[2], Integer.parseInt(parts[3]), Integer.parseInt(parts[4]));
                    insert(a);
                }
                line = br.readLine();

            }
        } finally {
            br.close();
        }
    }

//================================================================ 
    /**
     * Inserts a new word in the tree, or increments the number of its
     * occurrences.
     *
     * @param element
     */
    @Override
    public void insert(Activity element) {
        root = insert(element, root);
    }

    private Node<Activity> insert(Activity element, Node<Activity> node) {
        if (node == null) {
            return new Node<>(element, null, null);
        }

        if (node.getElement().compareTo(element) == 0) {
            node.setRight(insert(element, node.getRight()));
        } else if (element.compareTo(node.getElement()) < 0) {
            node.setLeft(insert(element, node.getLeft()));
        } else {
            node.setRight(insert(element, node.getRight()));
        }

        return node;
    }

    public void ActivitiesInOrder() {
        Iterable<Activity> inOrder = this.inOrder();
        ArrayList<Activity> lActiv = new ArrayList();

        for (Activity a : inOrder) {
            lActiv.add(a);
        }

        Collections.sort(lActiv, new CustomComparator());
        for (Activity a : lActiv) {
            System.out.println("Activity: " + a.getActivity_key() + " delay time:"
                    + a.getActivity_delay());
        }
        System.out.println("");
    }

    public class CustomComparator implements Comparator<Activity> {

        @Override
        public int compare(Activity o1, Activity o2) {
            return o1.getActivity_delay() - o2.getActivity_delay();
        }
    }

}
