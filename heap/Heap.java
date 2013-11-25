package heap;
import java.util.*;
public class Heap {
	ArrayList<Integer> heap;
	public Heap(){
		heap = new ArrayList<Integer>();
	}
	public Heap(Integer[] array){
		heap = new ArrayList<Integer>(Arrays.asList(array));
		buildHeap();
	}
	//               0
	//        1              2
	//     3     4       5        6
	//   7   8 9  10  11   12  13   14
	private void buildHeap(){
		for(int i=(heap.size()-2)/2; i >= 0; i++){
			int maxChild = (i*2+2 < heap.size() && heap.get(i*2+1) < heap.get(i*2+2)) ? i*2+2 : i*2+1;
			if(heap.get(maxChild) > heap.get(i)){
				Integer temp = heap.get(i);
				heap.set(i, heap.get(maxChild));
				heap.set(maxChild, temp);
			}
		}
	}
	
	public Integer peek(){ return heap.get(0); }

	public int size(){ return heap.size(); }
	
	public Integer pop(){
		int retVal = heap.get(0);
		heap.set(0, heap.get(heap.size()-1));
		heap.remove(heap.size()-1);
		for(int i=0; i*2+1 < heap.size();){
			int maxChild = (i*2+2 < heap.size() && heap.get(i*2+1) < heap.get(i*2+2)) ? i*2+2 : i*2+1;
			if(heap.get(maxChild) > heap.get(i)){
				Integer temp = heap.get(i);
				heap.set(i, heap.get(maxChild));
				heap.set(maxChild, temp);
				i = maxChild;
			}
			else
				break;
		}
		return retVal;
	}
	
	public void add(Integer i){
		heap.add(i);
		int index = heap.size()-1;
		while(index >= 0){
			int parent = (index-1)/2;
			if(heap.get(parent) >= heap.get(index))
				return;

			Integer temp = heap.get(index);
			heap.set(index, heap.get(parent));
			heap.set(parent, temp);
			index = parent;
		}
	}
}
