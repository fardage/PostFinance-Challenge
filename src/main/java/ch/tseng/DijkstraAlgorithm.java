package ch.tseng;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class DijkstraAlgorithm {
    public void computePaths(Node startNode) {
        startNode.setShortestDistance(0);

        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(startNode);

        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();

            for (Edge edge : currentNode.getAdjacencies()) {
                Node targetNode = edge.getTarget();
                double weight = edge.getWeight();
                double distanceFromCurrent = currentNode.getShortestDistance() + weight;

                if (distanceFromCurrent < targetNode.getShortestDistance()) {
                    queue.remove(targetNode);
                    targetNode.setShortestDistance(distanceFromCurrent);
                    targetNode.setParent(currentNode);
                    queue.add(targetNode);
                }
            }
        }
    }

    public List<Node> getShortestPathTo(Node target) {
        List<Node> path = new ArrayList<>();
        for (Node node = target; node != null; node = node.getParent()) {
            path.add(node);
        }
        Collections.reverse(path);
        return path;
    }
}
