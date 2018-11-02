package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
* @author Simon Stratemeier
*/
public class Exercise5 {
    public static void main(String[] args) {
        System.out.println("\nExercise 5.1");
        Node<String> nodeA = new Node<String>();
        Node<String> nodeB = new Node<String>();
        Node<String> nodeC = new Node<String>();
        Node<String> nodeD = new Node<String>();
        Edge edgeAB = new Edge();
        Edge edgeAC = new Edge();
        Edge edgeAD = new Edge();
        Edge edgeBD = new Edge();
        Edge edgeCB = new Edge();
        Edge edgeCD = new Edge();
        Edge edgeDB = new Edge();
        nodeA.item = "A";
        nodeB.item = "B";
        nodeC.item = "C";
        nodeD.item = "D";
        edgeAB.weight = 5;
        edgeAC.weight = 2;
        edgeAD.weight = 1;
        edgeBD.weight = 4;
        edgeCB.weight = 1;
        edgeCD.weight = 2;
        edgeDB.weight = 2;
        edgeAB.target = nodeB;
        edgeAC.target = nodeC;
        edgeAD.target = nodeD;
        edgeBD.target = nodeD;
        edgeCB.target = nodeB;
        edgeCD.target = nodeD;
        edgeDB.target = nodeB;
        nodeA.edges.add(edgeAB);
        nodeA.edges.add(edgeAC);
        nodeA.edges.add(edgeAD);
        nodeB.edges.add(edgeBD);
        nodeC.edges.add(edgeCB);
        nodeC.edges.add(edgeCD);
        nodeD.edges.add(edgeDB);
        ArrayList<Node<?>> graph = new ArrayList<>();
        graph.add(nodeA);
        graph.add(nodeB);
        graph.add(nodeC);
        graph.add(nodeD);

        System.out.println("\nExercise 5.2");
        DijkstraAlgorithm dijkstraAlgorithm = new DijkstraAlgorithm();
        HashMap<Node, Node> predecessors =  dijkstraAlgorithm.eval(graph, nodeD);
        predecessors.forEach((node, node2) -> {
            if(node != null && node2 != null) {
                System.out.println("from " + node2.item + " to " + node.item);
            }
            if(node != null && node2 == null) {
                System.out.println("from null to " + node.item);
            }
            if(node2 != null && node == null) {
                System.out.println("from" + node2.item +  " to null");
            }
        });
    }
}
