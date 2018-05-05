//assumption: input is not null
public int minCuts(Stinrg input){
	char[] arr = input.toCharArray();

	int n = arr.length;
	if(len == 0)
		return 0;

	boolean[][] palindrome  = new boolean[n+1][n+1];
	int[] res = new int[n+1];
	for(int right = 1; right <= n; right++){
		res[right] = right;
		for(int left = right; left >= 1; left--){
			if(arr[left-1] == arr[left-1]){
				palindrome[left][right] = right - left < 2 || palindrome[left + 1][right-1];
			}
			if(palindrome[left][right]){
				res[right] = Math.min(res[right], 1 + res[left -1]);
			}
		}
	}
	return res[n]-1;
}


