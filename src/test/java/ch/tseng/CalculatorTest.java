package ch.tseng;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void getDirectDistanceBetweenNodes() {
        Node nodeA = new Node(0, 3, 5);
        Node nodeB = new Node(1, 10, 8);
        double distance = Calculator.getDirectDistance(nodeA, nodeB);
        double distanceTwoDec = Math.round(distance * 100.0) / 100.0;
        Assertions.assertEquals(7.62, distanceTwoDec);
    }

    @Test
    void getPathDistanceForPath() {
        List<Node> nodeList = new ArrayList<>();
        Node nodeA = new Node(0, 1, 1);
        nodeList.add(nodeA);
        Node nodeB = new Node(1, 2, 2);
        nodeList.add(nodeB);
        Node nodeC = new Node(2, 3, 5);
        nodeList.add(nodeC);

        double expected = 1.414214 + 3.162278;
        double expectedTwoDec = Math.round(expected * 100.0) / 100.0;;

        double distance = Calculator.getDirectDistance(nodeList);
        double distanceTwoDec = Math.round(distance * 100.0) / 100.0;
        Assertions.assertEquals(expectedTwoDec, distanceTwoDec);
    }

    @Test
    void getPathDistance() {
        Map map = new Map();
        Node start = map.getStart();
        Node goal = map.getGoal();

        // Dijkstra
        DijkstraAlgorithm dijkstraAlgorithm = new DijkstraAlgorithm();
        dijkstraAlgorithm.computePaths(start);
        List<Node> path = dijkstraAlgorithm.getShortestPathTo(goal);
        double pathLengthDijkstra = Calculator.getDirectDistance(path);

        // FloydWarshall
        FloydWarshallAlgorithm floydWarshallAlgorithm = new FloydWarshallAlgorithm();
        double[][] floydWarshallMatrix = floydWarshallAlgorithm.getNewMatrix(map.getAdjacencyMatrix());
        double pathLengthFloydWarshall = floydWarshallMatrix[0][floydWarshallMatrix.length - 1];

        Assertions.assertEquals(pathLengthDijkstra, pathLengthFloydWarshall);
    }

    @Test
    void getBestPathDistance() {
        Map map = new Map();
        double totalDistanceFW = 0;
        FloydWarshallAlgorithm floydWarshallAlgorithm = new FloydWarshallAlgorithm();
        double[][] floydWarshallMatrix = floydWarshallAlgorithm.getNewMatrix(map.getAdjacencyMatrix());
        totalDistanceFW += Calculator.getBestPathDistance(map.getPermutationsPostfinanceHQ(), floydWarshallMatrix);
        totalDistanceFW += Calculator.getBestPathDistance(map.getPermutationsPowercoders(), floydWarshallMatrix);
        totalDistanceFW += Calculator.getBestPathDistance(map.getPermutationsEducreators(), floydWarshallMatrix);
        totalDistanceFW += Calculator.getBestPathDistance(map.getPermutationsDsdFoundation(), floydWarshallMatrix);

        double totalDistanceDij = 0;
        totalDistanceDij += Calculator.getBestPathDistance(map.getPermutationsPostfinanceHQ());
        totalDistanceDij += Calculator.getBestPathDistance(map.getPermutationsPowercoders());
        totalDistanceDij += Calculator.getBestPathDistance(map.getPermutationsEducreators());
        totalDistanceDij += Calculator.getBestPathDistance(map.getPermutationsDsdFoundation());

        Assertions.assertEquals(totalDistanceDij, totalDistanceFW);
    }
}