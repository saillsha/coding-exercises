
public class Stack {
	public Node top;
	public int min;
	public Stack(int value){
		top = new Node(value);
		min = value;
	}
	public Stack(){
		top = null;
	}
	public Node pop(){
		if(top == null)
			return null;
		Node t = top;
		top = top.next;
		return t;
	}
	public void push(int value){
		Node n = new Node(value);
		n.next = top;
		top = n;
	}
}
