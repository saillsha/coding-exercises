package graphs;
//Encapsulates a graph node used in linked list representation
public class GraphNode {
	int vertex;
	int edgeTo = Integer.MIN_VALUE;
	public GraphNode(int vertex){
		this.vertex = vertex;
	}
}
