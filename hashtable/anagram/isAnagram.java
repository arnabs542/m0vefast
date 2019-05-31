//isAnagram
public boolean anagram(String a, String t){
	if(a.length() != b.length())
		return false;
	int[] count = new int[256];
	for(int i = 0; i < a.length(); i++)
		count[(int)s.charAt(i)]++;
	for(int i = 0; i < b.length(); i++){
		count[(int)b.charAt(i)]--;
		if(count[(int)b.charAt(i) < 0])
			return false;
	}
	return true;
}