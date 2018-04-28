public class NumNodesLeft{
	static class TreeNode{
		int key;
		TreeNode left;
		TreeNode right;
		int numNodesLeft;
		public TreeNode(int key){
			this.key = key;
		}
	}
	private void numNodesLeft(TreeNode root){
		numNodes(root);
	}
	private int numNodes(TreeNode root){
		if(root == null)
			return 0;
		int leftNum = numNodes(root.left);
		int rightNum = numNodes(root.right);
		root.numNodesLeft = leftNum;
		return leftNum + rightNum+1;
	}
}