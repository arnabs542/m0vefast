// “a | babbbab | bab | aba” is a palindrome partitioning of “ababbbabbababa”.
// The minimum number of cuts needed is 3.
public int minCutsPalindromePartitions(Stinrg input){
	char[] arr = input.toCharArray();

	int n = arr.length;
	if(len == 0)
		return 0;
	//palindrom[left][right]: if the substring(left-1, right-1) is palindrome
 	boolean[][] palindrome  = new boolean[n+1][n+1];
	//res[i]: the min cuts for substring(0, i-1)
	int[] res = new int[n+1];
	for(int right = 1; right <= n; right++){
		//we at most need right cuts
		res[right] = right;  //res[0]initialize的结果是0，意味着在第一个character之前我们总是多切了一刀，最终需要把这一刀减去。
												//res[0] initialize成-1就不需要最后 -1了
		for(int left = right; left >= 1; left--){
			//calculate palindrom[left][right] first
			if(arr[left-1] == arr[right-1]){
				palindrome[left][right] = right - left == 1 || palindrome[left + 1][right-1];
			}
			//use palindrome[left][right] to calculate res[right]
			if(palindrome[left][right]){
				res[right] = Math.min(res[right], 1 + res[left -1]);
			}
		}
	}
	return res[n]-1;
}
//another solution:
public int minCut(String s) {
		if (input == null || input.length() <= 1)
			return 0; // don't need to cut
		    // minCut[m] means the min cut for index [0, m)
		    // Induction rule: M[i] = 0 if substring[0, i) isP
		    // M[i] = Math.min(M[j]) + 1, when substring[0, j] && substring[j + 1, m] isP
		    // where j < i
				__ __ __
		  	 0  1  2
				int[] min = new int[input.length()];
				min[0] = 0;
				for (int i = 1; i < min.length; i++) {
					// first check the case 1
					if (isPalindrome(input.substring(0, i + 1))) {
						min[i] = 0;  //such string no need to cut
						continue;
					}
					// case 2
					min[i] = i; // worst case, we may need i cut for (i + 1) long array
					for (int j = 0; j < i; j++) {
						String sub = input.substring(j + 1, i + 1);
						if (isPalindrome(sub)) {
							min[i] = Math.min(min[i], min[j] + 1);
						}
					}
				}
				return min[input.length() - 1];
			}

			private boolean isPalindrome(String input) {
				int i = 0;
				int j = input.length() - 1;
				while (i <= j) {
					if (input.charAt(i) != input.charAt(j)) {
						return false;
					} else {
						i++;
						j--;
					}
				}
				return true;
			}
