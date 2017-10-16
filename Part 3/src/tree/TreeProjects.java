/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tree;

import base.Project;
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
public class TreeProjects extends BST<Project> {

    private ArrayList listaActiv = new ArrayList<>();

    public void createTree() throws FileNotFoundException, IOException {
        int projectSize = 4;

        BufferedReader br = new BufferedReader(new FileReader("Part3TestFile.txt"));
        try {

            String line = br.readLine();

            while (line != null) {
                String[] parts = line.split(",");
                if (parts.length == projectSize) {
                    Project p = new Project(parts[0], parts[1], Integer.parseInt(parts[2]), Integer.parseInt(parts[3]));
                    insert(p);
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
    public void insert(Project element) {
        root = insert(element, root);
    }

    private Node<Project> insert(Project element, Node<Project> node) {
        if (node == null) {
            return new Node<>(element, null, null);
        }

        if (node.getElement().compareTo(element) == 0) {     //replace existing element
            if (!node.getElement().getProject_key().equalsIgnoreCase(element.getProject_key())) {
                node.setLeft(insert(element, node.getLeft()));
            }
        } else if (element.compareTo(node.getElement()) < 0) {
            node.setLeft(insert(element, node.getLeft()));
        } else {
            node.setRight(insert(element, node.getRight()));
        }

        return node;
    }

    public void projectsInOrder() {
        System.out.println("Projects by Order:");
        Iterable<Project> inOrder = this.inOrder();
        ArrayList<Project> lProj = new ArrayList();

        for (Project p : inOrder) {
            lProj.add(p);
        }

        Collections.sort(lProj, new CustomComparator());
        for (Project p1 : lProj) {
            System.out.println("Project: " + p1.getProject_key() + " delay time:"
                    + p1.getProject_delay());
        }

        System.out.println("");

    }

    public class CustomComparator implements Comparator<Project> {

        @Override
        public int compare(Project o1, Project o2) {
            return o1.getProject_delay() - o2.getProject_delay();
        }
    }

}
