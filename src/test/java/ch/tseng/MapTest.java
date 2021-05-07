package ch.tseng;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MapTest {
    Map map = null;

    @BeforeEach
    void beforeEach(){
        map = new Map();
    }

    @Test
    void getPermutationsPostfinanceHQ() {
        List<List<Node>> nodeListPermutations = map.getPermutationsPostfinanceHQ();
        Assertions.assertEquals(120, nodeListPermutations.size());
    }

    @Test
    void getPermutationsPowercoders() {
        List<List<Node>> nodeListPermutations = map.getPermutationsPowercoders();
        Assertions.assertEquals(120, nodeListPermutations.size());
    }

    @Test
    void getPermutationsEducreators() {
        List<List<Node>> nodeListPermutations = map.getPermutationsEducreators();
        Assertions.assertEquals(120, nodeListPermutations.size());
    }

    @Test
    void getPermutationsDsdFoundation() {
        List<List<Node>> nodeListPermutations = map.getPermutationsDsdFoundation();
        Assertions.assertEquals(120, nodeListPermutations.size());
    }

    @Test
    void EdgesCount() {
        Node[] nodes = map.getNodes();
        int edgeCount = 0;
        for (Node node: nodes) {
            edgeCount += node.getAdjacencies().length;
        }
        int expected = (8 + 9 + 7 + 8) * 2;
        Assertions.assertEquals(expected, edgeCount);
    }

    @Test
    void NodeCount() {
        int expected = 5 + (5 * 4);
        Assertions.assertEquals(expected, map.getNodes().length);
    }

    @Test
    void NodeCoords() {
        List<Point> coords = new ArrayList<>();
        // PF HQ
        coords.add(new Point(3,5));
        coords.add(new Point(10,8));
        coords.add(new Point(11,3));
        coords.add(new Point(14,7));
        coords.add(new Point(15,1));
        coords.add(new Point(18,5));

        // Powercoders
        coords.add(new Point(22,2));
        coords.add(new Point(26,4));
        coords.add(new Point(35,8));
        coords.add(new Point(26,9));
        coords.add(new Point(28,13));
        coords.add(new Point(19,9));

        // Educreators
        coords.add(new Point(19,13));
        coords.add(new Point(21,15));
        coords.add(new Point(24,17));
        coords.add(new Point(30,15));
        coords.add(new Point(34,17));
        coords.add(new Point(46,15));

        // DSD Foundation
        coords.add(new Point(38,14));
        coords.add(new Point(42,13));
        coords.add(new Point(41,2));
        coords.add(new Point(46,9));
        coords.add(new Point(48,3));
        coords.add(new Point(51,14));

        coords.add(new Point(54,8));

        Node[] nodes = map.getNodes();
        for (int i = 0; i < nodes.length; i++) {
            Point expected = coords.get(i);
            Assertions.assertEquals(expected.x, nodes[i].x);
            Assertions.assertEquals(expected.y, nodes[i].y);
        }
    }
}