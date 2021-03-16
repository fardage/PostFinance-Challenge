package ch.tseng;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DijkstraAlgorithmTest {

    @Test
    void getShortestPathTo() {
        Map map = new Map();

        FloydWarshallAlgorithm floydWarshallAlgorithm = new FloydWarshallAlgorithm();
        double[][] floydWarshallMatrix = floydWarshallAlgorithm.getNewMatrix(map.getAdjacencyMatrix());

        for (int i = 0; i < floydWarshallMatrix.length; i++) {
            for (int j = 0; j < floydWarshallMatrix.length; j++) {
                double expected = floydWarshallMatrix[i][j];

                if (i != j) {
                    map = new Map();
                    Node start = map.getNodeByName(String.valueOf(i));
                    Node goal = map.getNodeByName(String.valueOf(j));

                    DijkstraAlgorithm dijkstraAlgorithm = new DijkstraAlgorithm();
                    dijkstraAlgorithm.computePaths(start);
                    List<Node> path = dijkstraAlgorithm.getShortestPathTo(goal);
                    double pathLength = Calculator.getDirectDistance(path);

                    Assertions.assertEquals(expected, pathLength, 0.0001);
                }
            }
        }
    }
}