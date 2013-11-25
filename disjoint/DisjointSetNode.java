package disjoint;

public class DisjointSetNode<T> {
	T value;
	DisjointSetNode<T> parent;
	int rank;
	public DisjointSetNode(T value){
		this.value = value;
		rank = 0;
		parent = this;
	}
	public String toString(){
		DisjointSetNode<T> current = this;
		StringBuilder sb = new StringBuilder();
		while(current.parent != current){
			sb.append(current.value);
			sb.append("->");
			current = current.parent;
		}
		sb.append(current.value);
		return sb.toString();
	}
}
