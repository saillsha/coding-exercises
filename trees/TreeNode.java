package trees;

public class TreeNode<T> {
	public TreeNode<T> left;
	public TreeNode<T> right;
	T value;
	public TreeNode(T t){
		value = t;
		left = null;
		right = null;
	}
	
}
