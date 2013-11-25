package trees;

import java.util.*;
public class TreeNodeDriver {
	static final int ADD = 0;
	static final int MINUS = 1;
	static final int TIMES = 2;
	static final int DIVIDE = 3;

	public static void main(String[] args){
//		int[] preorder = {1,2,4,3,6,5};
//		int[] inorder = {4,2,1,6,3,5};
//		TreeNode<Integer> tree = ReconstructTree.reconstructTree(preorder, inorder);
//		System.out.println(tree.value);
		
		TreeNode<Integer> root = new TreeNode<Integer>(1);
		root.left = new TreeNode<Integer>(2);
		root.right = new TreeNode<Integer>(3);
		root.left.left = new TreeNode<Integer>(4);
		root.left.right = new TreeNode<Integer>(5);
		root.right.left = new TreeNode<Integer>(6);
		root.right.left.left = new TreeNode<Integer>(9);
		root.right.left.right = new TreeNode<Integer>(10);
		root.right.right = new TreeNode<Integer>(7);
		PrintClockwise.printClockwise(root);
		
//		TreeNode<Integer> root = new TreeNode<Integer>(ADD);
//		root.left = new TreeNode<Integer>(TIMES);
//		root.right = new TreeNode<Integer>(MINUS);
//		root.left.left = new TreeNode<Integer>(5);
//		root.left.right = new TreeNode<Integer>(7);
//		root.right.left = new TreeNode<Integer>(5);
//		root.right.right = new TreeNode<Integer>(ADD);
//		root.right.right.left = new TreeNode<Integer>(0);
//		root.right.right.right = new TreeNode<Integer>(15);
//		//System.out.println(contains(root, new TreeNode<Integer>(0)));
//		//System.out.println(isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
//		//printNodesAtH(root, 3);
////		System.out.println(findClosest(root, 4));
//		System.out.println(computeBET(root));
	}
	public static int computeBET(TreeNode<Integer> root){
		if(root == null)
			return Integer.MIN_VALUE;
		if(root.left == null && root.right == null)
			return root.value;
		if(root.left == null || root.right == null)
			return Integer.MIN_VALUE;
		switch(root.value){
		case ADD:
			return computeBET(root.left)+computeBET(root.right);
		case MINUS:
			return computeBET(root.left)-computeBET(root.right);
		case TIMES:
			return computeBET(root.left)*computeBET(root.right);
		default:
			return computeBET(root.left)/computeBET(root.right);
		}
	}
	static int findClosest(TreeNode<Integer> root, int m){
		if(root == null)
			return Integer.MAX_VALUE;
		if(root.value == m)
			return m;
		int d = Math.abs(m-root.value);
		if(root.value < m){
			int dr = findClosest(root.right, m);
			return (d < Math.abs(dr-m)) ? root.value : dr;
		}
		else{
			int dl = findClosest(root.left, m);
			return (d<Math.abs(dl-m)) ? root.value : dl;
		}
	}
	
	static void printNodesAtH(TreeNode<Integer> n, int h){
		if(n == null)
			return;
		if(h==0){
			System.out.println(n.value);
			return;
		}
		printNodesAtH(n.left, h-1);
		printNodesAtH(n.right, h-1);
	}
	
	public static boolean isBST(TreeNode<Integer> root, int min, int max){
		if(root == null)
			return true;
		return root.value >= min && root.value < max&& isBST(root.left, min, root.value) && isBST(root.right, root.value, max);		
	}
	
	public static void breadthFirst(TreeNode<Integer> root){
		Queue<TreeNode<Integer>> q = new LinkedList<TreeNode<Integer>>();
		q.offer(root);
		while(!q.isEmpty()){
			TreeNode<Integer> current = q.remove();
			System.out.println(current.value);
			if(current.left != null)
				q.offer(current.left);
			if(current.right != null)
				q.offer(current.right);
		}
	}
	public static boolean contains(TreeNode<Integer> root, TreeNode<Integer> p){
		if(root == null)
			return false;
		return root.value == p.value || contains(root.left, p) || contains(root.right, p);
	}
}
