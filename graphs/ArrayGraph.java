package graphs;
import java.util.*;
//VxV representation of a graph
public abstract class ArrayGraph {
	protected int[][] graph;
	public ArrayGraph(int vertices){ //create graph
		//assume n vertices will be numbered from 0...n-1
		graph = new int[vertices][vertices];
		for(int[] a : graph)
			Arrays.fill(a, Integer.MIN_VALUE);
	}
	public int getEdge(int from, int to){
		return graph[from][to];
	}
	public abstract ArrayList<Integer> getEdges(int from);
}
