package heap;

public class HeapDriver {
	public static void main(String[] args){
		Heap h = new Heap();
		h.add(4);
		h.add(1);
		h.add(5);
		h.add(2);
		h.add(0);
		h.add(6);
		h.add(3);
		for(int i=h.size()-1; i >= 0; i--)
			System.out.print(h.pop()+" ");
	}
}
