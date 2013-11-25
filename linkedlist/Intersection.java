package linkedlist;

public class Intersection {
	public static Node intersection(Node n1, Node n2){
		Node intersect = null;
		while(n1 != null && n2 != null){
			if(n1.value == n2.value){
				Node n = new Node(n1.value);
				n.next = intersect;
				intersect = n;
				n1 = n1.next;
				n2 = n2.next;
			}
			else if(n1.value < n2.value)
				n1 = n1.next;
			else
				n2 = n2.next;
		}
		return intersect;
	}
}
