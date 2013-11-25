package linkedlist;

public class LinkedListDriver {
	public static void main(String[] args){
		Node n1 = new Node(2);
		n1.addToTail(3);
		n1.addToTail(4);
		n1.addToTail(7);
		n1.addToTail(9);
		n1.addToTail(10);
		Node n2 = new Node(2);
		n2.addToTail(4);
		n2.addToTail(8);
		n2.addToTail(9);
		
		Node intersect = Intersection.intersection(n1, n2);
		intersect.printList();
		Union.union(n1, n2).printList();
	}
}
