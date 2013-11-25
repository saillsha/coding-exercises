
public class Queue {
	Node front, last;
	public Queue(int value){
		front = new Node(value);
		last = front;
	}
	public Queue(Node n){
		front = n;
		last = front;
	}
	public Queue(){
		front = null;
		last = null;
	}
	public void enqueue(int n){
		if(front == null){
			front = new Node(n);
			last = front;
		}
		else{
			last.next=  new Node(n);
			last = last.next;
		}
	}
	public Node dequeue(){
		if(front == null)
			return null;
		Node f = front;
		front = front.next;
		return f;
	}
}
