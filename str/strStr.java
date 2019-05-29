public int strstr(String large, String small) {
	if(larget == null || small == null)
		return -1;
	if(large.length() < small.length())
		return -1;
	if(small.length() == 0)
		return 0;
	//all possible starting/matching index
	for(int i = 0; i < large.length() - small.length() + 1; i++){
		int j = 0;
		for(int j = 0; j < small.length(); j++){
			if(large.charAt(i+j) != small.charAt(j))
				break;
		}
		if(j == small.length())
			return i;
	}
	return -1;
}
