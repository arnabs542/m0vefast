class TreeNode{
	int key;
	List<TreeNode> children;
}
public class Solution{
	public TreeNode LCA4(TreeNode root, Set<TreeNode> set){
		if(root == null)
			return null;
		if(set.contains(root))
			return root;

		int counter = 0;  //record how many children contain target node
		TreeNode temp = null;   //temp return node 

		for(TreeNode child : root.children){
			TreeNode node = LCA4(child, set);
			if(node != null){
				counter++;
				if(counter > 1)  
					return root;
				temp = node;
			}
		}
		return temp;
	}
}
