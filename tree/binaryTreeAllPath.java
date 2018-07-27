public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if(root== null)
          return res;
        String path = "";
        dfs(root, path, res);
        return res;
    }
    private void helper(TreeNode node, String path, List<String> result){
        if(node == null)
          return;
        path += node.val;
        if(node.left == null && node.right ==null){
          result.add(path);
        }
        helper(node.left, path+"->", result);
        helper(node.right, path+"->", result);
        path = path.substring(0, path.length()-1);  //backtrack
    }


    public List<String> binaryTreePaths(TreeNode root){
      String path = "";
      List<String> res = new ArrayList<>();
      dfs(root, res, path);
      return res;
    }
    private void dfs(TreeNode root, List<String> res, String path){
      if(root == null)
        return;
      path = path + "->" + root.value;
      if(root.left == null && root.right == null){
        res.add(path.substring(2));  //substring from index 2 to the end
        return;
      }
      if(root.left != null){
        dfs(root.left, res, path);
      }
      if(root.right != null){
        dfs(root.right, res, path);
      }
    }
