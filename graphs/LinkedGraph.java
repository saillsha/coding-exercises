package graphs;
import java.util.*;
public class LinkedGraph {
	ArrayList<GraphNode>[] graph = new ArrayList<GraphNode>[3];
	public LinkedGraph(int vertices){
		graph = new ArrayList<GraphNode>[vertices];
	}
}
