
public class Node {
	public Node next;
	public int value;
	public Node(int value){
		this.value = value;
		this.next = null;
	}
	public void printList(){
		Node head = this;
		while(head != null){
			System.out.print(head.value+" ");
			head = head.next;
		}
		System.out.println();
	}
	public Node addToTail(int d){
		Node n = new Node(d);
		Node head = this;
		while(head.next != null){
			head = head.next;
		}
		head.next = n;
		return n;
	}
	public Node deleteNode(int d){
		if(value == d){
			return next;
		}
		if(next == null)
			return null;
		Node head = next;
		Node tail = this;
		while(head != null){
			if(head.value == d){
				tail.next = head.next;
				return head;
			}
			tail = head;
			head = head.next;
		}
		return this;
	}
}
