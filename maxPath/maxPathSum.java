//maxPathSum1: from leaf to root
//maxPathSum2: from any node to any node
//maxPathSum3: 2 nodes can be the same and can only be on the path from root to one fo the leaf node
//pathSumTarget: 2 nodes can be the same and can only be on the path from root to one fo the leaf node


//maxPathSum1: from leaf to root
//solution1:pass down the prefix sum
public int maxPathSum1(TreeNode root){
	return helper(root, 0);
}
private int helper(TreeNode root, int sum){
	sum += root.key;
	if(root.left == null && root.right == null)
		return sum;
	else if(root.left == null)
		return helper(root.right, sum);
	else if(root.right == null)
		return helper(root.left, sum);
	return Math.max(helper(root.left, sum), helper(root.right, sum));
}
//solution2: bottom_up return the max suffix sum
public int maxPathSum1(TreeNode root){
	if(root.left == null && root.right == null)
		return root.key;
	if(root.left == null)
		return maxPathSum3(root.right) + root.key;
	return root.key + Math.max(maxPathSum3(root.left), maxPathSum3(root.right));
}

//jiuzhang
//solution1:
// singlePath: 从root往下走到任意点的最大路径，这条路径可以不包含任何点
// maxPath: 从树中任意到任意点的最大路径，这条路径至少包含一个点
public class Solution{
	private class ResultType{
		int singlePath;
		int maxPath;
		ResultType(int singlePath, int maxPath){
			this.singlePath = singlePath;
			this.maxPath = maxPath;
		}
	}
	public int maxPathSum(TreeNode root){
		ResultType res = helper(root);
		return res.maxPath;
	}
	private ResultType helper(TreeNode root){
		if(root == null)
			return new ResultType(0, Integer.MIN_VLAUE);
		//divide
		ResultType left = helper(root.left);
		ResultType right = helper(root.right);
		//conquer
		int singlePath = Math.max(left.singlePath, right.singlePath) + root.value;
		singlePath = Math.max(singlePath, 0);

		int maxPath = Math.max(left.maxPath, right.maxPath);
		maxPath = Math.max(singlePath, maxPath);

		return new ResultType(singlePath, maxPath);
	}
}
//solution2:
// SinglePath也定义为，至少包含一个点。
public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: An integer.
     */
    private class ResultType {
        int singlePath, maxPath;
        ResultType(int singlePath, int maxPath) {
            this.singlePath = singlePath;
            this.maxPath = maxPath;
        }
    }

    private ResultType helper(TreeNode root) {
        if (root == null) {
            return new ResultType(Integer.MIN_VALUE, Integer.MIN_VALUE);
        }
        // Divide
        ResultType left = helper(root.left);
        ResultType right = helper(root.right);

        // Conquer
        int singlePath =
            Math.max(0, Math.max(left.singlePath, right.singlePath)) + root.val;

        int maxPath = Math.max(left.maxPath, right.maxPath);
        maxPath = Math.max(maxPath,
                           Math.max(left.singlePath, 0) + 
                           Math.max(right.singlePath, 0) + root.val);

        return new ResultType(singlePath, maxPath);
    }

    public int maxPathSum(TreeNode root) {
        ResultType result = helper(root);
        return result.maxPath;;
        
    }

}
//solution3: lai
public int maxPathSum{
	int[] res = new int[]{Integer.MIN_VALUE};
	helper(root, res);
	return res[0];
}
private int helper(TreeNode root, int[] res){
	if(root == null)
		return 0;
	int left = helper(root.left, res);
	int right = helper(root.right, res);
	if(root.left != null && root.right != null){
		res[0] = Math.max(res[0], left + right + root.value);
		return Math.max(left, right) + root.value;
	}
	return root.left == null ? right + root.value : left + root.key;
}









