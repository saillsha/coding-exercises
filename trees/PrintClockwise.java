package trees;
//print the boundary of a full binary tree in a clockwise fashion
public class PrintClockwise {
	public static void printClockwise(TreeNode<Integer> root){
		pcAux(root, true, true);
	}
	private static void pcAux(TreeNode<Integer> n, boolean isLeft, boolean isRight){
		if(n == null)
			return;
		if(isLeft){
			System.out.println(n.value);
			pcAux(n.left, isLeft, false);
			pcAux(n.right, false, isRight);
		}
		else if(isRight){
			pcAux(n.left, isLeft, false);
			pcAux(n.right, false, isRight);
			System.out.println(n.value);
		}
		else if(n.left == null && n.right == null){
			System.out.println(n.value);
		}
		else{
			pcAux(n.left, false, false);
			pcAux(n.right, false, false);
		}
	}
}
