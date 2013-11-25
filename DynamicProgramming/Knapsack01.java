package DynamicProgramming;
import java.util.ArrayList;
import java.util.Arrays;

public class Knapsack01 {
	public static void main(String[] args){
		int[] values = {3,4,5,8,10};
		int[] weights = {2,3,4,5,9};
		int weight = 20;
		int[][] path = new int[values.length][weight+1];
		System.out.println("Maximum value for knapsack is " + knapsack01(values, weights, path, weight));
		System.out.print("The weights of the objects in the knapsack are: ");
		printPath(path, weights, path.length-1, path[0].length-1);
	}
	public static void printPath(int[][] path, int[] weights, int i, int j){
		if(i == 0 && path[i][j] == 0)
			System.out.print(weights[i]+" ");
		else if(path[i][j] != i)
			printPath(path, weights, i-1, j);
		else{
			printPath(path, weights, i-1, j-weights[i]);
			System.out.print(weights[i]+" ");
		}
			
		
	}
	public static int knapsack01(int[] values, int[] weights, int[][] path, int size){
		int[][] table = new int[values.length][size+1];
		for(int k=0; k<values.length; k++){
			for(int w=0; w<=size; w++){
				if(k == 0){
					if(weights[k] > w){
						table[k][w] = 0;
						path[k][w] = -1;
					}
					else{
						table[k][w] = values[k];
						path[k][w] = k;
					}
				}
				else if(weights[k] > w){
					table[k][w] = table[k-1][w];
					path[k][w] = path[k-1][w];
				}
				else{
					if(table[k-1][w] > table[k-1][w-weights[k]]+values[k]){
						table[k][w] = table[k-1][w];
						path[k][w] = path[k-1][w];
					}
					else{
						table[k][w] = table[k-1][w-weights[k]]+values[k];
						path[k][w] = k;	
					}
				}
			}
		}
		return table[values.length-1][size];
	}
}
