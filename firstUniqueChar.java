//first position unique character
public int firstUniqChar(String s){
	int[] count = new int[256];
	for(char c : s.toCharArray())
		count[c]++;
	for(int i = 0; i < s.length(); i++){
		if(count[c.charAt(i)] == 1)
			return i;
	}
	return -1;
}