package disjoint;

public class DisjointSet {
	public static DisjointSetNode<Integer> makeSet(int i){
		return new DisjointSetNode<Integer>(i);
	}
	public static DisjointSetNode<Integer> findSet(DisjointSetNode<Integer> node){
		if(!node.equals(node.parent))
			node.parent = findSet(node.parent);
		return node.parent;
	}
	public static DisjointSetNode<Integer> union(DisjointSetNode<Integer> n1, DisjointSetNode<Integer> n2){
		n1 = findSet(n1);
		n2 = findSet(n2);
		if(n1.rank > n2.rank){ //add n2 as child of n1
			n2.parent = n1;
		}
		else{
			n1.parent = n2;
			 if(n1.rank == n2.rank)
				 n2.rank++;
		}
		return n1;
	}
}
