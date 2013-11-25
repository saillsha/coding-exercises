package Arrays;

public class ProbabilityOfAlive {
	public static double probabilityOfAlive(int x, int y, int n){
		int[][][] island = new int[n][n][2];
		for(int i=0; i<n; i++)
			for(int j=0; j<n; j++)
				island[i][j][1] = checkBoundary(i,j, n);
		for(int steps=2;steps <= n; steps++)
			for(int i=0; i<n; i++)
				for(int j=0; j<n; j++){
					int up = (i == 0) ? (int)Math.pow(4, steps-1) : island[i-1][j][(steps-1)%2];
					int down = (i == n-1) ? (int)Math.pow(4, steps-1) : island[i+1][j][(steps-1)%2];
					int left = (j == 0) ? (int)Math.pow(4, steps-1) : island[i][j-1][(steps-1)%2];
					int right = (j == n-1 ) ? (int)Math.pow(4, steps-1) : island[i][j+1][(steps-1)%2];
					island[i][j][steps%2] = up + down+left+right;
				}
		return 1-island[x][y][n%2]/Math.pow(4, n);
	}
	private static int checkBoundary(int x, int y, int n){
		n--;
		if(x % n == 0 && y % n == 0)
			return 2;
		if(x % n == 0 || y % n == 0)
			return 1;
		return 0;
	}
}
