package linkedlist;

public class Union {
	public static Node union(Node n1, Node n2){
		Node union = null;
		while(n1 != null || n2 != null){
			if(n1 == null){
				Node n = new Node(n2.value);
				n.next = union;
				union = n;
				n2 = n2.next;
			}
			else if(n2 == null){
				Node n = new Node(n1.value);
				n.next = union;
				union = n;
				n1 = n1.next;
			}
			else if(n1.value == n2.value){
				Node n = new Node(n1.value);
				n.next = union;
				union = n;
				n1 = n1.next;
				n2 = n2.next;
			}
			else if(n1.value < n2.value){
				Node n = new Node(n1.value);
				n.next = union;
				union = n;
				n1 = n1.next;
			}
			else{
				Node n = new Node(n2.value);
				n.next = union;
				union = n;
				n2 = n2.next;
			}
		}
		return union;
	}
}
