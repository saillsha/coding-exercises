package graphs;
import java.util.*;
public class ArrayGraphUnweighted extends ArrayGraph{
	public ArrayGraphUnweighted(int vertices){
		super(vertices);
	}
	public void addUnweightedEdge(int from, int to, boolean directed){
		if(from >= 0 && from < graph.length && to >= 0 && to < graph.length){
			graph[from][to]=1;
			if(!directed)
				graph[to][from] = 1;
		}
	}
	public ArrayList<Integer> getEdges(int from){
		ArrayList<Integer> edges = new ArrayList<Integer>();
		for(int i : graph[from])
			if(i > 0)
				edges.add(i);
		return edges;
	}
}
