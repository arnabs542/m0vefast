public boolean wildcardMatch(String input, String pattern) {
		boolean[][] dp = new boolean[input.length() + 1][pattern.length() + 1];
		dp[0][0] = true;
		for (int i = 0; i < pattern.length(); i++) {
			if (pattern.charAt(i) == '*') {
				dp[0][i + 1] = dp[0][i];
			}
		}
		for (int i = 1; i <= input.length(); i++) {
			for (int j = 1; j <= pattern.length(); j++) {
				if (pattern.charAt(j - 1) == '?' || input.charAt(i - 1) == pattern.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1];
				} else if (pattern.charAt(j - 1) == '*') {
					dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
				} else {
					dp[i][j] = false;
				}
			}
		}
		return dp[input.length()][pattern.length()];
  }
// a*: zero or more a
// a?: zero or one of a
// a+: at least one a
