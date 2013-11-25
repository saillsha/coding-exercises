
public class Divide {
	public static void main(String[] args){
		System.out.println(divide(16, 16));
	}
	public static int divide(int n, int d){
		int q = 0;
		while(d<=n){
			n-=d;
			q++;
		}
		return q;
	}
}
