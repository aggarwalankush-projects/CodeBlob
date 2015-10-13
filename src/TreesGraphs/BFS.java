package TreesGraphs;

import java.util.ArrayDeque;

import static TreesGraphs.GraphNode.State.*;

//@formatter:off
/**
 * Given a directed graph, use Breadth First Search and
 * find out whether there is a route between two nodes.
 *      a
 *    / | \
 *   b  c  d
 *  /       \
 * e        f
 */
//@formatter:on

public class BFS {
    public static void main(String[] args) {
        Graph g = createGraph();
        GraphNode[] nodes = g.getNodes();
        GraphNode start = nodes[3];
        GraphNode end = nodes[5];
        System.out.println("Is there any path between " + start + " and " + end + ": " + search(g, start, end));
    }


    public static boolean search(Graph g, GraphNode start, GraphNode end) {
        ArrayDeque<GraphNode> queue = new ArrayDeque<>();
        for (GraphNode node : g.getNodes())
            node.state = Unvisited;
        start.state = Visiting;
        queue.offer(start);
        while (!queue.isEmpty()) {
            GraphNode node = queue.poll();
            if (node != null) {

                for (GraphNode child : node.getAdjacent()) {
                    if (child.state == Unvisited) {
                        if (child == end)
                            return true;
                        else {
                            child.state = Visiting;
                            queue.offer(child);
                        }
                    }
                }

                node.state = Visited;
            }
        }
        return false;
    }


    public static Graph createGraph() {
        Graph g = new Graph(6);
        GraphNode[] nodes = new GraphNode[6];

        nodes[0] = new GraphNode("a", 3);
        nodes[1] = new GraphNode("b", 1);
        nodes[2] = new GraphNode("c", 0);
        nodes[3] = new GraphNode("d", 1);
        nodes[4] = new GraphNode("e", 0);
        nodes[5] = new GraphNode("f", 0);

        nodes[0].addAdjacent(nodes[1]);
        nodes[0].addAdjacent(nodes[2]);
        nodes[0].addAdjacent(nodes[3]);
        nodes[1].addAdjacent(nodes[4]);
        nodes[3].addAdjacent(nodes[5]);
        for (int i = 0; i < 6; i++) {
            g.addNode(nodes[i]);
        }
        return g;
    }

}

