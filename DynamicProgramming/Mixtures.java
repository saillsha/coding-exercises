package DynamicProgramming;
//http://www.spoj.com/problems/MIXTURES/
public class Mixtures {
	public static void main(String[] args){
		int[] mixes = {40,60,20};
		System.out.println(mixtures(mixes));
	}
	public static int mixtures(int[] mixes){
		int n = mixes.length;
		int[][] sums = new int[n][n];
		int[][] products = new int[n][n];
		for(int i=0; i<n; i++){
			sums[i][i] = mixes[i];
			products[i][i] = 0;
		}
		for(int len=2; len <= n; len++){
			for(int startPos = 0; startPos+len <= n; startPos++){
				int endPos = startPos + len-1;
				int minProduct = Integer.MAX_VALUE;
				int minSum = 0;
				for(int partition = startPos; partition < endPos; partition++){
					if(products[startPos][partition]+products[partition+1][endPos]+
							sums[startPos][partition]*sums[partition+1][endPos]<minProduct){
						minProduct = products[startPos][partition]+products[partition+1][endPos]+
								sums[startPos][partition]*sums[partition+1][endPos];
						minSum = (sums[startPos][partition] + sums[partition+1][endPos] )%100;
					}
				}
				products[startPos][endPos] = minProduct;
				sums[startPos][endPos] = minSum;
			}
		}
		return products[0][n-1];
	}
}
