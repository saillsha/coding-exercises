import java.util.*;
// Question 1.7 in cracking the coding interview: 
//"Write an algorithm such that if an element in an MxN matrix is 0, its entire row and column is set to 0."
public class SetZero {
	public static void main(String[] args){
		int[][] arr = {{1, 2, 0, 4},{1, 2, 3, 4}, {0, 2, 3, 4}, {1, 2, 3, 0}};
		System.out.println("Before");
		printMatrix(arr);
		System.out.println("After");
		setZero(arr);
		printMatrix(arr);
	}
	public static void setZero(int[][] arr){
		int rows = arr.length;
		int cols = arr[0].length;
		boolean[] rowsArr = new boolean[rows];
		boolean[] colsArr = new boolean[cols];
		Arrays.fill(rowsArr, true);
		Arrays.fill(colsArr, true);

		for(int i=0; i<rows; i++)
			for(int j=0; j<cols; j++)
				if(arr[i][j] == 0)
					rowsArr[i] = colsArr[j] = false;
			
		
		for(int i=0; i<rows; i++){
			for(int j=0; j<cols; j++){
				if(!(rowsArr[i] && colsArr[j]))
					arr[i][j] = 0;
			}
		}
	}
	public static void fillCols(int[][] arr, int col){
		for(int counter=0; counter<arr.length; counter++){
			arr[counter][col] = 0;
		}
	}
	public static void printMatrix(int[][] arr){
		int row = arr.length;
		int col = arr[0].length;
		for(int i=0; i<row; i++){
			for(int j=0; j<col; j++){
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}
}
