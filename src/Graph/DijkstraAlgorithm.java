package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

// Source: https://de.wikipedia.org/wiki/Dijkstra-Algorithmus
public class DijkstraAlgorithm {
    private HashMap<Node, Integer> distances = new HashMap<>();
    private HashMap<Node, Node> predecessor = new HashMap<>();
    private ArrayList<Node<?>> nodesToQuery;

    /**
     * Apply dijkstra algorithm to graph
     * Evaluates predecessor nodes to find shortest path from startNode to every node in graph.
     * @param graph List of nodes representing a graph
     * @param startNode node to measure distance to
     * @return Map of predecessor node to every node in graph
     */
    public HashMap<Node, Node> eval(ArrayList<Node<?>> graph, Node startNode) {
        initialize(graph, startNode);
        while (!nodesToQuery.isEmpty()) {
            Node<?> nearestNode = minDistance().getKey();
            nodesToQuery.remove(nearestNode);

            for(Edge edge : nearestNode.edges) {
                Node neighbour = edge.target;
                if(nodesToQuery.contains(neighbour)) {
                    updateDistance(nearestNode, neighbour, edge.weight);
                }
            }
        }
        return predecessor;
    }

    /**
     * Compare distances from start node to every other node which is not queried.
     * @return node which is not queried with current minimum distance to startNode.
     */
    private Entry<Node, Integer> minDistance() {
        Entry<Node, Integer> min = null;
        for (Entry<Node, Integer> entry : distances.entrySet()) {
            if ((min == null || min.getValue() > entry.getValue()) && nodesToQuery.contains(entry.getKey())) {
                min = entry;
            }
        }
        return min;
    }

    /**
     * Update minimal distance and currentNode as predecessor to neighbour if distance is lower than previously known.
     * @param currentNode node as possible predecessor to neighbour
     * @param neighbour successor of currentNode connected by an edge
     * @param distanceBetween distance between currentNode and neighbour
     */
    private void updateDistance(Node<?> currentNode, Node<?> neighbour, int distanceBetween) {
        int alternativeDistance = distances.get(currentNode) + distanceBetween;
        if(alternativeDistance < distances.get(neighbour)) {
            distances.put(neighbour, alternativeDistance);
            predecessor.put(neighbour, currentNode);
        }
    }

    /**
     * Set distance to startNode to 0
     * Set predecessor of startNode to null
     * Set distance to other nodes to 'infinity'
     * Set graph nodes as nodeToQuery
     * @param graph List of nodes representing a graph
     * @param startNode node to measure distance to
     */
    private void initialize(ArrayList<Node<?>> graph, Node<?> startNode) {
        graph.forEach(node -> {
            distances.put(node, Integer.MAX_VALUE);
            predecessor.put(node, null);
        });
        distances.put(startNode, 0);
        nodesToQuery = g;
    }
}
