//pre order:     3456789...
//like max path sum
public int longestConsecutiveSequenceBT(TreeNode root) {
        int[] max = new int[1];
        recur(root, max, null, 0);
        return max[0];
    }
    //root to leaf longest consecuritve sequence
    public void recur(TreeNode root, int[] max, int prev, int len) {
        if (root == null)
            return;

        if (prev != null && prev == root.val - 1) {
            len++;
        } else {
            len = 1;
        }
        max[0] = Math.max(max[0], len);
        recur(root.left, max, root.val, len);
        recur(root.right, max, root.val, len);
    }
// 这道题是典型孙老师教的直上直下找path的题，和maxmum subarray的处理思路是一样的，如果当前root.val满足和上一层consecutive，那就可以加到上一层的sequence，
// 我们就让当前sequence加1，并且更新max值，如果不满足consecutive，就以当前node作为新的sequence头部，重新开始计数当前sequence长度
