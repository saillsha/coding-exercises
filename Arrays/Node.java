package Arrays;

//class used within FindMinSubrange.java for encapsulating color and value information
class Node implements Comparable<Node>{
	int color, value;
	public Node(int color, int value){
		this.color = color;
		this.value = value;
	}
	public int compareTo(Node n){
		return this.value - n.value;
	}
}
