package ch.tseng;

import java.util.ArrayList;
import java.util.List;

public class Calculator {

    private Calculator() {
    }

    public static double getDirectDistance(List<Node> path) {
        double sumDistance = 0;

        for (int i = 0; i < path.size() - 1; i++) {
            Node nodeA = path.get(i);
            Node nodeB = path.get(i + 1);
            sumDistance += getDirectDistance(nodeA, nodeB);
        }
        return sumDistance;
    }

    public static double getDirectDistance(Node nodeA, Node nodeB) {
        double xDiffQuad = Math.pow((double) nodeA.x - nodeB.x, 2);
        double yDiffQuad = Math.pow((double) nodeA.y - nodeB.y, 2);
        return Math.sqrt(xDiffQuad + yDiffQuad);
    }

    public static double getPathDistance(List<Node> path, double[][] floydWarshallMatrix) {
        double distance = 0;
        for (int i = 0; i < path.size() - 1; i++) {
            int fromIndex = path.get(i).id;
            int toIndex = path.get(i + 1).id;
            distance += floydWarshallMatrix[fromIndex][toIndex];
        }
        return distance;
    }

    public static double getBestPathDistance(List<List<Node>> pathList) {
        List<List<Node>> paths = new ArrayList<>(pathList);
        double best = Double.POSITIVE_INFINITY;

        for (List<Node> nodeList : paths) {
            double distance = 0;
            for (int i = 0; i < nodeList.size() - 1; i++) {
                Map map = new Map();

                int from = nodeList.get(i).id;
                int to = nodeList.get(i + 1).id;

                DijkstraAlgorithm dijkstraAlgorithm = new DijkstraAlgorithm();
                dijkstraAlgorithm.computePaths(map.getNodeById(from));

                List<Node> shortestPath = dijkstraAlgorithm.getShortestPathTo(map.getNodeById(to));

                distance += Calculator.getDirectDistance(shortestPath);
            }
            best = Math.min(best, distance);
        }
        return best;
    }

    public static double getBestPathDistance(List<List<Node>> paths, double[][] floydWarshallMatrix) {
        double best = Double.POSITIVE_INFINITY;

        for (List<Node> nodeList : paths) {
            double distance = Calculator.getPathDistance(nodeList, floydWarshallMatrix);
            best = Math.min(best, distance);
        }
        System.out.println(best);
        return best;
    }
}
