//solution1: DP O(s.length*t.length)
public int LCS(String s, String t){
	int slength = s.length();
	int tlength = t.length();
	int m[][] = new int[slength+1][tlength+1];
	for(int i = 1; i <= slengthl i++){
		for(int j = 1; j <= tlength; j++){
			m[i][j] = Math.max(m[i-1][j], m[i][j-1]);
			if(s.charAt(i-1) == t.charAt(j-1))
				m[i][j] = m[i-1][j-1]+1;
		}
	}
	return m[slength][tlength];
}

