package graphbase;

import java.util.ArrayList;
import java.util.Map;

/**
 *
 * @author DEI-ESINF
 * @param <V>
 * @param <E>
 */
public class Graph<V, E> implements GraphInterface<V, E> {

    private int numVert;
    private int numEdge;
    private boolean isDirected;
    private ArrayList<Vertex<V, E>> listVert;  //Vertice list

    // Constructs an empty graph (either undirected or directed)
    public Graph(boolean directed) {
        numVert = 0;
        numEdge = 0;
        isDirected = directed;
        listVert = new ArrayList<>();
    }

    public int numVertices() {
        return numVert;
    }

    public Iterable<Vertex<V, E>> vertices() {
        return listVert;
    }

    public int numEdges() {
        return numEdge;
    }

    public Iterable<Edge<V, E>> edges() {

        ArrayList<Edge<V, E>> edges = new ArrayList<>();

        for (Vertex<V, E> vertex : this.listVert) {
            Map<Vertex<V, E>, Edge<V, E>> map = listVert.get(listVert.indexOf(vertex)).getOutgoing();
            for (Edge<V, E> edge : map.values()) {
                edges.add(edge);
            }

            /*Iterator<Map.Entry<Vertex<V, E>, Edge<V, E>>> it = map.entrySet().iterator();
             while (it.hasNext()) {
             if (!edges.contains(it.next().getValue())) {
             edges.add(it.next().getValue());
             }
             }*/
        }
        return edges;
    }

    public Edge<V, E> getEdge(Vertex<V, E> vorig, Vertex<V, E> vdest) {

        if (listVert.contains(vorig) && listVert.contains(vdest)) {
            return vorig.getOutgoing().get(vdest);
        }

        return null;
    }

    public Vertex<V, E>[] endVertices(Edge<V, E> e) {

        for (Edge<V, E> edge : this.edges()) {
            if (edge.equals(e)) {
                return e.getEndpoints();
            }
        }
        return null;
    }

    public Vertex<V, E> opposite(Vertex<V, E> vert, Edge<V, E> e) {
        Vertex<V, E> v = new Vertex();
        if (listVert.contains(vert)) {
            for (Vertex<V, E> v1 : listVert) {
                if (e.getVOrig() == vert) {
                    v = e.getVDest();
                } else if (e.getVDest() == vert) {
                    v = e.getVOrig();
                } else {
                    v = null;
                }

            }

        }
        return v;
    }

    public int outDegree(Vertex<V, E> v) {

        if (listVert.contains(v)) {
            return v.getOutgoing().size();
        } else {
            return -1;
        }
    }

    public int inDegree(Vertex<V, E> v) {

        int cont = 0;
        if (listVert.contains(v)) {
            for (int i = 0; i < listVert.size(); i++) {
                Map<Vertex<V, E>, Edge<V, E>> map = listVert.get(i).getOutgoing();
                for (Edge<V, E> e : map.values()) {
                    if (e.getVDest().equals(v)) {
                        cont++;
                    }
                }
            }
        } else {
            return -1;
        }
        return cont;
    }

    public Iterable<Edge<V, E>> outgoingEdges(Vertex<V, E> v) {

        if (listVert.contains(v)) {
            return v.getOutgoing().values();
        }

        return null;
    }

    public Iterable<Edge<V, E>> incomingEdges(Vertex<V, E> v) {

        if (!listVert.contains(v)) {
            return null;
        }

        ArrayList<Edge<V, E>> edges = new ArrayList<>();

        for (int i = 0; i < listVert.size(); i++) {
            Map<Vertex<V, E>, Edge<V, E>> map = listVert.get(i).getOutgoing();
            for (Edge<V, E> edge : map.values()) {
                if (edge.getVDest().equals(v)) {
                    edges.add(edge);
                }
            }

        }

        return edges;
    }

    public Vertex<V, E> insertVertex(V vInf) {

        Vertex<V, E> vert = getVertex(vInf);

        if (vert == null) {
            Vertex<V, E> newvert = new Vertex<>(numVert, vInf);
            listVert.add(newvert);
            numVert++;
            return newvert;
        }
        return vert;
    }

    public Edge<V, E> insertEdge(V vOrig, V vDest, E eInf, double eWeight) {

        Vertex<V, E> vorig = getVertex(vOrig);
        if (vorig == null) {
            vorig = insertVertex(vOrig);
        }

        Vertex<V, E> vdest = getVertex(vDest);
        if (vdest == null) {
            vdest = insertVertex(vDest);
        }

        if (getEdge(vorig, vdest) == null) {
            Edge<V, E> newedge = new Edge<>(eInf, eWeight, vorig, vdest);
            vorig.getOutgoing().put(vdest, newedge);
            numEdge++;

            //if graph is not direct insert other edge in the opposite direction 
            if (!isDirected) {
                Edge<V, E> otheredge = new Edge<>(eInf, eWeight, vdest, vorig);
                vdest.getOutgoing().put(vorig, otheredge);
                numEdge++;
            }
            return newedge;
        }
        return null;
    }

    public void removeVertex(V vInf) {

        Vertex<V, E> vertex = getVertex(vInf);

        if (listVert.contains(vertex)) {
            ArrayList<Edge<V, E>> edges = (ArrayList<Edge<V, E>>) edges();
            for (Edge<V, E> e : edges) {
                if (edges.get(edges.indexOf(e)).getVDest().equals(vertex) || edges.get(edges.indexOf(e)).getVOrig().equals(vertex)) {
                    removeEdge(e);
                }
            }
            int a = listVert.indexOf(vertex);
            listVert.remove(vertex);
            numVert--;
            for (int i = a; i < numVert; i++) {
                listVert.get(i).setKey(listVert.get(i).getKey() - 1);
            }
        }
    }
    
public void removeEdge(Edge<V, E> edge) {

        Vertex<V, E>[] endpoints = endVertices(edge);

        Vertex<V, E> vorig = endpoints[0];
        Vertex<V, E> vdest = endpoints[1];

        if (vorig != null && vdest != null) {
            if (edge.equals(getEdge(vorig, vdest))) {
                vorig.getOutgoing().remove(vdest);
                numEdge--;
            }
        }
    }

    public Vertex<V, E> getVertex(V vInf) {

        for (Vertex<V, E> vert : this.listVert) {
            if (vInf.equals(vert.getElement())) {
                return vert;
            }
        }

        return null;
    }

    public Vertex<V, E> getVertex(int vKey) {

        if (vKey < listVert.size()&&(vKey>=0)) {
            return listVert.get(vKey);
        }

        return null;
    }

  //Returns a clone of the graph 
    public Graph<V, E> clone() {

        Graph<V, E> newObject = new Graph<>(this.isDirected);

        newObject.numVert = this.numVert;

        newObject.listVert = new ArrayList<>();
        for (Vertex<V, E> v : this.listVert) {
            newObject.listVert.add(new Vertex<V, E>(v.getKey(), v.getElement()));
        }

        for (Vertex<V, E> v1 : this.listVert) {
            for (Edge<V, E> e : this.outgoingEdges(v1)) {
                if (e != null) {
                    Vertex<V, E> v2 = this.opposite(v1, e);
                    newObject.insertEdge(v1.getElement(), v2.getElement(),
                            e.getElement(), e.getWeight());
                }
            }
        }
        return newObject;
    }

    /* equals implementation
     * @param the other graph to test for equality
     * @return true if both objects represent the same graph
     */
    public boolean equals(Object oth) {

        if (oth == null) {
            return false;
        }

        if (this == oth) {
            return true;
        }

        if (!(oth instanceof Graph<?, ?>)) {
            return false;
        }

        Graph<?, ?> other = (Graph<?, ?>) oth;

        if (numVert != other.numVert || numEdge != other.numEdge) {
            return false;
        }

        if (!listVert.equals(other.listVert)) {
            return false;
        }

        return true;
    }

    //string representation
    @Override
    public String toString() {
        String s = "";
        if (numVert == 0) {
            s = "\nGraph not defined!!";
        } else {
            s = "Graph: " + numVert + " vertices, " + numEdge + " edges\n";
            for (Vertex<V, E> vert : listVert) {
                s += vert + "\n";
                if (!vert.getOutgoing().isEmpty()) {
                    for (Map.Entry<Vertex<V, E>, Edge<V, E>> entry : vert.getOutgoing().entrySet()) {
                        s += entry.getValue() + "\n";
                    }
                } else {
                    s += "\n";
                }
            }
        }
        return s;
    }

}
