package ch.tseng;

public class Edge {
    private final Node source;
    private final Node target;
    private final double weight;

    public Edge(Node from, Node to) {
        this.source = from;
        this.target = to;
        weight = Calculator.getDirectDistance(from, to);
    }

    public Node getTarget() {
        return target;
    }

    public double getWeight() {
        return weight;
    }

    public Node getSource() {
        return source;
    }
}
