package trees;
/*
    Given a pre-order and post-order traversal of a tree, reconstruct the original tree
*/
public class ReconstructTree {
	public static TreeNode<Integer> reconstructTree(int[] preorder, int[] inorder){
		if(preorder == null || inorder == null || preorder.length != inorder.length)
			return null;
		return reconstructTreeAux(preorder, inorder, 0, preorder.length-1, 0, inorder.length-1);
	}
	private static TreeNode<Integer> reconstructTreeAux(int[] preorder, int[] inorder, int preLeft, int preRight, int inLeft, int inRight){
		TreeNode<Integer> root = new TreeNode<Integer>(preorder[preLeft]);
		int inIndex = findIndex(inorder, root.value);
		if(inIndex > inLeft)
			root.left = reconstructTreeAux(preorder, inorder, preLeft+1, preLeft+(inIndex-inLeft), inLeft, inIndex-1);
		if(inIndex < inRight)
			root.right = reconstructTreeAux(preorder, inorder, preRight-(inRight-inIndex)+1, preRight, inIndex+1, inRight);
		return root;
	}
	private static int findIndex(int[] array, Integer search){
		for(int index=0; index<array.length; index++)
			if(array[index] == search)
				return index;
		return -1;
	}
}
