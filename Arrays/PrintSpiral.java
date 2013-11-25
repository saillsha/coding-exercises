package Arrays;
public class PrintSpiral {
	static final int UP_C = 0;
	static final int UP_R = 1;
	static final int DOWN_C = 2;
	static final int DOWN_R = 3;
	public static void main(String[] args){
		int[][] array = {{1,2,3,4},{12,13,14,5}, {11,16,15,6}, {10, 9, 8, 7}};
		printSpiral(array);

	}

	public static void printSpiral(int[][] arr){
		//print out first row explicitly
		for(int i:arr[0])
			System.out.println(i);
		int dir = UP_R;
		int times = arr.length - 1;
		int row = 0;
		int col = arr.length - 1;
		boolean decrement = false;
		while(times > 0){
			for(int i = 0; i<times; i++){
				switch(dir){
				case UP_C:
					col++;break;
				case UP_R:
					row++;break;
				case DOWN_C:
					col--;break;
				case DOWN_R:
					row--;break;
				}
				System.out.println(arr[row][col]);
			}
			dir = (dir+1)%4;
			if(decrement)
				times--;
			decrement = !decrement;
		}
	}
}
