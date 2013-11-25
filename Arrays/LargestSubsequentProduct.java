package Arrays;

public class LargestSubsequentProduct {
	public static double largestSubsequentProduct(double[] array){
		double max = array[0];
		double maxP = (max > 0) ? max : -1;
		double maxN = (max < 0) ? max : 1;
		for(int i=1; i<array.length; i++){
			double current = array[i];
			if(current >= 1){
				maxP = Math.max(current, current*maxP);
				maxN = (maxN < 0) ? maxN*current : maxN;
			}
			else if(current > 0){ // 0 < current < 1
				//if maxP < 0 then maxP will by default go to current, otherwise it will go to the larger of product and current
				//if maxN < 0 then maxN will not change, otherwise, it will be the new product
				double product = maxP*current;
				maxP = Math.max(product, current);
				maxN = (maxN < 0) ? maxN*current : maxN;
			}
			else if(current <= -1){
				double temp = maxP;
				if(maxN < 0){
					maxP = maxN*current;
					maxN = Math.min(current, temp*current);
				}
				else{
					maxP = -1;
					maxN = Math.min(current, temp*current);
				}
			}
			else if(current < 0){ // -1 < current < 0
				double temp = maxP;
				//if maxN defined, then maxP is new product, otherwise undefined
				maxP = (maxN < 0) ? current*maxN : -1;
				maxN = Math.min(temp*current, current);
			}
			else if(Math.abs(current) < .000001){//zero case
				maxP = 1;
				maxN = -1;
			}
			max = Math.max(max, maxP);
		}
		return max;
	}
}
