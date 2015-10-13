package TreesGraphs;

public class Graph {
    private GraphNode[] nodes;
    private int size;
    private int count;

    public Graph(int size) {
        this.size = size;
        nodes = new GraphNode[size];
        count = 0;
    }

    public void addNode(GraphNode node) {
        if (count < size)
            nodes[count++] = node;
        else
            System.out.println("Graph is Full");
    }

    public GraphNode[] getNodes() {
        return nodes;
    }
}
