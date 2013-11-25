package graphs;
import java.util.*;
public class ArrayGraphWeighted extends ArrayGraph{
	public ArrayGraphWeighted(int vertices){
		super(vertices);
	}
	public void addWeightedEdge(int from, int to, int weight, boolean directed){
		if(from >= 0 && from < graph.length && to >= 0 && to < graph.length){
			graph[from][to] = weight;
			if(!directed)
				graph[from][to] = weight;
		}
	}
	public ArrayList<Integer> getEdges(int from){
		ArrayList<Integer> edges = new ArrayList<Integer>();
		for(int i : graph[from])
			if(i != Integer.MIN_VALUE)
				edges.add(i);
		return edges;
	}
}
