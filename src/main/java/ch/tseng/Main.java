package ch.tseng;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        Map map = new Map();

        // Dijkstra
        Node start = map.getStart();
        Node goal = map.getGoal();

        DijkstraAlgorithm dijkstraAlgorithm = new DijkstraAlgorithm();
        dijkstraAlgorithm.computePaths(start);
        List<Node> path = dijkstraAlgorithm.getShortestPathTo(goal);

        double pathLength = Calculator.getDirectDistance(path);
        System.out.println("Dijkstra - Shortest Path");
        System.out.println("Path: " + path);
        System.out.println("Distance: " + pathLength);
        System.out.println();

        // Floyd Warshall
        FloydWarshallAlgorithm floydWarshallAlgorithm = new FloydWarshallAlgorithm();
        double[][] floydWarshallMatrix = floydWarshallAlgorithm.getNewMatrix(map.getAdjacencyMatrix());

        floydWarshallAlgorithm.printMatrix(floydWarshallMatrix);
        System.out.println();

        System.out.println("Shortest Path - Visiting all");
        double totalDistance = 0;
        totalDistance += Calculator.getBestPathDistance(map.getPermutationsPostfinanceHQ(), floydWarshallMatrix);
        totalDistance += Calculator.getBestPathDistance(map.getPermutationsPowercoders(), floydWarshallMatrix);
        totalDistance += Calculator.getBestPathDistance(map.getPermutationsEducreators(), floydWarshallMatrix);
        totalDistance += Calculator.getBestPathDistance(map.getPermutationsDsdFoundation(), floydWarshallMatrix);
        System.out.println(totalDistance);
    }
}
