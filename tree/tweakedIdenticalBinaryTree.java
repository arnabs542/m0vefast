public boolean isTeakedIdentical(TreeNode one, TreeNode two){
	if(one == null && two == null) 
		return true;
	else if(one == null || two == null)
		return false;
	else if(one.key != two.key)
		return false;
	return isTeakedIdentical(one.left, two.left) 
	&& isTeakedIdentical(one.right, two.right)
	|| isTeakedIdentical(one.left, two.right) 
	&& isTeakedIdentical(one.right, two.left);
}
