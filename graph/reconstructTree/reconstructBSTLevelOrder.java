public TreeNode reconstruct(int[] level) {
    // Assumptions: a. level is not null; b. no duplicates;
    List<Integer> levelList = new ArrayList<>();
    for (int i = 0; i < level.length; i++) {
         levelList.add(level[i]);
    }
    return helper(levelList);
  }

  private TreeNode helper(List<Integer> levelList) {
    if (levelList.size() == 0) { // base case
  	return null;
    }
    int rootValue = levelList.get(0);
    TreeNode root = new TreeNode(rootValue);
    List<Integer> left = new ArrayList<>();
    List<Integer> right = new ArrayList<>();
    for (int i = 1; i < levelList.size(); i++) {
    	int cur = levelList.get(i);
    	if (cur < rootValue) {
    		left.add(cur);
    	} else {
    		right.add(cur);
      }
    }
    root.left = helper(left);
    root.right = helper(right);
    return root;
  }
