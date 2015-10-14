package Graphs;

public class GraphNode {
    public enum State {
        Unvisited, Visiting, Visited
    }

    private String data;
    private GraphNode[] adjacent;
    private int count;
    private int adjacentLength;
    public State state;

    public GraphNode(String data, int adjacentLength) {
        this.data = data;
        this.adjacentLength = adjacentLength;
        adjacent=new GraphNode[adjacentLength];
        count=0;
    }

    public void addAdjacent(GraphNode node){
        if(count<adjacentLength)
            adjacent[count++]=node;
        else
            System.out.println("Adjacent is full");
    }
    public GraphNode[] getAdjacent(){
        return adjacent;
    }

    public String getData() {
        return data;
    }

    @Override
    public String toString() {
        return data;
    }
}
