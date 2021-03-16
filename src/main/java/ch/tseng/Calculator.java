package ch.tseng;

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
        double xDiffQuad = Math.pow((double) nodeA.getX() - nodeB.getX(), 2);
        double yDiffQuad = Math.pow((double) nodeA.getY() - nodeB.getY(), 2);
        return Math.sqrt(xDiffQuad + yDiffQuad);
    }

    public static double getPathDistance(double[][] matrix, List<Integer> path) {
        double distance = 0;
        for (int i = 0; i < path.size() - 1; i++) {
            int fromIndex = path.get(i);
            int toIndex = path.get(i + 1);
            distance += matrix[fromIndex][toIndex];
        }
        return distance;
    }

    public static double getBestPathDistance(List<List<Integer>> paths) {
        double best = Double.POSITIVE_INFINITY;
        for (List<Integer> nodeList : paths) {
            double distance = 0;
            for (int i = 0; i < nodeList.size() - 1; i++) {
                DijkstraAlgorithm dijkstraAlgorithm = new DijkstraAlgorithm();
                Map map = new Map();

                int fromIndex = nodeList.get(i);
                Node fromNode = map.getNodeByName(String.valueOf(fromIndex));
                int toIndex = nodeList.get(i + 1);
                Node toNode = map.getNodeByName(String.valueOf(toIndex));

                dijkstraAlgorithm.computePaths(fromNode);
                List<Node> shortestPath = dijkstraAlgorithm.getShortestPathTo(toNode);
                distance += Calculator.getDirectDistance(shortestPath);
            }
            best = Math.min(best, distance);
        }
        return best;
    }

    public static double getBestPathDistance(List<List<Integer>> paths, double[][] floydWarshallMatrix) {
        double best = Double.POSITIVE_INFINITY;
        List<Integer> bestPath = null;
        for (List<Integer> nodeList : paths) {
            double distance = Calculator.getPathDistance(floydWarshallMatrix, nodeList);
            if (Calculator.getPathDistance(floydWarshallMatrix, nodeList) < best) {
                best = distance;
                bestPath = nodeList;
            }
        }
        System.out.print(String.format("%4.2f, ", best));
        System.out.println(bestPath);
        return best;
    }
}
