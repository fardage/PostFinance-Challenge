package ch.tseng;

import java.util.Objects;

public class Node implements Comparable<Node> {
    public final int id;
    private Node parent;
    private double shortestDistance = Double.POSITIVE_INFINITY;
    private Edge[] adjacencies;
    public final int x;
    public final int y;

    public Node(int id, int x, int y) {
        this.id = id;
        this.x = x;
        this.y = y;
    }

    public double getShortestDistance() {
        return shortestDistance;
    }

    public void setShortestDistance(double shortestDistance) {
        this.shortestDistance = shortestDistance;
    }

    @Override
    public String toString() {
        return String.format("%s (%d,%d)", id, x, y);
    }

    @Override
    public int compareTo(Node otherNode) {
        return Double.compare(shortestDistance, otherNode.shortestDistance);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (!(o instanceof Node)) {
            return false;
        }

        Node n = (Node) o;

        return x == n.x && y == n.y && id == n.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, id);
    }

    public Edge[] getAdjacencies() {
        return adjacencies;
    }

    public void setAdjacencies(Edge[] adjacencies) {
        this.adjacencies = adjacencies;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }
}

