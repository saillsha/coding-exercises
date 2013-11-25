package Arrays;
import java.util.*;
import Arrays.Node;
//http://www.careercup.com/question?id=16759664
public class FindMinSubrange {
	public static void main(String[] args){
		int[][] lists = {{4, 10, 15,24,26}, {0,9,12,20}, {5,7,11,18,22,30}};
		int[] minRange = findMinSubrange(lists);
		ArrayFactory.printArray(minRange);
	}
	
	public static int[] findMinSubrange(int[][] lists){
		int k = lists.length;
		ArrayList<Node> mergedList = merge(lists);

		//frequencies contains the number of occurrences of a  
		int[] frequencies = new int[k];
		
		//left and right indices of the current range we're looking at
		int leftIndex = 0, rightIndex = 0;
		
		//minimum range found so far
		int[] minRange = {0, mergedList.get(mergedList.size()-1).value};
		
		//number of lists that we have not found a number for in the given range
		//when remainingIndex == 0, then we have found a range with at least one number from each list
		int remainingIndex = k;
	
		//lists of nodes in the current range
		Deque<Node> currentRange = new LinkedList<Node>();
		
		for(;rightIndex < mergedList.size(); rightIndex++){
			Node nextNode = mergedList.get(rightIndex);
			currentRange.offerLast(nextNode);
			if(frequencies[nextNode.color]++ == 0)
				remainingIndex--;
			if(remainingIndex == 0){ //found a new range, check to see if new min
				//trim the front of the range of any extra numbers
				while(frequencies[currentRange.peekFirst().color] > 1){
					frequencies[currentRange.peekFirst().color]--;
					currentRange.pollFirst();
					leftIndex++;
				}
				//check if found a new minimum range
				if(mergedList.get(rightIndex).value - mergedList.get(leftIndex).value < minRange[1] - minRange[0] ){
					minRange[0] = mergedList.get(leftIndex).value;
					minRange[1] = mergedList.get(rightIndex).value;
				}
				leftIndex++;
				remainingIndex++;
				frequencies[currentRange.pollFirst().color]--;
			}
		}
		return minRange;
	}
	
	//merge k sorted lists into one sorted list with identifying color information
	// color is an int in the interval [0, k-1] that represents which list it came from
	private static ArrayList<Node> merge(int[][] lists){ 
		int totalSize = 0, k = lists.length;
		PriorityQueue<Node> nodeHeap = new PriorityQueue<Node>(k);
		//count the total number of elements in the lists while also populating the heap with the minimum from each list
		for(int i=0; i<k; i++){
			totalSize += lists[i].length;
			nodeHeap.offer(new Node(i, lists[i][0]));
		}
		ArrayList<Node> mergedList = new ArrayList<Node>(totalSize);
		
		//this array contains a pointer to the next element to merge in each of the k lists
		//initialize it to 1 since we already added the first element of each list to the heap
		int[] indices = new int[k];
		Arrays.fill(indices, 1);
		
		//extract and insert the head of the heap into the merged list.
		//whichever list the head belonged to, add the next element from that list into the heap
		while(!nodeHeap.isEmpty()){
			Node currentMin = nodeHeap.poll();
			int currentIndex = currentMin.color;
			mergedList.add(currentMin);
			if(indices[currentIndex] < lists[currentIndex].length){
				nodeHeap.offer(new Node(currentIndex, lists[currentIndex][indices[currentIndex]]));
				indices[currentIndex]++;
			}
		}
		return mergedList;
	}
}
