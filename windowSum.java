public int[] winSum(int[] nums, int k) {
	if(nums == null || nums.length < k || k <= 0)
		return new int[0];
	int[] res = new int[nums.length - k + 1];
	for(int i = 0; i< k; i++)
		res[0] += nums[i];
	for(int j = 1; j < res.length; j++)
		res[j] = res[j-1] - nums[j-1] + nums[j-1+k];
	return res;
}
