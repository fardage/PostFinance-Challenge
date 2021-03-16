package ch.tseng;

import java.util.ArrayList;
import java.util.List;

public class Map {
    private final Node start;
    private final Node goal;
    private final Node[] nodes;

    public Map() {
        Node postfinanceHQ = new Node("0", 3, 5);
        Node n11 = new Node("1", 10, 8);
        Node n12 = new Node("2", 11, 3);
        Node n13 = new Node("3", 14, 7);
        Node n14 = new Node("4", 15, 1);
        Node n15 = new Node("5", 18, 5);
        Node powercoders = new Node("6", 22, 2);
        Node n21 = new Node("7", 26, 4);
        Node n22 = new Node("8", 35, 8);
        Node n23 = new Node("9", 26, 9);
        Node n24 = new Node("10", 28, 13);
        Node n25 = new Node("11", 19, 9);
        Node educreators = new Node("12", 19, 13);
        Node n31 = new Node("13", 21, 15);
        Node n32 = new Node("14", 24, 17);
        Node n33 = new Node("15", 30, 15);
        Node n34 = new Node("16", 34, 17);
        Node n35 = new Node("17", 46, 15);
        Node dsdFoundation = new Node("18", 38, 14);
        Node n41 = new Node("19", 42, 13);
        Node n42 = new Node("20", 41, 2);
        Node n43 = new Node("21", 46, 9);
        Node n44 = new Node("22", 48, 3);
        Node n45 = new Node("23", 51, 14);
        Node charityevent = new Node("24", 54, 8);

        postfinanceHQ.setAdjacencies(new Edge[]{
                new Edge(postfinanceHQ, n11),
                new Edge(postfinanceHQ, n12)
        });
        n11.setAdjacencies(new Edge[]{
                new Edge(n11, postfinanceHQ),
                new Edge(n11, n13)
        });
        n12.setAdjacencies(new Edge[]{
                new Edge(n12, postfinanceHQ),
                new Edge(n12, n14),
                new Edge(n12, n15)
        });
        n13.setAdjacencies(new Edge[]{
                new Edge(n13, n11),
                new Edge(n13, n15)
        });
        n14.setAdjacencies(new Edge[]{
                new Edge(n14, n12),
                new Edge(n14, powercoders)
        });
        n15.setAdjacencies(new Edge[]{
                new Edge(n15, n12),
                new Edge(n15, n13),
                new Edge(n15, powercoders)
        });
        powercoders.setAdjacencies(new Edge[]{
                new Edge(powercoders, n14),
                new Edge(powercoders, n15),
                new Edge(powercoders, n21),
                new Edge(powercoders, n23)
        });
        n21.setAdjacencies(new Edge[]{
                new Edge(n21, n22),
                new Edge(n21, powercoders)
        });
        n22.setAdjacencies(new Edge[]{
                new Edge(n22, n21),
                new Edge(n22, n23),
                new Edge(n22, n24),
        });
        n23.setAdjacencies(new Edge[]{
                new Edge(n23, powercoders),
                new Edge(n23, n22),
                new Edge(n23, n24),
                new Edge(n23, n25)
        });
        n24.setAdjacencies(new Edge[]{
                new Edge(n24, n22),
                new Edge(n24, n23),
                new Edge(n24, educreators)
        });
        n25.setAdjacencies(new Edge[]{
                new Edge(n25, n23),
                new Edge(n25, educreators)
        });
        educreators.setAdjacencies(new Edge[]{
                new Edge(educreators, n24),
                new Edge(educreators, n25),
                new Edge(educreators, n31)
        });
        n31.setAdjacencies(new Edge[]{
                new Edge(n31, n32),
                new Edge(n31, educreators)
        });
        n32.setAdjacencies(new Edge[]{
                new Edge(n32, n31),
                new Edge(n32, n33),
                new Edge(n32, n34),
        });
        n33.setAdjacencies(new Edge[]{
                new Edge(n33, n32),
                new Edge(n33, dsdFoundation)
        });
        n34.setAdjacencies(new Edge[]{
                new Edge(n34, n32),
                new Edge(n34, n35)
        });
        n35.setAdjacencies(new Edge[]{
                new Edge(n35, n34),
                new Edge(n35, dsdFoundation)
        });
        dsdFoundation.setAdjacencies(new Edge[]{
                new Edge(dsdFoundation, n33),
                new Edge(dsdFoundation, n35),
                new Edge(dsdFoundation, n41),
        });
        n41.setAdjacencies(new Edge[]{
                new Edge(n41, n42),
                new Edge(n41, n45),
                new Edge(n41, dsdFoundation)
        });
        n42.setAdjacencies(new Edge[]{
                new Edge(n42, n41),
                new Edge(n42, n43),
                new Edge(n42, n44)
        });
        n43.setAdjacencies(new Edge[]{
                new Edge(n43, n42),
                new Edge(n43, charityevent)
        });
        n44.setAdjacencies(new Edge[]{
                new Edge(n44, n42),
                new Edge(n44, charityevent)
        });
        n45.setAdjacencies(new Edge[]{
                new Edge(n45, n41),
                new Edge(n45, charityevent)
        });
        charityevent.setAdjacencies(new Edge[]{
                new Edge(charityevent, n43),
                new Edge(charityevent, n44),
                new Edge(charityevent, n45)
        });

        start = postfinanceHQ;
        goal = charityevent;
        nodes = new Node[]{
                postfinanceHQ, n11, n12, n13, n14, n15,
                powercoders, n21, n22, n23, n24, n25,
                educreators, n31, n32, n33, n34, n35,
                dsdFoundation, n41, n42, n43, n44, n45,
                charityevent
        };
    }

    public List<List<Integer>> getPermutationsPostfinanceHQ() {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);

        List<List<Integer>> permutations = generatePermutations(list);
        permutations.removeIf(permutation -> permutation.get(0) != 0 || permutation.get(6) != 6);

        return permutations;
    }

    public List<List<Integer>> getPermutationsPowercoders() {
        List<Integer> list = new ArrayList<>();
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        list.add(10);
        list.add(11);
        list.add(12);

        List<List<Integer>> permutations = generatePermutations(list);
        permutations.removeIf(permutation -> permutation.get(0) != 6 || permutation.get(6) != 12);

        return permutations;
    }

    public List<List<Integer>> getPermutationsEducreators() {
        List<Integer> list = new ArrayList<>();
        list.add(12);
        list.add(13);
        list.add(14);
        list.add(15);
        list.add(16);
        list.add(17);
        list.add(18);

        List<List<Integer>> permutations = generatePermutations(list);
        permutations.removeIf(permutation -> permutation.get(0) != 12 || permutation.get(6) != 18);

        return permutations;
    }

    public List<List<Integer>> getPermutationsDsdFoundation() {
        List<Integer> list = new ArrayList<>();
        list.add(18);
        list.add(19);
        list.add(20);
        list.add(21);
        list.add(22);
        list.add(23);
        list.add(24);

        List<List<Integer>> permutations = generatePermutations(list);

        permutations.removeIf(permutation -> permutation.get(0) != 18 || permutation.get(6) != 24);

        return permutations;
    }

    private <E> List<List<E>> generatePermutations(List<E> original) {
        if (original.isEmpty()) {
            List<List<E>> result = new ArrayList<>();
            result.add(new ArrayList<>());
            return result;
        }

        E firstElement = original.remove(0);
        List<List<E>> returnValue = new ArrayList<>();
        List<List<E>> permutations = generatePermutations(original);

        for (List<E> smallerPermutated : permutations) {
            for (int index = 0; index <= smallerPermutated.size(); index++) {
                List<E> temp = new ArrayList<>(smallerPermutated);
                temp.add(index, firstElement);
                returnValue.add(temp);
            }
        }
        return returnValue;
    }

    private Edge isConnectedVia(Edge[] edges, Node toNode) {
        for (Edge edge : edges) {
            if (edge.getTarget().equals(toNode)) {
                return edge;
            }
        }
        return null;
    }

    public double[][] getAdjacencyMatrix() {
        double[][] adjacencyMatrix = new double[nodes.length][nodes.length];
        Node[] fromNodes = nodes;
        Node[] toNodes = nodes;

        for (int i = 0; i < fromNodes.length; i++) {
            Node from = fromNodes[i];
            Edge[] edges = from.getAdjacencies();
            double[] row = new double[fromNodes.length];

            for (int j = 0; j < toNodes.length; j++) {
                Node to = toNodes[j];
                if (!from.equals(to)) {
                    Edge edge = isConnectedVia(edges, to);
                    if (edge != null) {
                        row[j] = edge.getWeight();
                    } else {
                        row[j] = Double.POSITIVE_INFINITY;
                    }
                } else {
                    row[j] = Double.POSITIVE_INFINITY;
                }
            }
            adjacencyMatrix[i] = row;
        }
        return adjacencyMatrix;
    }

    public Node getStart() {
        return start;
    }

    public Node getGoal() {
        return goal;
    }

    public Node[] getNodes() {
        return nodes;
    }

    public Node getNodeByName(String name) {
        for (Node node : getNodes()) {
            if (node.getName().equals(name)) {
                return node;
            }
        }
        return null;
    }
}
