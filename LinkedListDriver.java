
public class LinkedListDriver {
	public static void main(String[] args){
		Node n1 = new Node(9);
		Node n2 = n1.addToTail(2);
		n1.addToTail(3);
		Node n3 =n1.addToTail(5);
		n3.next = n2;
		System.out.println(findLoop(n1).value);
	}
	public static Node findLoop(Node head){
		if(head.next == null)
			return null;
		Node current = head.next;
		int limit = 1;
		while(current != null){
			Node runner = head;
			for(int i=0; i< limit; i++)
				if(current == runner)
					return runner;
				else
					runner = runner.next;
			current = current.next;
			limit++;
		}
		return null;
	}
	
	public static Node addLinkedLists(Node n1, Node n2){
		int sum = n1.value + n2.value;
		Node head = new Node(sum%10);
		int carry = sum/10;
		Node tail = head;
		while(n1.next != null || n2.next != null){
			int s1 = (n1.next == null) ? 0 : n1.next.value;
			int s2 = (n2.next == null) ? 0 : n2.next.value;
			sum = s1+s2+carry;
			carry = sum/10;
			tail.next = new Node(sum%10);
			tail = tail.next;
			if(n1.next != null)
				n1 = n1.next;
			if(n2.next != null)
				n2 = n2.next;
		}
		if(carry > 0)
			tail.next = new Node(carry%10);
		return head;
	}
	
	public static void removeMiddle(Node n){
		while(n.next.next != null){
			n.value = n.next.value;
			n = n.next;
		}
		n.value = n.next.value;
		n.next = null;
	}
	public static Node removeDups(Node n){
		if(n == null || n.next == null)
			return n;
		Node head = n.next;
		while(head != null){
			Node runner = n;
			if(n.value == head.value)
				n = n.next;
			else{
				while(runner.next != head){
					if(runner.next.value == head.value){
						runner.next = runner.next.next;
						break;
					}
					runner = runner.next;
				}
			}
			head = head.next;
		}
		return n;
	}
	
	public static int findNth(Node n, Node found, int nth){
		if(n == null)
			return 1;
		int retVal = findNth(n.next, found, nth);
		if(retVal == nth)
			found.value = n.value;
		return retVal+1;
	}
}
