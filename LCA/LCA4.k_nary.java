class TreeNode{
	int key;
	List<TreeNode> children;
}
public class Solution{
	public TreeNode LCA4(TreeNode root, TreeNode node1, TreeNode node2){
		if(root == null)
			return null;
		if(root == node1 || root == node2)
			return root;

		int counter = 0;  //record how many children contain target node
		TreeNode temp = null;   //temp return node

		for(TreeNode child : children){
			TreeNode node = LCA4(child, node1, node2);  //1)
			if(node != null){
				counter++;    //2)
				if(counter > 1)     //same as: counter = 2  //
					return root;   //3)
				temp = node;
			}
		}
		return temp;   //3)
	}
}
